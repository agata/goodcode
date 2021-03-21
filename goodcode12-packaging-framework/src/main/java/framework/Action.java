package framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Action {
	
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	abstract public void execute() throws Exception;
	
	protected void forward(String path) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void redirect(String path) throws IOException {
		response.sendRedirect(path);
	}

	protected void error(int statusCode) throws IOException {
		response.sendError(statusCode);
	}
}
