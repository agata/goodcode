package goodcode.controllers.utility;

import static goodcode.util.Strings.isEmpty;
import goodcode.entity.Item;
import org.springframework.stereotype.Controller;

@Controller
public class ListController extends BaseController {
    public String getItemName(Item item) {
        return isEmpty(item.getName()) ? "商品名未設定" : item.getName();
    }
}
 
