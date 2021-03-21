package goodcode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import goodcode.entity.Todo;
import goodcode.service.TodoService;

/**
 * {@link TodoService}の実装クラス
 */
@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
  
	@Override
	public Todo findById(final Integer id) {
		String query = "select * from todo where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<Todo>(Todo.class));
	}

	@Override
	public List<Todo> findByAccountId(final Integer accountId) {
		String query = "select * from todo where account_id = ?";
		return jdbcTemplate.query(query, new Object[] {accountId}, new BeanPropertyRowMapper<Todo>(Todo.class));
	}

}
