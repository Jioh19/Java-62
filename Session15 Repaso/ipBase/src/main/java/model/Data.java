package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Anotacion
@JsonIgnoreProperties(ignoreUnknown = true)
//Forma tradicional utilizando clases
//public class Data {
//	private Location location;
//
//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//}
public record Data(Location location) {}