package goodcode.action;
import goodcode.RunDdlServletRequestListener;
import goodcode.entity.Account;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.SendError;
import org.seasar.cubby.unit.CubbyAssert;
import org.seasar.cubby.unit.CubbyRunner;
import org.seasar.framework.mock.servlet.MockHttpServletRequestImpl;
import org.seasar.framework.mock.servlet.MockHttpServletResponseImpl;
import org.seasar.framework.mock.servlet.MockServletContextImpl;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.PostBindFields;

@RunWith(Seasar2.class)
public class TodoActionTest {

    private TodoAction action;

    /**
     * DBの初期化とテストデータのセットアップ
     * テストの直前にsrc/main/resources/ddl.sqlを実行する
     * @throws Exception
     */
    @PostBindFields
    public void setUp() throws Exception {
    	RunDdlServletRequestListener l = new RunDdlServletRequestListener();
    	l.requestInitialized(null);
    }
    
    @Test
    public void testSuccess() throws Exception {
        // (1)テストの準備
        MockServletContextImpl ctx = new MockServletContextImpl("/");
        MockHttpServletRequestImpl req =
            new MockHttpServletRequestImpl(ctx, "/todo/1");
        req.setMethod("GET");
        MockHttpServletResponseImpl res =
            new MockHttpServletResponseImpl(req);

        // (2)ログインユーザをセット(ID=10000)
        Account loginAccount = new Account();
        loginAccount.setId(10000);
        action.loginAccount = loginAccount;

        // (3)アクションを実行
        ActionResult actualResult =
            CubbyRunner.processAction(ctx, req, res);
        // (4)アクションの実行結果を検証
        //  （エラー発生なし、todo.jspにフォワードするはず）
        CubbyAssert.assertPathEquals(
            Forward.class, "/todo.jsp", actualResult);
        // (5)取得したToDoの中身を検証
        Assert.assertEquals("ToDo1", action.todo.getContent());
    }
    
    @Test
    public void test404() throws Exception {
        // テストの準備
        MockServletContextImpl ctx = new MockServletContextImpl("/");
        MockHttpServletRequestImpl req =
            new MockHttpServletRequestImpl(ctx, "/todo/1");
        req.setMethod("GET");
        MockHttpServletResponseImpl res =
            new MockHttpServletResponseImpl(req);

        // (1)ログインユーザをセット（ID=10001）
        Account loginAccount = new Account();
        loginAccount.setId(10001);
        action.loginAccount = loginAccount;

        // アクションを実行
        SendError actualResult =
            (SendError) CubbyRunner.processAction(ctx, req, res);
        // (2)アクションの実行結果を検証
        //  （権限がないので404エラーが発生しているはず）
        Assert.assertEquals(404, actualResult.getStatusCode());
    }
}
