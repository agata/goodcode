package app.action;

import app.servlet.Action;

public class LoginAction extends Action {

	private static final long serialVersionUID = -6306293372378163108L;

	@Override
	public void execute() throws Exception {
		forward("/login.jsp");
	}
	
}
