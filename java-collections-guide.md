# Guía Completa de Collections Framework en Java

## Índice
1. [Introducción](#introducción)
2. [Jerarquía de Collections](#jerarquía-de-collections)
3. [Interfaces Principales](#interfaces-principales)
4. [Implementaciones Comunes](#implementaciones-comunes)
5. [Algoritmos y Utilidades](#algoritmos-y-utilidades)
6. [Ejemplos Prácticos](#ejemplos-prácticos)

## Introducción

El Framework de Collections en Java proporciona una arquitectura unificada para almacenar y manipular grupos de objetos. Ofrece muchas interfaces, implementaciones y algoritmos que permiten un manejo eficiente de datos.

## Jerarquía de Collections

```
Collection (Interface)
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (Interface)
    ├── PriorityQueue
    └── Deque (Interface)
        ├── ArrayDeque
        └── LinkedList

Map (Interface)
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

## Interfaces Principales

### 1. Collection<E>
- Raíz de la jerarquía
- Métodos básicos: `add()`, `remove()`, `contains()`
- Operaciones en grupo: `addAll()`, `removeAll()`, `retainAll()`

### 2. List<E>
- Colección ordenada
- Permite duplicados
- Acceso posicional
- Métodos principales:
  ```java
  void add(int index, E element)
  E get(int index)
  E set(int index, E element)
  E remove(int index)
  ```

### 3. Set<E>
- No permite duplicados
- No garantiza orden (excepto implementaciones específicas)
- Métodos heredados de Collection

### 4. Queue<E>
- Diseñada para elementos en cola
- Típicamente orden FIFO
- Métodos principales:
  ```java
  boolean offer(E element)
  E peek()
  E poll()
  ```

### 5. Map<K,V>
- Mapeo de claves a valores
- No permite claves duplicadas
- Métodos principales:
  ```java
  V put(K key, V value)
  V get(Object key)
  boolean containsKey(Object key)
  boolean containsValue(Object value)
  ```

## Implementaciones Comunes

### ArrayList<E>
```java
// Creación y uso básico
ArrayList<String> lista = new ArrayList<>();
lista.add("Elemento 1");
lista.add("Elemento 2");
String elemento = lista.get(0);

// Operaciones comunes
lista.size();                 // Tamaño
lista.remove(0);             // Eliminar por índice
lista.contains("Elemento");   // Verificar existencia
```

### HashSet<E>
```java
// Creación y uso básico
HashSet<Integer> conjunto = new HashSet<>();
conjunto.add(1);
conjunto.add(2);
conjunto.add(1);  // No se añade (duplicado)

// Operaciones comunes
conjunto.size();          // Tamaño
conjunto.remove(1);       // Eliminar elemento
conjunto.contains(2);     // Verificar existencia
```

### HashMap<K,V>
```java
// Creación y uso básico
HashMap<String, Integer> mapa = new HashMap<>();
mapa.put("Uno", 1);
mapa.put("Dos", 2);

// Operaciones comunes
Integer valor = mapa.get("Uno");
mapa.remove("Dos");
mapa.containsKey("Uno");
```

## Algoritmos y Utilidades

### Collections Class
```java
// Ordenamiento
Collections.sort(lista);
Collections.reverse(lista);

// Búsqueda
Collections.binarySearch(lista, elemento);

// Mezcla
Collections.shuffle(lista);

// Sincronización
List<String> listaSincronizada = Collections.synchronizedList(new ArrayList<>());
```

## Ejemplos Prácticos

### 1. Gestión de Estudiantes
```java
class Estudiante {
    private String nombre;
    private int edad;
    
    // Constructor y getters/setters
}

// Usando ArrayList
List<Estudiante> estudiantes = new ArrayList<>();
estudiantes.add(new Estudiante("Juan", 20));
estudiantes.add(new Estudiante("Ana", 22));

// Filtrado y procesamiento
estudiantes.stream()
          .filter(e -> e.getEdad() > 21)
          .forEach(e -> System.out.println(e.getNombre()));
```

### 2. Control de Duplicados
```java
// Usando HashSet para eliminar duplicados
List<String> listaDuplicados = Arrays.asList("A", "B", "A", "C", "B");
Set<String> sinDuplicados = new HashSet<>(listaDuplicados);
```

### 3. Conteo de Frecuencias
```java
// Usando HashMap para contar frecuencias
Map<String, Integer> frecuencias = new HashMap<>();
for (String palabra : palabras) {
    frecuencias.merge(palabra, 1, Integer::sum);
}
```

### 4. Cola de Prioridad
```java
// Cola de prioridad para procesamiento de tareas
PriorityQueue<Tarea> tareas = new PriorityQueue<>();
tareas.offer(new Tarea("Alta", 1));
tareas.offer(new Tarea("Baja", 3));
tareas.offer(new Tarea("Media", 2));

while (!tareas.isEmpty()) {
    Tarea t = tareas.poll();  // Obtiene la tarea de mayor prioridad
    procesarTarea(t);
}
```

## Consideraciones de Rendimiento

### Complejidad Temporal
| Operación    | ArrayList | LinkedList | HashSet | TreeSet |
|--------------|-----------|------------|---------|---------|
| add()        | O(1)      | O(1)      | O(1)    | O(log n)|
| remove()     | O(n)      | O(1)      | O(1)    | O(log n)|
| contains()   | O(n)      | O(n)      | O(1)    | O(log n)|
| get()        | O(1)      | O(n)      | N/A     | N/A     |

### Recomendaciones de Uso
- ArrayList: Para acceso aleatorio frecuente
- LinkedList: Para inserciones/eliminaciones frecuentes
- HashSet: Para búsqueda rápida sin orden
- TreeSet: Para mantener elementos ordenados
- HashMap: Para mapeos clave-valor con acceso rápido
- TreeMap: Para mapeos ordenados por clave

## Buenas Prácticas

1. **Uso de Interfaces**
```java
// Preferir interfaces en declaraciones
List<String> lista = new ArrayList<>();
Map<String, Integer> mapa = new HashMap<>();
```

2. **Inicialización con Capacidad**
```java
// Para colecciones grandes, especificar capacidad inicial
ArrayList<String> lista = new ArrayList<>(10000);
HashMap<String, String> mapa = new HashMap<>(10000);
```

3. **Uso de Generics**
```java
// Siempre usar generics para type-safety
List<String> segura = new ArrayList<>();     // Correcto
List insegura = new ArrayList();             // Evitar
```

4. **Sincronización cuando sea necesario**
```java
// Para entornos multi-thread
List<String> listaSincronizada = Collections.synchronizedList(new ArrayList<>());
Map<String, Integer> mapaSincronizado = Collections.synchronizedMap(new HashMap<>());
```

