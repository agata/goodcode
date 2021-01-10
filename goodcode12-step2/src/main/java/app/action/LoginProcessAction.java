package app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.servlet.Action;

public class LoginProcessAction extends Action {

	private static final long serialVersionUID = -6306293372378163108L;

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		var loginId = req.getParameter("loginId");
		var password = req.getParameter("password");
		req.setAttribute("loginId", loginId);
		req.setAttribute("password", password);
		
		if (loginId == null || loginId.length() == 0) {
			req.setAttribute("errorMessage", "ログインIDは必須です");
			req.getRequestDispatcher("/login.jsp").forward(req, res);
			return;
		}
		if (password == null || password.length() == 0) {
			req.setAttribute("errorMessage", "パスワードは必須です");
			req.getRequestDispatcher("/login.jsp").forward(req, res);
			return;
		}
		if (!(loginId.equals("user1") && password.equals("password"))) {
			req.setAttribute("errorMessage", "ユーザーIDまたはパスワードが一致しません");
			req.getRequestDispatcher("/login.jsp").forward(req, res);
			return;
		}
		res.sendRedirect(req.getContextPath() +  "/list.action");
	}
	
}
