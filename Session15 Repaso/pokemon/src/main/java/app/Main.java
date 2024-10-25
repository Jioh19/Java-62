package app;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Move;
import model.Moves;
import model.PokeResponse;
import model.PokemonResponse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String API_URL = "https://pokeapi.co/api/v2/pokemon/?limit=5";
		
		long start = System.nanoTime();
		Map<String, Move> movimientos = new HashMap<>();
		
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target(API_URL);
		Response response1 = target.request(MediaType.APPLICATION_JSON).get();
		PokeResponse pokeResponse = response1.readEntity(PokeResponse.class);

		for(model.Response response: pokeResponse.results()) {
			//System.out.println(response.url());
			target = client.target(response.url());
			Response response2 = target.request(MediaType.APPLICATION_JSON).get();
			PokemonResponse pokemonResponse = response2.readEntity(PokemonResponse.class);
			
			for(Moves move: pokemonResponse.moves()) {
			//	System.out.println(move.move().url());
				
				//Move movePower = movimientos.get(move.move().url());

			//	if(movePower == null) {
					target = client.target(move.move().url());
					Response response3 = target.request(MediaType.APPLICATION_JSON).get();
					Move movePower = response3.readEntity(Move.class);
				//	movimientos.put(move.move().url(), movePower);
			//	}
				
				System.out.println(movePower.name() +  " " + movePower.power());
				
			}
		}
		long end = System.nanoTime();
		System.out.println(end-start);
	}
//9634788241
}
