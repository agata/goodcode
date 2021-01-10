package app.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 8853568811756299786L;
	private Properties route ;

	@Override
	public void init() throws ServletException {
		route = new Properties();
		try {
			route.load(getClass().getClassLoader().getResourceAsStream("route.properties"));
		} catch (IOException e) {
			throw new ServletException("route.propetiesが読み込めません", e);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		execute(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		execute(req, res);
	}

	private void execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		var path = req.getRequestURI().substring(req.getContextPath().length());
		var action = findAction(path);
		if (action == null) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			try {
				action.setRequest(req);
				action.setResponse(res);
				action.execute();
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	private Action findAction(String path) throws ServletException {
		if (!route.containsKey(path)) {
			return null;
		}
		var className = route.getProperty(path);
		try {
			var clazz = Class.forName(className);
			return (Action) clazz.newInstance();
		} catch (Exception e) {
			throw new ServletException("アクションの生成に失敗しました", e);
		}
	}

	private void handleException(Exception e) throws ServletException,
			IOException {
		if (e instanceof ServletException) {
			throw (ServletException) e;
		} else if (e instanceof IOException) {
			throw (IOException) e;
		} else {
			throw new ServletException(e.getMessage(), e);
		}
	}
}
