package com.edutecno.dao;

import java.util.List;

import com.edutecno.modelo.DepartamentoEmpleado;

public interface DepartamentoEmpleadoDao {
	List<DepartamentoEmpleado> obtieneDepartamento(String nomDepto);
}
