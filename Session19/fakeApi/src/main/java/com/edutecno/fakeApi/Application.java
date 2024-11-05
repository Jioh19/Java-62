package com.edutecno.fakeApi;

import java.util.ArrayList;
import java.util.List;

import com.edutecno.model.User;
import com.edutecno.repository.UserRepository;
import com.edutecno.view.Menu;

public class Application {
	

	public static void main(String[] args) {
		
		List<User> users = new ArrayList<>();
		
		Menu menu = new Menu(users);
		menu.startMenu();
//		UserRepository.load(users);
//		UserRepository.get(users, 1);
//		UserRepository.save(users);
//		users.forEach(System.out::println);
	
	}

	
}
