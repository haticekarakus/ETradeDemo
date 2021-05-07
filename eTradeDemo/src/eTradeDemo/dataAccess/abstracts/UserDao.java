package eTradeDemo.dataAccess.abstracts;

import java.util.List;

import eTradeDemo.entities.concretes.User;

public interface UserDao {
	void register(User user);
	void login(User user);
	void logout(User user);
	User get(int id);
	List<User> getAll(); 

}
