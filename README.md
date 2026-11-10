# Gestor de Tareas

Aplicación de consola en Java 21 con Maven para administrar una lista de tareas: agregar, listar, completar y eliminar.

## Requisitos

- JDK 21 o superior
- Maven 3.9 o superior

## Uso

```bash
mvn package                              # compila y ejecuta las pruebas
java -jar target/gestor-tareas-1.0.0.jar # inicia la aplicación
```

## Estructura

```
src/main/java/com/edil/tareas/
  Main.java          Menú de consola
  GestorTareas.java  Lógica de la lista de tareas
  Tarea.java         Modelo de una tarea
src/test/java/com/edil/tareas/
  GestorTareasTest.java  Pruebas JUnit 5
```
