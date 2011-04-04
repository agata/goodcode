package goodcode.action.method;

import goodcode.entity.Account;

public class StoreAction extends BaseAction {
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
