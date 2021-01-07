package goodcode.service;

import java.util.List;

import goodcode.entity.Todo;

/**
 * ToDoのサービスクラス
 */
public interface TodoService {

	/**
	 * IDを指定してToDoを取得します。
	 * @param id ToDoのID
	 * @return 取得したToDo。対象のToDoが存在しない場合null
	 */
	Todo findById(Integer id);

	/**
	 * アカウントIDを指定してToDoのリストを取得します。
	 * @param accountId
	 * @return ToDoのリスト
	 */
	List<Todo> findByAccountId(Integer accountId);

}
