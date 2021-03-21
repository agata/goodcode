package app.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entity.Todo;
import app.servlet.Action;

public class ListAction extends Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// ToDoリストの作成、実際はDBなどから取得する
		List<Todo> todoList = new ArrayList<Todo>();
		todoList.add(new Todo("原稿を仕上げる", "締め切りは6/1日"));
		todoList.add(new Todo("髪を切る", "パーマかけようかな"));
		req.setAttribute("todoList", todoList);
		req.getRequestDispatcher("/list.jsp").forward(req, res);
	}
	
}
