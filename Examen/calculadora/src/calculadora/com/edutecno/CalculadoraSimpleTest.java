package calculadora.com.edutecno;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CalculadoraSimpleTest {

private CalculadoraSimple calculadora = new CalculadoraSimple();
    
    @Before
    public void setUp() {
        calculadora = new CalculadoraSimple();
    }
    
    @Test
    public void testCalculaListaVacia() {
        // Arrange
        List<Integer> numeros = new ArrayList<>();
        
        // Act
        List<Integer> resultado = calculadora.calcula(numeros);
        
        // Assert
        assertTrue(resultado.isEmpty());
    }
    
    @Test
    public void testCalculaListaUnElemento() {
        // Arrange
        List<Integer> numeros = Arrays.asList(5);
        
        // Act
        List<Integer> resultado = calculadora.calcula(numeros);
        
        // Assert
        assertEquals(1, resultado.size());
        assertEquals(Integer.valueOf(2), resultado.get(0));
    }
    
    @Test
    public void testCalculaListaVariosElementos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
        
        // Act
        List<Integer> resultado = calculadora.calcula(numeros);
        
        // Assert
        assertEquals(5, resultado.size());
        for (Integer num : resultado) {
            assertEquals(Integer.valueOf(2), num);
        }
    }
    
    @Test
    public void testCalculaRetornaMismaLongitud() {
        // Arrange
        List<Integer> numeros = Arrays.asList(10, 20, 30);
        
        // Act
        List<Integer> resultado = calculadora.calcula(numeros);
        
        // Assert
        assertEquals(numeros.size(), resultado.size());
    }
    
    @Test
    public void testCalculaNoModificaListaOriginal() {
        // Arrange
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> numerosOriginal = new ArrayList<>(numeros);
        
        // Act
        calculadora.calcula(numeros);
        
        // Assert
        assertEquals(numerosOriginal, numeros);
    }
    
    @Test
    public void testCalculaTodosResultadosSonDos() {
        // Arrange
        List<Integer> numeros = Arrays.asList(100, 200, 300, 400);
        
        // Act
        List<Integer> resultado = calculadora.calcula(numeros);
        
        // Assert
        for (Integer num : resultado) {
            assertEquals(Integer.valueOf(2), num);
        }
    }
}
