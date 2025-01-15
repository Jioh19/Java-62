package calculadora.com.edutecno;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraSimple implements CalculadoraStockSeguridad{

	@Override
	public List<Integer> calcula(List<Integer> numeros) {
		List<Integer> resultados = new ArrayList<>();
		for(int i = 0; i < numeros.size(); i++) {
			resultados.add(2);
		}
		return resultados;
	}

}
