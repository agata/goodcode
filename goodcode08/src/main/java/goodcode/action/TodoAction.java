package goodcode.action;

import goodcode.entity.Account;
import goodcode.entity.Todo;
import goodcode.service.TodoService;

import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.cubby.action.SendError;
import org.seasar.framework.container.annotation.tiger.Binding;

/**
 * ステップ2　画面の実装
 */
public class TodoAction extends BaseAction {

    @Binding
    public TodoService todoService;

    @Binding
    public Account loginAccount;

    @RequestParameter
    public Integer id;

    public Todo todo;

    @Form
    @Path("/todo/{id}")
    public ActionResult index() {
        todo = todoService.findById(id);
        // 自分のToDoのみが閲覧可能
        if (todo == null
            || !todo.getAccountId().equals(loginAccount.getId())) {
            return new SendError(404);
        }
        return new Forward("/todo.jsp");
    }
}
