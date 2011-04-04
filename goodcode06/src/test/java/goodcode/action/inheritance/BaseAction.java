package goodcode.action.inheritance;

public class BaseAction {
    protected boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
