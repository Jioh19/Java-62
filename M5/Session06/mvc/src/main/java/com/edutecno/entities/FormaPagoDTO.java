package com.edutecno.entities;

public class FormaPagoDTO {
	private int idFormaPago;
	private String descripcion;
	private String recarga;
	public FormaPagoDTO(int idFormaPago, String descripcion, String recarga) {
		super();
		this.idFormaPago = idFormaPago;
		this.descripcion = descripcion;
		this.recarga = recarga;
	}
	public FormaPagoDTO() {
		super();
	}
	public int getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRecarga() {
		return recarga;
	}
	public void setRecarga(String recarga) {
		this.recarga = recarga;
	}
	@Override
	public String toString() {
		return "FormaPagoDTO [idFormaPago=" + idFormaPago + ", descripcion=" + descripcion + ", recarga=" + recarga
				+ "]";
	}
	
//	public static void main(String[] args) {
//		FormaPagoDTO pago = new FormaPagoDTO();
//		pago.setDescripcion("Mi nueva forma de pago");
//		pago.setIdFormaPago(1);
//		pago.setRecarga("Mi recarga");
//		System.out.println(pago);
//	}
}
