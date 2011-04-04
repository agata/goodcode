package goodcode.action.step1;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;

@Path("/")
public class RootAction extends Action {

	@Path("")
	public ActionResult index() {
		return new Forward("index.jsp");
	}
}
