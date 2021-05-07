package eTradeDemo.business.concretes;

import eTradeDemo.business.abstracts.AuthService;
import eTradeDemo.business.abstracts.UserService;
import eTradeDemo.core.abstracts.RegisterService;
import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class UserManager implements UserService{
	
	private AuthService authService;
	private UserDao userDao;
	private RegisterService registerService;
	public UserManager(UserDao userDao,AuthService authService,RegisterService registerService) {
		this.authService=authService;
		this.userDao=userDao;
		this.registerService=registerService;
	}

	@Override
	public void register(User user) {
		for (User userFromDatabase : userDao.getAll()) {
			if (userFromDatabase.getEmail()==user.getEmail()) {
				System.out.println("Böyle bir kullanıcı zaten mevcut.");
			}
		}
		 if(authService.validate(user)) {
			 System.out.println("Doğrulama e-postanız gönderildi.");
			 authService.verification(user);
		 }
		 userDao.register(user);
		 registerService.registerWithgoogle("Google account : ");
	}

	@Override
	public void login(User user) {
		if(authService.login(user)) {
			userDao.login(user);
		}
	}

}
