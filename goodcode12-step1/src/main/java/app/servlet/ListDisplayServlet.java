package app.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.entity.Todo;

public class ListDisplayServlet extends HttpServlet {

	private static final long serialVersionUID = -6306293372378163108L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// ToDoリストの作成、実際はDBなどから取得する
		List<Todo> todoList = new ArrayList<Todo>();
		todoList.add(new Todo("原稿を仕上げる", "締め切りは6/1日"));
		todoList.add(new Todo("髪を切る", "パーマかけようかな"));
		req.setAttribute("todoList", todoList);
		req.getRequestDispatcher("/list.jsp").forward(req, res);
	}	
}
