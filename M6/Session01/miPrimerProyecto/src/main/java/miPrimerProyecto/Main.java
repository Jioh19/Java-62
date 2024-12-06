package miPrimerProyecto;

import com.edutecno.model.Cliente;
import com.edutecno.model.Cuenta;
import com.edutecno.model.CuentaCorriente;

public class Main {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setApellido("Oh");
		usuario.setSaldo(42000);
		System.out.println(usuario);
		Cliente cliente = new Cliente("Juan", "Oh", "15335679-3");
		System.out.println(cliente);
		Cuenta cuenta = new CuentaCorriente("123456", cliente);
		System.out.println(cuenta);
	}

}
