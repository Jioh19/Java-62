package model;

public class Curso {
	private int id;
	private String nombre;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Curso(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Curso() {
		super();
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
