package goodcode.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * ToDoのエンティティクラス
 */
@Entity
public class Todo {

	@Id
	private Integer id;
	private Integer accountId;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
