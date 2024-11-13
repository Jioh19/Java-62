# Clase: Maps y Stream API en Java

## 1. Maps en Java
### 1.1 Introducción a Maps
Un Map es una estructura de datos que almacena pares clave-valor. En Java, tenemos varias implementaciones:
- HashMap: No garantiza orden
- LinkedHashMap: Mantiene orden de inserción
- TreeMap: Mantiene orden natural de las claves

### 1.2 Operaciones Básicas con Maps
```java
// Crear un Map
Map<String, Integer> calificaciones = new HashMap<>();

// Insertar elementos
calificaciones.put("Juan", 95);
calificaciones.put("María", 88);

// Obtener valor
Integer notaJuan = calificaciones.get("Juan"); // 95

// Verificar existencia
boolean existeMaria = calificaciones.containsKey("María"); // true

// Eliminar elemento
calificaciones.remove("Juan");

// Iterar sobre un Map
for (Map.Entry<String, Integer> entrada : calificaciones.entrySet()) {
    System.out.println(entrada.getKey() + ": " + entrada.getValue());
}
```

### 1.3 Métodos Útiles
```java
// Obtener valor o valor por defecto
Integer nota = calificaciones.getOrDefault("Pedro", 0);

// Actualizar valor si existe
calificaciones.replace("María", 90);

// Insertar si no existe
calificaciones.putIfAbsent("Carlos", 85);
```

## 2. Stream API
### 2.1 ¿Qué es Stream API?
Stream API permite procesar colecciones de objetos de manera declarativa. Introduce programación funcional a Java.

### 2.2 Creación de Streams
```java
// Desde una Lista
List<String> nombres = Arrays.asList("Juan", "María", "Pedro");
Stream<String> streamNombres = nombres.stream();

// Desde un Array
String[] arrayNombres = {"Juan", "María", "Pedro"};
Stream<String> streamArray = Arrays.stream(arrayNombres);

// Stream directo
Stream<Integer> numeros = Stream.of(1, 2, 3, 4, 5);
```

### 2.3 Operaciones Intermedias
```java
List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

// filter: filtrar elementos
numeros.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);

// map: transformar elementos
numeros.stream()
       .map(n -> n * 2)
       .forEach(System.out::println);

// sorted: ordenar elementos
numeros.stream()
       .sorted()
       .forEach(System.out::println);

// distinct: eliminar duplicados
numeros.stream()
       .distinct()
       .forEach(System.out::println);
```

### 2.4 Operaciones Terminales
```java
// collect: convertir stream a colección
List<Integer> pares = numeros.stream()
                            .filter(n -> n % 2 == 0)
                            .collect(Collectors.toList());

// reduce: combinar elementos
Optional<Integer> suma = numeros.stream()
                               .reduce((a, b) -> a + b);

// count: contar elementos
long cantidad = numeros.stream()
                      .filter(n -> n > 3)
                      .count();

// anyMatch, allMatch, noneMatch
boolean hayMayoresA5 = numeros.stream()
                             .anyMatch(n -> n > 5);
```

### 2.5 Ejemplo Práctico Combinando Maps y Streams
```java
Map<String, Integer> ventas = new HashMap<>();
ventas.put("Producto1", 100);
ventas.put("Producto2", 200);
ventas.put("Producto3", 300);

// Filtrar productos con ventas mayores a 150
List<String> productosMasVendidos = ventas.entrySet().stream()
    .filter(entry -> entry.getValue() > 150)
    .map(Map.Entry::getKey)
    .collect(Collectors.toList());

// Calcular total de ventas
int totalVentas = ventas.values().stream()
    .reduce(0, Integer::sum);
```

## 3. Ejercicios Prácticos

### 3.1 Ejercicio con Maps
```java
// Crear un sistema de conteo de palabras
public class ContadorPalabras {
    public static Map<String, Integer> contarPalabras(String texto) {
        Map<String, Integer> frecuencia = new HashMap<>();
        String[] palabras = texto.toLowerCase().split("\\s+");
        
        for (String palabra : palabras) {
            frecuencia.merge(palabra, 1, Integer::sum);
        }
        return frecuencia;
    }
}
```

### 3.2 Ejercicio con Streams
```java
// Procesar una lista de empleados
class Empleado {
    String nombre;
    double salario;
    String departamento;
    
    // Constructor y getters
}

// Calcular promedio de salarios por departamento
Map<String, Double> promedioSalariosPorDepartamento = empleados.stream()
    .collect(Collectors.groupingBy(
        Empleado::getDepartamento,
        Collectors.averagingDouble(Empleado::getSalario)
    ));
```

## 4. Buenas Prácticas
1. Usar el tipo de Map más apropiado según el caso
2. Preferir métodos de la API de Stream sobre bucles tradicionales
3. Considerar el rendimiento al encadenar múltiples operaciones
4. Usar métodos terminales eficientes
5. Cerrar streams cuando se usan recursos externos

## 5. Tips de Rendimiento
1. Para operaciones paralelas, usar `parallelStream()`
2. Evitar operaciones stateful cuando sea posible
3. Usar el método `forEach` con precaución
4. Considerar el tamaño de la colección al elegir entre stream y loop tradicional
