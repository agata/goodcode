package goodcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import goodcode.auth.LoginAccount;
import goodcode.entity.Todo;
import goodcode.exception.NotFoundException;
import goodcode.service.TodoService;

/**
 * ステップ2　画面の実装
 */
@Controller
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private LoginAccount loginAccount;

    @RequestMapping("/todo/{id}")
    public String index(Model model, @PathVariable("id") Integer id) {
        Todo todo = todoService.findById(id);
        // 自分のToDoのみが閲覧可能
        if (todo == null
            || !todo.getAccountId().equals(loginAccount.getAccountId())) {
            throw new NotFoundException();
        }
        model.addAttribute("todo", todo);
        return "todo";
    }
}
