package eTradeDemo.business.concretes;

import java.util.regex.Pattern;

import eTradeDemo.business.abstracts.AuthService;
import eTradeDemo.entities.concretes.User;

public class AuthManager implements AuthService{

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean validate(User user) {
		if(passwordLengthCheck(user) && firstNameLengthCheck(user) && lastNameLengthCheck(user) && emailFormatCheck(user)){
			return true;
		}
		return false;
	}
	
	private boolean passwordLengthCheck(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Parola en az 6 krakter uzunluðunda olmalýdýr.");
			return false;
		}
		return true;
	}
	
	private boolean firstNameLengthCheck(User user) {
		if(user.getFirstName().length()<2) {
			System.out.println("Adýnýz iki karakterden büyük olmalý.");
			return false;
		}
		return true;
	}
	
	private boolean lastNameLengthCheck(User user) {
		if(user.getLastName().length()<2) {
			System.out.println("soyadýnýz iki karakterden büyük olmalý.");
			return false;
		}
		return true;
	}

	private boolean emailFormatCheck(User email) {
		boolean result= VALID_EMAIL_ADDRESS_REGEX.matcher(email.getEmail()).find();
		if(result==false) {
			System.out.println("E-mail adresinizi kontrol edin");
		}
		return result;
	}
	
	@Override
	public boolean login(User user) {
		if(loginCheck(user)) {
			return true;
		}
		
		return false;
	}
	
	private boolean loginCheck(User user) {
		String Email="hatice.df@gmail.com";
		String Password="123456";
		if(user.getEmail()==null || user.getPassword()==null) {
			System.out.println("E-mail veya parola eksik");
			return false;
		}
		else if( Email!=user.getEmail() || Password!=user.getPassword()) {
			System.out.println("Email veya parola hatalý.");
			return false;
		}
		return true;
	}
	public boolean verification(User user) {
		System.out.println("Epostanýzý onaylýyor musunuz?(Yes/No): ");
		String answer="Yes";
		if(answer=="Yes") {
			return true;
		}
		return false;
	}

}
