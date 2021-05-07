package eTradeDemo.business.abstracts;

import eTradeDemo.entities.concretes.User;

public interface UserService {
	void register(User user);
	void login(User user);
}
