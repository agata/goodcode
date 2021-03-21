package goodcode.controllers.object1;

import goodcode.entity.Folder;
import org.springframework.stereotype.Controller;

@Controller
public class FolderController extends BaseController {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SHARED = 1;
    public void store(Folder folder) {
        if (isSharedFolder(folder)) {
            //...
        }
        //...
        if (isSharedFolder(folder)) {
            //...
        }
    }
    // 共有フォルダか？（folderの値を参照）
    public boolean isSharedFolder(Folder folder) {
        return folder.type == TYPE_SHARED;
    }
}

