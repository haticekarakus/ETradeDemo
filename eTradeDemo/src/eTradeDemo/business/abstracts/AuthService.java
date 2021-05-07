package eTradeDemo.business.abstracts;

import eTradeDemo.entities.concretes.User;

public interface AuthService {
	boolean validate(User user);
	boolean login(User user);
	boolean verification(User user);
}
