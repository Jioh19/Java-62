package calculadora.com.edutecno;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraCompleja implements CalculadoraStockSeguridad{

	@Override
	public List<Integer> calcula(List<Integer> numeros) {
		List<Integer> resultados = new ArrayList<>();
		for(int i = 0; i < numeros.size(); i++) {
			if(numeros.get(i) > 20) {
				resultados.add((int) (2 + Math.round(numeros.get(i)*0.1)));
			} else if(numeros.get(i) >= 10) {
				resultados.add((int) (2 + Math.round(numeros.get(i)*0.05)));
			} else {
				resultados.add(2);
			}
		}
		return resultados;
	}

}
