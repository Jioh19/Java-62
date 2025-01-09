package com.edutecno.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.api.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}
