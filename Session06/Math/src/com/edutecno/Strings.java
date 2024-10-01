package com.edutecno;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = """
				Provocar sus avasalla vinieran sol sociedad creencia. Ver esa caseria piernas parezca por rededor blandas estarlo. En ha garganta presente vinieran le. Una periodico tan los tentacion estuviera. Volvio dejase ha il tendra. Uso voz trataba acudian fin sobrina pasable los poblado. Estrepito no jugadores inocencia ay escenario mezclados el la. Dos prestar asi cristal dijeron comodas dominio simbolo.

				Incesante la adquirido protegida idealismo ocupacion no. Cuentos suertes iba natural sus castana asi han. Decian medica leguas ano vez decida las ganado dejaba. No blandas sacudio va ex aquella ordenes echarse su. Existencia estridente en preteritos el galantuomo pentagrama anaranjado. Los chi vio cara modo gris odio nos.

				Dio blasfemias compadecer pie non que reconditos. Enterada amenazas chi asfixiar una muy pre mientras. Temblando escaparme dos por colocarse simpatica exclusiva don. Animaba hacerlo recibio se la holgada. Andar mayor sr oh tales habla brisa un tu ruina. No bueno me libro ma es masde rueda. Conciertos molestarle era iba cataplasma holocausto. Tu es no en cristal todavia aquella llenaba morales. Friegas al hacerme ma recordo ni porches tocaban.

				Entregar iba pan inferior carisimo ama ido. Da nunca bicho angel ni diego. Garganta tan gas amorosas versatil. Aun encendidos por mas luz distinguir conciertos. Tenores les alcalde narices dificil dio. Telon tales morir menor esa tapiz don sin. Nueve con parar dar antes pre cogio. Van razon islas gordo paz oyo.

				No de tercer dejara no yo lienzo mismos cuadro miraba. Aburrida luz aca admirada perfiles mezquino muriendo continuo. Va alma fijo yo fina pudo cada ha peor. Tocando un glorias tampoco caridad de carrera ma la. Pero este bien unia soy mil pero bazo. Ser suspiraban encontrase mamarracho levantaban iba. Cristal opinion missure un apocado al. Ello al lema eran nada lo pais ay ni.
								""";
		//System.out.println(texto.toUpperCase());

		String[] lineas = texto.split("\n\n");
		String[][] palabras;
		palabras = new String[lineas.length][];
		for (int i = 0; i < lineas.length; i++) {
			palabras[i] = lineas[i].split(" ");
			System.out.println(i + " " + lineas[i]);
			
		}
		texto = texto.replace("\n\n", "\n");
		String[] oraciones = texto.split("\\.");
		System.out.println(texto);
		
//		System.out.println(oraciones);
//		for(int i = 0; i < oraciones.length; i++) {
//			System.out.println(i + " " + oraciones[i]);
//		}

		for(int i =0; i < palabras[0][0].length(); i++) {
			palabras[0][0] = "Otro String";
			System.out.println(palabras[0][0].charAt(i));
		}
	}

}
