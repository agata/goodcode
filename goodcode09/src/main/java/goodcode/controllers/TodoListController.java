package goodcode.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import goodcode.auth.LoginAccount;
import goodcode.service.TodoService;

@Controller
public class TodoListController {

	@Autowired
	private TodoService todoService;

	@Autowired
	private LoginAccount loginAccount;

	@RequestMapping("/list")
	public String get(Model model, HttpServletRequest request) {
		var todoList = todoService.findByAccountId(loginAccount.getAccountId());
		model.addAttribute("todoList", todoList);
		return "list";
	}
}