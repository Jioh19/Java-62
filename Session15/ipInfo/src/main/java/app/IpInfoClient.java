package app;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.City;
import model.IpResponse;

public class IpInfoClient {

	private static final String API_URL = "https://api.ipbase.com/v2/info?apikey=ipb_live_HQMNnSnXReXJkSLXNhgG5oYXEMAHeD23IfXhLftl&ip=201.189.219.190";

	public City getCityInfo() {
		Client client = ClientBuilder.newClient();

		try {
			WebTarget target = client.target(API_URL);

			Response response = target.request(MediaType.APPLICATION_JSON).get();

			System.out.println(response.getStatus());
			IpResponse ipResponse = response.readEntity(IpResponse.class);
			System.out.println(ipResponse.getData().getLocation().getCity());
			return ipResponse.getData().getLocation().getCity();

		} finally {
			client.close();
		}
	}

	public static void main(String[] args) {
		IpInfoClient client = new IpInfoClient();

			City city = client.getCityInfo();
			System.out.println("Ciudad: " + city.getName());
			System.out.println("Nombre traducido: " + city.getName());

	}
}
