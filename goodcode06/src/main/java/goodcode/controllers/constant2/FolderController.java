package goodcode.controllers.constant2;

import goodcode.entity.Folder;
import org.springframework.stereotype.Controller;

@Controller
public class FolderController extends BaseController {
    // 定数を定義（特定の値を集約している）
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SHARED = 1;
    public void store(Folder folder) {
        if (folder.type == TYPE_NORMAL
            || folder.type == TYPE_SHARED) {
            //...
        }
        //...
        if (folder.type == TYPE_SHARED) {
            //...
        }
    }
}

