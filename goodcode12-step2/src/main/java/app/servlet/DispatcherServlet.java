package app.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.action.ListAction;
import app.action.LoginAction;
import app.action.LoginProcessAction;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 8853568811756299786L;

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
		String path = req.getRequestURI().substring(req.getContextPath().length());
		Action action = findAction(path);
		if (action == null) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			try {
				action.execute(req, res);
			} catch (Exception e) {
				handleException(e);
			}
		}
	}

	private Action findAction(String path) {
		if ("/login.action".equals(path)) {
			return new LoginAction();
		} else if ("/loginProcess.action".equals(path)) {
			return new LoginProcessAction();

		} else if ("/list.action".equals(path)) {
			return new ListAction();
		}
		return null;
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
