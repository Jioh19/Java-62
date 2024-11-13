package com.edutecno.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.edutecno.excepciones.CuentaException;


class CuentaTest {
    
    // Clase concreta para testing que hereda de Cuenta
    private class CuentaPrueba extends Cuenta {
        public CuentaPrueba(String numero, Cliente cliente) {
            super(numero, cliente);
        }

        @Override
        public void depositar(double deposito) throws CuentaException {
            if (!canDepositar(deposito)) {
                throw new CuentaException("Monto inválido para depósito");
            }
            saldo += deposito;
        }

        @Override
        public void retirar(double retiro) throws CuentaException {
            if (!canRetirar(retiro)) {
                throw new CuentaException("Monto inválido para retiro");
            }
            saldo -= retiro;
        }

        @Override
        public boolean canDepositar(double deposito) {
            return deposito > 0;
        }

        @Override
        public boolean canRetirar(double retiro) {
            return retiro > 0 && saldo >= retiro;
        }
    }

    private Cuenta cuenta;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Juan", "Pérez", "12345678-9");
        cuenta = new CuentaPrueba("123456", cliente);
    }

    @Test
    @DisplayName("Test Constructor: Debe inicializar correctamente")
    void testConstructor() {
        assertEquals("123456", cuenta.getNumero(), "El número de cuenta debe coincidir");
        assertEquals(0.0, cuenta.getSaldo(), "El saldo inicial debe ser cero");
        assertNotNull(cuenta.getCliente(), "El cliente no debe ser null");
        assertEquals("Juan", cuenta.getCliente().getNombre(), "El nombre del cliente debe coincidir");
        assertNotNull(cuenta.getTransaccionService(), "El servicio de transacciones no debe ser null");
    }

    @Test
    @DisplayName("Test Depositar: Monto positivo válido")
    void testDepositarValido() throws CuentaException {
        cuenta.depositar(1000.0);
        assertEquals(1000.0, cuenta.getSaldo(), "El saldo debe aumentar en 1000");
    }

    @Test
    @DisplayName("Test Depositar: Monto negativo inválido")
    void testDepositarMontoNegativo() {
        Exception exception = assertThrows(CuentaException.class, () -> {
            cuenta.depositar(-100.0);
        }, "Debe lanzar CuentaException para montos negativos");
        
        assertTrue(exception.getMessage().contains("inválido"), 
            "El mensaje debe indicar que el monto es inválido");
    }

    @Test
    @DisplayName("Test Retirar: Monto válido con saldo suficiente")
    void testRetirarValido() throws CuentaException {
        cuenta.depositar(1000.0);
        cuenta.retirar(500.0);
        assertEquals(500.0, cuenta.getSaldo(), 
            "El saldo debe disminuir correctamente");
    }

    @Test
    @DisplayName("Test Retirar: Monto mayor al saldo")
    void testRetirarMontoMayorAlSaldo() throws CuentaException {
        cuenta.depositar(500.0);
        Exception exception = assertThrows(CuentaException.class, () -> {
            cuenta.retirar(1000.0);
        }, "Debe lanzar CuentaException cuando no hay saldo suficiente");
    }

    @Test
    @DisplayName("Test Retirar: Monto negativo")
    void testRetirarMontoNegativo() {
        Exception exception = assertThrows(CuentaException.class, () -> {
            cuenta.retirar(-100.0);
        }, "Debe lanzar CuentaException para montos negativos");
    }

    @Test
    @DisplayName("Test Múltiples Operaciones")
    void testMultiplesOperaciones() throws CuentaException {
        cuenta.depositar(1000.0);
        cuenta.retirar(300.0);
        cuenta.depositar(500.0);
        
        assertEquals(1200.0, cuenta.getSaldo(), 
            "El saldo final debe ser correcto después de múltiples operaciones");
    }

    @Test
    @DisplayName("Test Getters")
    void testGetters() {
        assertEquals("123456", cuenta.getNumero());
        assertEquals(0.0, cuenta.getSaldo());
        assertNotNull(cuenta.getCliente());
        assertNotNull(cuenta.getTransaccionService());
    }
}
