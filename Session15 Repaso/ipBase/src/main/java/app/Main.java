package app;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.IpResponse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String IP = "201.189.219.190";
		final String API_KEY = "ipb_live_HQMNnSnXReXJkSLXNhgG5oYXEMAHeD23IfXhLftl";
		final String API_URL = "https://api.ipbase.com/v2/info?apikey=" + API_KEY + "&ip=" + IP;
	
		Client client = ClientBuilder.newClient();
		IpResponse ipResponse = null;
		try {
			WebTarget target = client.target(API_URL); 
			Response response = target.request(MediaType.APPLICATION_JSON).get();
			
			ipResponse = response.readEntity(IpResponse.class);
			
		} catch(Exception e) {
			System.out.println("hubo un error" + e);
		}
		
		System.out.println("Pais: " + ipResponse.data().location().country().name());
		System.out.println("Ciudad: " + ipResponse.data().location().city().name());
		System.out.println("Region: " + ipResponse.data().location().region().name());

		/*
		 * Invocation.Builder invocationBuilder =
target.request(MediaType.APPLICATION_JSON);
Response respuestaPublicaciones = invocationBuilder.get();
List<publicacion> listaPublicaciones =
respuestaPublicaciones.readEntity(new GenericType<list<publicacion>>() {
});
		 */
	}

}
