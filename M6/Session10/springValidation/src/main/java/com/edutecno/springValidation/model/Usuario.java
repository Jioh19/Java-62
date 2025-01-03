package com.edutecno.springValidation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="¡Su nombre de usuario no puede estar en blanco!")
	@Size(min = 4, max=15, message="Username debe ser entre 4 y 15 carácteres")
	private String username;
	@NotBlank(message="¡Su correo no puede estar en blanco!")
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message="Formato de correo incorrecto, intente nuevamente")
	private String email;
	@NotEmpty(message="¡Su contraseña no puede estar vacia")
	@Size(min = 4, max=15, message="Contraseña debe ser entre 4 y 15 carácteres")
	private String password;
}
