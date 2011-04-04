package goodcode.action.utility;

import static goodcode.util.Strings.isEmpty;
import goodcode.entity.Account;

public class StoreAction extends BaseAction {
    public void store(Account account) {
        if (isEmpty(account.getFirstName()) 
        		|| isEmpty(account.getLastName())) {
            return;
        }
    }
}
