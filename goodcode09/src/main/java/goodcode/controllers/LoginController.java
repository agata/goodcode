package goodcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import goodcode.auth.LoginAccount;

@Controller
public class LoginController {
	
	@Autowired
	private LoginAccount loginAccount;

	public static class LoginForm {
		public Integer accountId;

		public void setAccountId(Integer accountId) {
			this.accountId = accountId;
		}

		public Integer getAccountId() {
			return this.accountId;
		}
	}

	@RequestMapping("/login")
	public String get(LoginForm form) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String post(LoginForm form) {
		loginAccount.setAccountId(form.getAccountId());
		return "redirect:/list";
	}

}