package app.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract public class Action {
	abstract public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
