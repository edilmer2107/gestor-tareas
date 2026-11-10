package com.edil.tareas;

/** Una tarea con identificador, descripción y estado. */
public class Tarea {
    private final int id;
    private final String descripcion;
    private boolean completada;

    public Tarea(int id, String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        this.id = id;
        this.descripcion = descripcion.trim();
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public boolean isCompletada() { return completada; }

    public void completar() { this.completada = true; }

    @Override
    public String toString() {
        return String.format("[%s] %d. %s", completada ? "x" : " ", id, descripcion);
    }
}
