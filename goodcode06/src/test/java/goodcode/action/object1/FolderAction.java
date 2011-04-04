package goodcode.action.object1;

import goodcode.entity.Folder;

public class FolderAction extends BaseAction {
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

