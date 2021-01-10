package app.action;

import app.servlet.Action;

public class LoginProcessAction extends Action {

	private static final long serialVersionUID = -6306293372378163108L;

	@Override
	public void execute() throws Exception {
		var loginId = request.getParameter("loginId");
		var password = request.getParameter("password");
		request.setAttribute("loginId", loginId);
		request.setAttribute("password", password);
		
		if (loginId == null || loginId.length() == 0) {
			request.setAttribute("errorMessage", "ログインIDは必須です");
			forward("/login.jsp");
			return;
		}
		if (password == null || password.length() == 0) {
			request.setAttribute("errorMessage", "パスワードは必須です");
			request.getRequestDispatcher("/step3/login.jsp").forward(request, response);
			return;
		}
		if (!(loginId.equals("user1") && password.equals("password"))) {
			request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが一致しません");
			forward("/login.jsp");
			return;
		}
		redirect(request.getContextPath() + "/list.action");
	}
	
}
