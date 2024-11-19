package miPrimeraSession;

import java.util.Date;

public class EntradaConcierto {
	private String titularEntrada;
	private String nombreArtista;
	private String ubicacion;
	private Date fechaConcierto;

	// getter y setters
	public String getTitularEntrada() {
		return titularEntrada;
	}

	public void setTitularEntrada(String titularEntrada) {
		this.titularEntrada = titularEntrada;
	}

	public String getNombreArtista() {
		return nombreArtista;
	}

	public void setNombreArtista(String nombreArtista) {
		this.nombreArtista = nombreArtista;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFechaConcierto() {
		return fechaConcierto;
	}

	public void setFechaConcierto(Date fechaConcierto) {
		this.fechaConcierto = fechaConcierto;
	}

	// constructor estandar public EntradasConcierto() { super();}
	// constructor con parametros
	
	public EntradaConcierto(String titularEntrada, String nombreArtista, 
			String ubicacion, Date fechaConcierto) {
		super();
		this.titularEntrada = titularEntrada; this.nombreArtista =
		nombreArtista; this.ubicacion = ubicacion; this.fechaConcierto =
		fechaConcierto;
		}
}
