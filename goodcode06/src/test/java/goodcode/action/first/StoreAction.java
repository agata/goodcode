package goodcode.action.first;

import goodcode.entity.Account;

public class StoreAction extends BaseAction {
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
