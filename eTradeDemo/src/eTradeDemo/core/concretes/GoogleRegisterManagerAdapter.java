package eTradeDemo.core.concretes;

import eTradeDemo.core.abstracts.RegisterService;
import eTradeDemo.register.GoogleRegisterManager;

public class GoogleRegisterManagerAdapter implements RegisterService{

	@Override
	public void registerWithgoogle(String message) {
		GoogleRegisterManager manager=new GoogleRegisterManager();
		manager.googleRegister(message);
	}
	

}
