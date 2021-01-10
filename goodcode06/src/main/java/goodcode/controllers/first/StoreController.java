package goodcode.controllers.first;

import goodcode.entity.Account;
import org.springframework.stereotype.Controller;

@Controller
public class StoreController extends BaseController {
    public void store(Account account) {
        if (account.getFirstName() == null
            || account.getFirstName().length() == 0) {
            return;
        }
        if (account.getLastName() == null
            || account.getLastName().length() == 0) {
            return;
        }
    }
}
