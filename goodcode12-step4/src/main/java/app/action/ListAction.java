package app.action;

import java.util.ArrayList;
import java.util.List;

import app.entity.Todo;
import app.servlet.Action;

public class ListAction extends Action {

	@Override
	public void execute() throws Exception {
		// ToDoリストの作成、実際はDBなどから取得する
		List<Todo> todoList = new ArrayList<Todo>();
		todoList.add(new Todo("原稿を仕上げる", "締め切りは6/1日"));
		todoList.add(new Todo("髪を切る", "パーマかけようかな"));
		request.setAttribute("todoList", todoList);
		forward("/list.jsp");
	}
	
}
