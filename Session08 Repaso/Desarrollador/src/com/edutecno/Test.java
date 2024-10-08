package com.edutecno;

public class Test {
	public static void main(String[] args) {
		Empleado emp1 = new Junior();
		emp1.setNombre("Juan");
		emp1.setSueldo(500000);
		emp1.setDireccion("Santiago");
		Empleado senior = new Senior();
		senior.setNombre("Edutecno");
		senior.setSueldo(2000000);
		senior.setDireccion("Las Condes");
		
		System.out.println(emp1);
		System.out.println(senior);
	}
}
