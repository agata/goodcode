package goodcode.service;

import goodcode.entity.Division;
import goodcode.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("user1"));
		users.add(new User("user2"));
		users.add(new User("user3"));
		users.add(new User("user4"));
		users.add(new User("user5"));
		return users;
	}

	public List<Division> getDivisions() {
		List<Division> divs = new ArrayList<Division>();
		divs.add(new Division("1", "div1"));
		divs.add(new Division("2", "div2"));
		divs.add(new Division("3", "div3"));
		return divs;
	}

}
