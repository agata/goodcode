package goodcode.action.inheritance;

import goodcode.entity.Account;

public class StoreAction extends BaseAction {
    public void store(Account account) {
        if (isEmpty(account.getFirstName()) 
        		|| isEmpty(account.getLastName())) {
            return;
        }
    }
}
