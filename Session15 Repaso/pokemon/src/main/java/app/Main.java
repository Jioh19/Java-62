package app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

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
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon/?limit=1300";
    private static final Client client = ClientBuilder.newClient();
    private static final Map<String, Move> moveCache = new HashMap<>();

    public static void main(String[] args) {
        long start = System.nanoTime();
        
        PokeResponse pokeResponse = fetchFromApi(API_URL, PokeResponse.class);
        
        List<CompletableFuture<PokemonResponse>> pokemonFutures = pokeResponse.results().stream()
            .map(pokemon -> CompletableFuture.supplyAsync(() -> fetchPokemonDetails(pokemon.url())))
            .collect(Collectors.toList());
        

        CompletableFuture.allOf(pokemonFutures.toArray(new CompletableFuture[0])).join();
        
        long end = System.nanoTime();
        System.out.println("Tiempo: " + (end - start) / 1000000000 + " segundos");
        

        client.close();
    }
    
    private static PokemonResponse fetchPokemonDetails(String url) {
        PokemonResponse pokemon = fetchFromApi(url, PokemonResponse.class);
        
        List<CompletableFuture<Void>> moveFutures = pokemon.moves().stream()
            .map(move -> CompletableFuture.runAsync(() -> fetchMoveDetails(move)))
            .collect(Collectors.toList());
        
        CompletableFuture.allOf(moveFutures.toArray(new CompletableFuture[0])).join();
        
        return pokemon;
    }
    
    private static void fetchMoveDetails(Moves move) {
        synchronized (moveCache) {
        	Move moveDetails = moveCache.get(move.move().url());
            if (moveDetails == null) {
                moveDetails = fetchFromApi(move.move().url(), Move.class);
                moveCache.put(move.move().url(), moveDetails);
                System.out.println(moveDetails.name() + " " + moveDetails.power());
            } else {
                System.out.println(moveDetails.name() + " " + moveDetails.power() + " Cached!!!");
            }
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