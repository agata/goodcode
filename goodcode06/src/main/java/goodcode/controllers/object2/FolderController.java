package goodcode.controllers.object2;

import goodcode.entity.Folder;
import org.springframework.stereotype.Controller;

@Controller
public class FolderController extends BaseController {
	public void store(Folder folder) {
		if (folder.isShared()) {
			// ...
		}
		// ...
		if (folder.isShared()) {
			// ...
		}
	}
}
