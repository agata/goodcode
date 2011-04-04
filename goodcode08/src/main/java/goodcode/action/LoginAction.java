package goodcode.action;

import goodcode.entity.Account;

import org.seasar.cubby.action.Accept;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestMethod;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.framework.container.annotation.tiger.Binding;

/**
 * ログインアクション
 */
public class LoginAction extends BaseAction {

    @Binding
    public Account loginAccount;

    @RequestParameter
    public Integer accountId;
    
    @Path("/login")
    @Accept(RequestMethod.GET)
    public ActionResult index() {
        return new Forward("/login.jsp");
    }

    @Form
    @Path("/login")
    @Accept(RequestMethod.POST)
    public ActionResult post() {
    	loginAccount.setId(accountId);
        return new Redirect(TodoListAction.class);
    }
}
