package goodcode.entity;

public class Folder {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SHARED = 1;
	public int type;
	public String name;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    // 共有フォルダか？（自分自身の値を参照）
    public boolean isShared() {
        return type == TYPE_SHARED;
    }
}
