package com.edutecno.miPrimerSpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
	private Integer id;
	@NotBlank(message="El nombre no debe estar en blanco")
	@Size(min=3, message ="El nombre debe tener al menos 3 letras")
	private String nombre;
	@NotEmpty(message="El password no debe estar vacio")
	@Size(min=8, message="El password debe contener al menos 8 letras")
	private String clave;
}
