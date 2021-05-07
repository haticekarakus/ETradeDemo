package eTradeDemo;

import eTradeDemo.business.concretes.AuthManager;
import eTradeDemo.business.concretes.UserManager;
import eTradeDemo.core.concretes.GoogleRegisterManagerAdapter;
import eTradeDemo.dataAccess.concretes.InMemoryUserDao;
import eTradeDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user=new User(1,"Hatice","Karakuþ","123456","hatice.df@gmail.com");
		UserManager manager=new UserManager(new InMemoryUserDao(),new AuthManager(),new GoogleRegisterManagerAdapter());
		manager.register(user);
		manager.login(user);
	}

}
