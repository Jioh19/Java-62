# Enunciado: Sistema de Menú para Restaurante de Comida Rápida

## Contexto
"BurgerCode" es una cadena de restaurantes de comida rápida que necesita un sistema para manejar su menú de hamburguesas y combos. El restaurante ofrece hamburguesas individuales y combos que incluyen hamburguesas, papas fritas y bebidas. La gerencia quiere un sistema flexible que permita crear, modificar y calcular precios de productos individuales y combos fácilmente.

## Objetivo
Desarrollar un programa en Java que implemente el menú de "BurgerCode".

## Requisitos

1. Implementar una interfaz `MenuItem` que declare los métodos comunes para todos los elementos del menú:
   - `getName()`: Retorna el nombre del ítem.
   - `getPrice()`: Retorna el precio del ítem.
   - `print()`: Imprime los detalles del ítem.

2. Crear clases para los productos individuales que implementen `MenuItem`:
   - `Hamburger`: Representa una hamburguesa individual.
   - `Fries`: Representa una porción de papas fritas.
   - `Drink`: Representa una bebida.

3. Implementar una clase `Combo` que también implemente `MenuItem`:
   - Debe poder contener múltiples `MenuItem` (hamburguesas, papas fritas, bebidas).
   - El precio del combo debe ser la suma de sus componentes con un descuento del 10%.

4. Crear una clase `Menu` que actúe como el componente raíz:
   - Debe poder agregar tanto productos individuales como combos.
   - Debe tener un método para imprimir todo el menú con precios.

5. En la clase principal (`Main`):
   - Crear varios productos individuales.
   - Crear al menos dos combos diferentes.
   - Agregar todos los ítems a un `Menu`.
   - Imprimir el menú completo.

## Ejemplo de Salida Esperada

```
BurgerCode Menu:

Individual Items:
- Classic Burger: $5.99
- Cheese Burger: $6.99
- Small Fries: $2.99
- Medium Fries: $3.99
- Small Soda: $1.99
- Medium Soda: $2.49

Combos:
1. Classic Combo (10% off):
   - Classic Burger
   - Medium Fries
   - Medium Soda
   Total: $11.72

2. Double Cheese Combo (10% off):
   - Cheese Burger
   - Cheese Burger
   - Large Fries
   - Large Soda
   Total: $18.89

Total Menu Items: 8
```


