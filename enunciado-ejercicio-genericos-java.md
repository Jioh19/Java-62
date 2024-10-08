# Ejercicio: Implementación de una Pila Genérica en Java

## Objetivo
Implementar una estructura de datos de pila (stack) genérica en Java que pueda trabajar con cualquier tipo de dato.

## Requisitos

1. Crear una clase llamada `GenericStack<T>` que represente una pila genérica.

2. La clase debe tener los siguientes métodos:
   - `push(T item)`: Añade un elemento a la parte superior de la pila.
   - `T pop()`: Elimina y devuelve el elemento en la parte superior de la pila. Debe lanzar una excepción si la pila está vacía.
   - `T peek()`: Devuelve el elemento en la parte superior de la pila sin eliminarlo. Debe lanzar una excepción si la pila está vacía.
   - `boolean isEmpty()`: Devuelve true si la pila está vacía, false en caso contrario.
   - `int size()`: Devuelve el número de elementos en la pila.

3. Utilizar un `ArrayList<T>` como estructura de datos subyacente para almacenar los elementos.

4. En la clase principal (`Main`):
   - Crear una instancia de `GenericStack<Integer>` y otra de `GenericStack<String>`.
   - Realizar operaciones de push y pop en ambas pilas.
   - Imprimir el contenido de las pilas después de las operaciones.

## Ejemplo de uso

```java
GenericStack<Integer> intStack = new GenericStack<>();
intStack.push(1);
intStack.push(2);
intStack.push(3);
System.out.println("Elemento superior de intStack: " + intStack.peek());
System.out.println("Elemento eliminado de intStack: " + intStack.pop());
System.out.println("Tamaño de intStack: " + intStack.size());

GenericStack<String> stringStack = new GenericStack<>();
stringStack.push("Hola");
stringStack.push("Mundo");
System.out.println("Elemento superior de stringStack: " + stringStack.peek());
System.out.println("¿stringStack está vacía? " + stringStack.isEmpty());
```

## Evaluación
El ejercicio será evaluado en base a:
1. Correcta implementación de la clase genérica `GenericStack<T>`.
2. Implementación adecuada de todos los métodos requeridos.
3. Manejo correcto de excepciones para operaciones en una pila vacía.
4. Uso apropiado de genéricos en la declaración de la clase y métodos.
5. Código limpio, bien estructurado y comentado.
