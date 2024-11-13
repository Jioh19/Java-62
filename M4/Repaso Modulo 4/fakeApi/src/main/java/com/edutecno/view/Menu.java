package com.edutecno.view;

import java.util.List;
import java.util.Scanner;

import com.edutecno.model.User;
import com.edutecno.repository.UserRepository;

public class Menu extends MenuTemplate {
	private List<User> users;
	private Scanner sc = new Scanner(System.in);

	public Menu(List<User> users) {
		super();
		this.users = users;
	}

	@Override
	public void load() {
		UserRepository.load(users);

	}

	@Override
	public void save() {
		UserRepository.save(users);

	}

	@Override
	public void get() {
		System.out.println("Ingrese cantidad de usuarios a obtener");
		int cantidad = sc.nextInt();
		UserRepository.get(users, cantidad);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		users.forEach(System.out::println);
	}

	@Override
	public void startMenu() {
		
		String menu = """
				****************************************
				* 1- Cargar usuarios                   *
				* 2- Guardar usuarios                  *
				* 3- Obtener nuevos usuarios           *
				* 4- Mostrar usuarios                  *
				* 0- Salir                             *
				****************************************""";
		int option;
		do {
			System.out.println(menu);
			option = sc.nextInt();
			switch (option) {
			case 1:
				load();
				System.out.println("Usuarios Cargados");
				break;
			case 2:
				save();
				System.out.println("Usuarios guardados");
				break;
			case 3: 
				get();
				System.out.println("Usuarios obtenidos");
				break;
			case 4 :
				show();
				break;
			default:
				break;
			}
		} while (option != 0);
	}

}
