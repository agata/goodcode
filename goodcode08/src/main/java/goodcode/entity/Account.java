package goodcode.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * アカウントのエンティティクラス
 */
@Entity
public class Account implements Serializable {

	private static final long serialVersionUID = 685470901874526639L;

	@Id
	private Integer id;
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
