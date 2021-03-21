package goodcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import goodcode.twitter.Tweet;
import goodcode.twitter.TwitterAPI;

@Controller
public class TimelineController {
    @Autowired
    TwitterAPI twitterAPI;

    @RequestMapping("/timeline")
    public String index(Model model) {
        // ここの呼び出しが環境依存
        Tweet[] tweets = twitterAPI.getTimeline();
        model.addAttribute("tweets", tweets);
        return "timeline";
    }
}
