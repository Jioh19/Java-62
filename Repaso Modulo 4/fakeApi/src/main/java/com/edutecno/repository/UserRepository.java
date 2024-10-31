package com.edutecno.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.edutecno.model.Gender;
import com.edutecno.model.ListPeople;
import com.edutecno.model.Person;
import com.edutecno.model.User;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class UserRepository {

	private static final String ARCHIVO = "users.txt";
	private static final Client client = ClientBuilder.newClient();
	
	static public void get(List<User> users, int num) {
		String API_URL = "https://randomuser.me/api/?nat=es&results=" + num;
		Client client = ClientBuilder.newClient();

		ListPeople people = fetchFromApi(API_URL, ListPeople.class);

		for (Person person : people.results()) {
			User user = new User();
			user.setName(person.name().first());
			user.setLast(person.name().last());
			user.setEmail(person.email());
			user.setPhone(person.phone());
			user.setGender(person.gender());
			user.setUsername(person.login().username());
			user.setPassword(person.login().password());
			users.add(user);
		}
	}
	
	static public void save(List<User> users) {
		File file = new File(ARCHIVO);
		try(FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw)) {
			pw.println("nombre,apellido,email,telefono,genero,username,password");
			for(User user: users) {
				pw.println(user);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	
	public static void load(List<User> users) {
		File file = new File(ARCHIVO);
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr)) {
			br.readLine();
			for(String line; (line = br.readLine())!= null;) {
				String[] datos = line.split(",");
				User user = new User(
						datos[0],
						datos[1],
						datos[2],
						datos[3],
						Gender.valueOf(datos[4]),
						datos[5],
						datos[6]
								);
				users.add(user);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static <T> T fetchFromApi(String url, Class<T> responseType) {
		WebTarget target = client.target(url);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		T result = response.readEntity(responseType);
		response.close();
		return result;
	}
}
