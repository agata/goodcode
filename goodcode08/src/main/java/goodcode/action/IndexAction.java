package goodcode.action;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

@Path("/")
public class IndexAction extends Action {
	
	public ActionResult index() {
		return new Forward("index.jsp");
	}
	
}
