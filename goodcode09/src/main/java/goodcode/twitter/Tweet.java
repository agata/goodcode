package goodcode.twitter;

public class Tweet {

	private final String id;
	private final String text;

	public Tweet(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public String getText() {
		return text;
	}

}
