package goodcode.action;

import static org.junit.Assert.assertEquals;
import goodcode.twitter.Tweet;
import goodcode.twitter.TwitterAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.unit.CubbyAssert;
import org.seasar.cubby.unit.CubbyRunner;
import org.seasar.framework.mock.servlet.MockHttpServletRequestImpl;
import org.seasar.framework.mock.servlet.MockHttpServletResponseImpl;
import org.seasar.framework.mock.servlet.MockServletContextImpl;
import org.seasar.framework.unit.Seasar2;

@RunWith(Seasar2.class)
public class TimelineActionTest {
    // (3)テスト用のモックTwitter APIを定義
    class MockTwitterAPI implements TwitterAPI {
        public Tweet[] tweets;
        public Tweet[] getTimeline() {
            return tweets;
        }
    }

    public TimelineAction action;

    @Test
    public void testTimeline() throws Exception {
        // (4)モックオブジェクトを準備
        MockTwitterAPI twitterAPI = new MockTwitterAPI();
        twitterAPI.tweets = new Tweet[]{
            new Tweet("普通のプログラマ", "寝ます……。"),
            new Tweet("中級プログラマ", "おやすみ"),
            new Tweet("達人プログラマ", "ふぉっふぉっふぉっ")
        };
        // (5)実行するアクションのTwitter APIを
        //   モックオブジェクトに入れ替え
        action.twitterAPI = twitterAPI;

        // テストの準備
        MockServletContextImpl ctx = new MockServletContextImpl("/");
        MockHttpServletRequestImpl req =
            new MockHttpServletRequestImpl(ctx, "/timeline");
        req.setMethod("GET");
        MockHttpServletResponseImpl res =
            new MockHttpServletResponseImpl(req);

        // アクションを実行
        ActionResult actualResult =
            CubbyRunner.processAction(ctx, req, res);
        // アクションの実行結果を検証
        //（エラー発生なし、timeline.jspにフォワードするはず）
        CubbyAssert.assertPathEquals(
            Forward.class, "/timeline.jsp", actualResult);
        // 取得したタイムラインの中身を検証
        assertEquals(3, action.tweets.length);
    }
}
