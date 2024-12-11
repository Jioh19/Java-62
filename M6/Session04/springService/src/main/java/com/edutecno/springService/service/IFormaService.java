package com.edutecno.springService.service;

import java.util.List;

import com.edutecno.springService.model.Forma;

public interface IFormaService {
	
	public boolean almacenarForma(int numero, String nombre);
	public List<Forma> obtenerForma();
}
