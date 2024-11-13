# Ejercicios de Manejo de Archivos en Java

Objetivo: Practicar diferentes operaciones de manejo de archivos en Java, incluyendo lectura, escritura, y manipulación de datos.

## Ejercicio 1: Creación y Escritura de Archivos
Crea un programa que genere un archivo llamado "estudiantes.txt" y escriba en él la información de 5 estudiantes. Cada línea debe contener: Nombre, Edad, y Promedio, separados por comas.

## Ejercicio 2: Lectura de Archivos
Desarrolla un programa que lea el archivo "estudiantes.txt" creado en el Ejercicio 1 y muestre su contenido en la consola.

## Ejercicio 3: Búsqueda en Archivos
Crea un programa que busque en el archivo "estudiantes.txt" todos los estudiantes cuyo promedio sea mayor a 8.0 y los muestre en la consola.

## Ejercicio 4: Modificación de Archivos
Escribe un programa que lea el archivo "estudiantes.txt", aumente en 0.5 el promedio de todos los estudiantes, y guarde los cambios en un nuevo archivo llamado "estudiantes_actualizado.txt".

## Ejercicio 5: Manejo de Directorios
Desarrolla un programa que cree un directorio llamado "Reportes" si no existe, y luego cree dentro de este directorio un archivo por cada estudiante en "estudiantes.txt", nombrando cada archivo con el nombre del estudiante y conteniendo su información.

## Ejercicio 6: Serialización de Objetos
Crea una clase `Estudiante` con los campos nombre, edad y promedio. Luego, escribe un programa que cree objetos `Estudiante` con la información del archivo "estudiantes.txt", los serialice y los guarde en un archivo llamado "estudiantes.ser".

## Ejercicio 7: Deserialización de Objetos
Escribe un programa que lea el archivo "estudiantes.ser" creado en el Ejercicio 6, deserialice los objetos `Estudiante` y muestre su información en la consola.

## Desafío Final: Sistema de Gestión de Archivos
Crea un programa que implemente un menú con las siguientes opciones:
1. Agregar un nuevo estudiante
2. Mostrar todos los estudiantes
3. Buscar estudiante por nombre
4. Eliminar estudiante
5. Calcular promedio general
6. Salir

El programa debe manejar toda la información en un archivo, actualizándolo según las operaciones realizadas.

Nota: Asegúrate de manejar adecuadamente las excepciones en todos los ejercicios y de cerrar correctamente los recursos utilizados.
