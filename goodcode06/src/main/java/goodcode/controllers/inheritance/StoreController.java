package goodcode.controllers.inheritance;

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
}
