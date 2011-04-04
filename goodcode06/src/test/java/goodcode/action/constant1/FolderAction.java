package goodcode.action.constant1;

import goodcode.entity.Folder;

public class FolderAction extends BaseAction {
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

