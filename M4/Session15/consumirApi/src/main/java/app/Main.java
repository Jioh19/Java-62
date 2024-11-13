package app;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import modelo.Publicacion;

public class Main {

	public static final String API_URL = "https://jsonplaceholder.typicode.com";
	public static final String API_PATH = "posts";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();

		// https://jsonplaceholder.typicode.com/posts
		WebTarget target = client.target(API_URL).path(API_PATH);

		// Invocamos una petición esperando a que nos entreguen un JSON
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

		// Ejecutamos el request de tipo Get() y guardamos la respuesta
		Response respuestaPublicaciones = invocationBuilder.get();

		// 
		List<Publicacion> listaPublicaciones = respuestaPublicaciones.readEntity(
				new GenericType<List<Publicacion>>() {});
		
		System.out.println(listaPublicaciones.get(0));
	}

}
