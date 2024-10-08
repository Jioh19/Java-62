# Enunciado: Cálculo de Áreas de Figuras Geométricas

## Contexto
Una empresa de diseño arquitectónico necesita un sistema para calcular áreas de diferentes formas geométricas, tanto simples como compuestas. Este sistema será utilizado para estimar costos de materiales y diseñar espacios eficientemente.

## Objetivo
Desarrollar un programa en Java que permita calcular el área de figuras geométricas simples y compuestas utilizando el patrón de diseño Composite. Este patrón permitirá tratar las figuras simples y las compuestas de manera uniforme.

## Requisitos

1. Implementar una interfaz `Shape` que declare los métodos comunes para todas las figuras:
   - `getArea()`: Retorna el área de la figura.
   - `getName()`: Retorna el nombre de la figura.
   - `print()`: Imprime los detalles de la figura.

2. Crear clases para las figuras geométricas simples que implementen `Shape`:
   - `Circle`: Representa un círculo (parámetro: radio).
   - `Rectangle`: Representa un rectángulo (parámetros: largo y ancho).
   - `Triangle`: Representa un triángulo (parámetros: base y altura).

3. Implementar una clase `CompositeShape` que también implemente `Shape`:
   - Debe poder contener múltiples objetos `Shape` (figuras simples u otras figuras compuestas).
   - El área de una `CompositeShape` debe ser la suma de las áreas de sus componentes.

4. Crear una clase `ShapeManager` que actúe como el componente raíz:
   - Debe poder agregar tanto figuras simples como compuestas.
   - Debe tener un método para calcular e imprimir el área total de todas las figuras.

5. En la clase principal (`Main`):
   - Crear varias figuras simples (círculos, rectángulos, triángulos).
   - Crear al menos dos figuras compuestas que contengan tanto figuras simples como otras figuras compuestas.
   - Agregar todas las figuras a un `ShapeManager`.
   - Calcular e imprimir el área total y los detalles de todas las figuras.

## Ejemplo de Salida Esperada

```
Figuras Geométricas:

Figuras Simples:
1. Círculo (radio: 5.0) - Área: 78.54 unidades cuadradas
2. Rectángulo (largo: 4.0, ancho: 6.0) - Área: 24.00 unidades cuadradas
3. Triángulo (base: 3.0, altura: 4.0) - Área: 6.00 unidades cuadradas

Figuras Compuestas:
4. Casa:
   - Rectángulo (largo: 10.0, ancho: 8.0) - Área: 80.00 unidades cuadradas
   - Triángulo (base: 10.0, altura: 5.0) - Área: 25.00 unidades cuadradas
   Área total de Casa: 105.00 unidades cuadradas

5. Complejo:
   - Círculo (radio: 2.0) - Área: 12.57 unidades cuadradas
   - Casa:
     - Rectángulo (largo: 6.0, ancho: 4.0) - Área: 24.00 unidades cuadradas
     - Triángulo (base: 6.0, altura: 3.0) - Área: 9.00 unidades cuadradas
   Área total de Complejo: 45.57 unidades cuadradas

Área Total de todas las figuras: 259.11 unidades cuadradas
```

## Evaluación
El programa será evaluado en base a:
1. Correcta implementación del patrón Composite.
2. Precisión en los cálculos de áreas para figuras simples y compuestas.
3. Funcionalidad completa según los requisitos.
4. Buenas prácticas de programación y diseño orientado a objetos.
5. Código limpio, bien estructurado y documentado.
6. Manejo adecuado de decimales en los cálculos y la presentación de resultados.
