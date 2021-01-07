package goodcode.controllers.constant1;

import goodcode.entity.Folder;
import org.springframework.stereotype.Controller;

@Controller
public class FolderController extends BaseController {
    public void store(Folder folder) {
        if (folder.type == 0
            || folder.type == 1) {
            //...
        }
        //...
        if (folder.type == 1) {
            //...
        }
    }
}

