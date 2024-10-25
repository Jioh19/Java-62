package app;

import java.util.ArrayList;
import java.util.List;

import Model.ChatRequest;
import Model.ChatResponse;
import Model.Message;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String API_URL = "https://chat-gpt26.p.rapidapi.com";
		final String API_KEY = "d65e35cc1bmsh98356a6a1b406d5p15d22fjsna89925268e21";
		
		
		Client client = ClientBuilder.newClient();
		
		List<Message> messages = new ArrayList<>();
		Message message = new Message();
		message.setRole("user");
		message.setContent("Cuentame el cuento de el gatito Ratanaz");
		messages.add(message);
		
		ChatRequest chatRequest = new ChatRequest();
		chatRequest.setModel("gpt-3.5-turbo");
		chatRequest.setMessages(messages);
		
		Response response = client.target(API_URL)
				.request(MediaType.APPLICATION_JSON)
				.header("x-rapidapi-key", API_KEY)
				.post(Entity.entity(chatRequest, MediaType.APPLICATION_JSON));
		
		ChatResponse jsonResponse = response.readEntity(ChatResponse.class);
		
		System.out.println(jsonResponse.choices().getFirst().message().getContent());
	}

}
