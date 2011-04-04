package app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.servlet.Action;

public class LoginAction extends Action {

	private static final long serialVersionUID = -6306293372378163108L;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.getRequestDispatcher("/login.jsp").forward(req, res);
	}
	
}
