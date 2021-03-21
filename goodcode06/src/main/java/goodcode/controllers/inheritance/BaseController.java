package goodcode.controllers.inheritance;

public class BaseController {
    protected boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
