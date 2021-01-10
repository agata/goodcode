package goodcode.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import goodcode.twitter.Tweet;
import goodcode.twitter.TwitterAPI;

@AutoConfigureMockMvc
@SpringBootTest
public class TimelineControllerTest {

    // (3)テスト用のモックTwitter APIを定義
    class MockTwitterAPI implements TwitterAPI {
        public Tweet[] tweets;
        public Tweet[] getTimeline() {
            return tweets;
        }
    }

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TimelineController timelineController;

    @Test
    public void testTimeline() throws Exception {
        // (4)モックオブジェクトを準備
        var twitterAPI = new MockTwitterAPI();
        twitterAPI.tweets = new Tweet[]{
            new Tweet("普通のプログラマ", "寝ます……。"),
            new Tweet("中級プログラマ", "おやすみ"),
            new Tweet("達人プログラマ", "ふぉっふぉっふぉっ")
        };
        // (5)実行するアクションのTwitter APIを
        //   モックオブジェクトに入れ替え
        timelineController.twitterAPI = twitterAPI;

        // (5)コントローラーを実行
        var mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/timeline")
                )
                // (6) ステータスは200のはず
                .andExpect(status().isOk())
                // (7) timelineの画面が表示されるはず
                .andExpect(view().name("timeline"))
                .andReturn();

        // (8) Modelにセットされたタイムラインの中身を検証
        var modelMap = mvcResult.getModelAndView().getModelMap();
        var tweets = (Tweet[]) modelMap.get("tweets");
        assertEquals(3, tweets.length);
    }

}