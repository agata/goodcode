package goodcode.entity;

/**
 * ToDoのエンティティクラス
 */
public class Todo {

	private Integer id;
	private Integer accountId;
	private String content;

	public Todo() {
	}

	public Todo(Integer id, Integer accountId, String content) {
		this.id = id;
		this.accountId = accountId;
		this.content = content;
	}

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
