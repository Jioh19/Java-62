package com.edutecno.controlAgricolaMyBatis.model;

import java.math.BigDecimal;

public class Arbol {
	private Integer id;
	private BigDecimal lng;
	private BigDecimal lat;
	private BigDecimal altura;
	private BigDecimal radio;
	private String tipo_arbol;
	private String tratamiento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getLng() {
		return lng;
	}
	public void setLng(BigDecimal lng) {
		this.lng = lng;
	}
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getAltura() {
		return altura;
	}
	public void setAltura(BigDecimal altura) {
		this.altura = altura;
	}
	public BigDecimal getRadio() {
		return radio;
	}
	public void setRadio(BigDecimal radio) {
		this.radio = radio;
	}

	public String getTipo_arbol() {
		return tipo_arbol;
	}
	public void setTipo_arbol(String tipo_arbol) {
		this.tipo_arbol = tipo_arbol;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	@Override
	public String toString() {
		return "Arbol [id=" + id + ", lng=" + lng + ", lat=" + lat + ", altura=" + altura + ", radio=" + radio
				+ ", tipo_arbol=" + tipo_arbol + ", tratamiento=" + tratamiento + "]";
	}

	
}
