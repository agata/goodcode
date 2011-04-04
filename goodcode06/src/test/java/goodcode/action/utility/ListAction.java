package goodcode.action.utility;

import static goodcode.util.Strings.isEmpty;
import goodcode.entity.Item;

public class ListAction extends BaseAction {
    public String getItemName(Item item) {
        return isEmpty(item.getName()) ? "商品名未設定" : item.getName();
    }
}
 
