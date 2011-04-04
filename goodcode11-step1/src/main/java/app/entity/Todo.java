package app.entity;

public class Todo {

	private String title;
	private String description;

	public Todo() {
	}

	public Todo(String title, String description) {
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String titile) {
		this.title = titile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
