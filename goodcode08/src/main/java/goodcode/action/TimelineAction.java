package goodcode.action;

import goodcode.twitter.Tweet;
import goodcode.twitter.TwitterAPI;
import goodcode.twitter.TwitterAPIImpl;

import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.SendError;

public class TimelineAction extends Action {
    public TwitterAPI twitterAPI = new TwitterAPIImpl();
    public Tweet[] tweets;

    @Path("/timeline")
    public ActionResult index() {
        // ここの呼び出しが環境依存
        tweets = twitterAPI.getTimeline();
        if (tweets.length == 0) {
            return new SendError(404);
        }
        return new Forward("/timeline.jsp");
    }
}
