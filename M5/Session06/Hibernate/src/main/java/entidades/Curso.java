
package entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cursos")
public class Curso {

	private int idCurso;
	private String descripcion;
	private double precio;

	public Curso() {
		super();
	}

	@Id
	@Column(name = "id_curso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cursoid")
	@SequenceGenerator(name = "cursoid", sequenceName = "cursoid", allocationSize = 1)
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	@Basic
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Basic
	@Column(name = "precio")
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
