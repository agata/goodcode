package goodcode.action.constant2;

import goodcode.entity.Folder;

public class FolderAction extends BaseAction {
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

