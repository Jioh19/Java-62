package com.edutecno.springService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.edutecno.springService.model.Forma;

@Service //@Component + Transactions
//@Qualifier("Forma1") En el caso de que hayan 2 servicios de la misma interface
public class FormaServicioImpl implements IFormaService{

	private List<Forma> formas;
	
	public FormaServicioImpl() {
		this.formas = new ArrayList<Forma>();
	}

	@Override
	public boolean almacenarForma(int numero, String nombre) {
		if(formas.stream().anyMatch(forma -> forma.getNumero() == numero)) {
			return false;
		} else {
			Forma forma = new Forma(nombre, numero);
			formas.add(forma);
			return true;
		}

	}

	@Override
	public List<Forma> obtenerForma() {
		return formas;
	}

}
