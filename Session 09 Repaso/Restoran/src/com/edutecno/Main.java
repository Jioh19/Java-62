package com.edutecno;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		MenuItem hamburguesaQueso = new Hamburguesa("Hamburguesa con Queso", 6500.0);
		MenuItem fantaGrande = new Bebida("Fanta grande", 2500.0);
		MenuItem papasGrandes = new Papa("Papas fritas grandes", 3500.0);
		
		//hamburguesaQueso.print();
		//fantaGrande.print();
		//papasGrandes.print();
		MenuItem[] items = {hamburguesaQueso, fantaGrande, papasGrandes};
		
		MenuItem combo1 = new Combo("Combo 1", items);
		
		//combo1.print();
		
		MenuItem[] menu = {hamburguesaQueso, fantaGrande, papasGrandes, combo1};
		
		System.out.println(Arrays.deepToString(menu));
 	}
}
