package goodcode.action;

import goodcode.entity.Account;
import goodcode.entity.Todo;
import goodcode.service.TodoService;

import java.util.List;

import org.seasar.cubby.action.Accept;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.RequestMethod;
import org.seasar.framework.container.annotation.tiger.Binding;

/**
 * ログインアクション
 */
public class TodoListAction extends BaseAction {

    @Binding
    public TodoService todoService;

    @Binding
    public Account loginAccount;

    public List<Todo> todoList;
    
    @Path("/list")
    @Accept(RequestMethod.GET)
    public ActionResult index() {
    	todoList = todoService.findByAccountId(loginAccount.getId());
        return new Forward("/list.jsp");
    }
}
