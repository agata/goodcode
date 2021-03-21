package goodcode.controllers.method;

import goodcode.entity.Account;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController extends BaseController {
    public void store(Account account) {
        if (isEmpty(account.getFirstName()) 
        		|| isEmpty(account.getLastName())) {
            return;
        }
    }
    // 重複部分をメソッドとして抽出
    private boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

}
