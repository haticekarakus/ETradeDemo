package eTradeDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTradeDemo.dataAccess.abstracts.UserDao;
import eTradeDemo.entities.concretes.User;

public class InMemoryUserDao implements UserDao{
	
	List<User> users=new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println("Kayýt olundu: " + user.getFirstName());
	}

	@Override
	public void login(User user) {
		System.out.println("Sisteme giriþ yapýldý : " +user.getFirstName());
	}

	@Override
	public void logout(User user) {
		System.out.println("Çýkýþ yapýldý : " +user.getFirstName());
	}

	@Override
	public User get(int id) {
		for(User user:this.users) {
			if(user.getId()==id) {
				System.out.println("Aranan kullanýcý: "+user.getFirstName());
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.users;
	}

}
