package goodcode.service.impl;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.framework.container.annotation.tiger.Binding;

import goodcode.entity.Todo;
import goodcode.service.TodoService;

/**
 * {@link TodoService}の実装クラス
 */
public class TodoServiceImpl implements TodoService {

	@Binding
	public JdbcManager jdbcManager;
	
	@Override
	public Todo findById(Integer id) {
		return jdbcManager.from(Todo.class).id(id).getSingleResult();
	}
	
	@Override
	public List<Todo> findByAccountId(Integer accountId) {
		return jdbcManager.from(Todo.class).where("account_id=?", accountId).orderBy("id").getResultList();
	}

}
