package com.edutecno.dao;

import java.util.List;

import com.edutecno.modelo.Empleado;

public interface EmpleadoDao {
	List<Empleado> getAll();
	List<Empleado> busquedaEmpleado (String nombre,int numEmpleado,
			int numDepartamento);
	void save(Empleado empleado);
	void delete(int id);
}
