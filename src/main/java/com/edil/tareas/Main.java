package com.edil.tareas;

import java.util.Scanner;

/** Menú de consola del gestor de tareas. */
public class Main {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Gestor de Tareas ===");
        while (true) {
            System.out.println();
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            if (!entrada.hasNextLine()) {
                break;
            }
            String opcion = entrada.nextLine().trim();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Descripción: ");
                    try {
                        Tarea t = gestor.agregar(entrada.nextLine());
                        System.out.println("Agregada: " + t);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "2" -> {
                    if (gestor.listar().isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        gestor.listar().forEach(System.out::println);
                        System.out.println("Pendientes: " + gestor.pendientes());
                    }
                }
                case "3" -> {
                    Integer id = leerId(entrada);
                    if (id != null) {
                        System.out.println(gestor.completar(id) ? "Tarea completada." : "No existe esa tarea.");
                    }
                }
                case "4" -> {
                    Integer id = leerId(entrada);
                    if (id != null) {
                        System.out.println(gestor.eliminar(id) ? "Tarea eliminada." : "No existe esa tarea.");
                    }
                }
                case "0" -> {
                    System.out.println("¡Hasta luego!");
                    return;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static Integer leerId(Scanner entrada) {
        System.out.print("Id de la tarea: ");
        try {
            return Integer.parseInt(entrada.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Debes ingresar un número.");
            return null;
        }
    }
}
