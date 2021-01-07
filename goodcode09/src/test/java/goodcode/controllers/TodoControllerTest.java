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

import goodcode.auth.LoginAccount;
import goodcode.entity.Todo;

@AutoConfigureMockMvc
@SpringBootTest
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSuccess() throws Exception {
        // (1)ログインユーザを準備（ID=10000）
        var loginAccount = new LoginAccount();
        loginAccount.setAccountId(10000);

        // (2)ログインユーザーをリクエストにセット
        var builder = MockMvcRequestBuilders
            .get("/todo/1")
            .sessionAttr("scopedTarget.loginAccount", loginAccount);

        // (3)コントローラーを実行
        var mvcResult = mockMvc.perform(builder)
                // (4) ステータスは200のはず
                .andExpect(status().isOk())
                // (5) todoの画面が表示されるはず
                .andExpect(view().name("todo"))
                .andReturn();

        // (6) ModelにセットされたToDoの中身を検証
        var modelMap = mvcResult.getModelAndView().getModelMap();
        var todo = (Todo) modelMap.get("todo");
        assertEquals("ToDo1", todo.getContent());
    }

    @Test
    public void test404() throws Exception {
        // (1)ログインユーザーを準備（ID=10001）
        var loginAccount = new LoginAccount();
        loginAccount.setAccountId(10001);

        // (2)ログインユーザーをリクエストにセット
        var builder = MockMvcRequestBuilders
            .get("/todo/1")
            .sessionAttr("scopedTarget.loginAccount", loginAccount);

        // (3)コントローラーを実行
        mockMvc.perform(builder)
                // (4) 権限がないので404エラーが発生しているはず
                .andExpect(status().isNotFound());
    }

}