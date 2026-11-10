package com.edil.tareas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/** Administra una lista de tareas en memoria. */
public class GestorTareas {
    private final List<Tarea> tareas = new ArrayList<>();
    private int siguienteId = 1;

    public Tarea agregar(String descripcion) {
        Tarea tarea = new Tarea(siguienteId++, descripcion);
        tareas.add(tarea);
        return tarea;
    }

    public Optional<Tarea> buscar(int id) {
        return tareas.stream().filter(t -> t.getId() == id).findFirst();
    }

    /** Marca la tarea como completada. Devuelve false si no existe. */
    public boolean completar(int id) {
        Optional<Tarea> tarea = buscar(id);
        tarea.ifPresent(Tarea::completar);
        return tarea.isPresent();
    }

    /** Elimina la tarea. Devuelve false si no existe. */
    public boolean eliminar(int id) {
        return tareas.removeIf(t -> t.getId() == id);
    }

    public List<Tarea> listar() {
        return Collections.unmodifiableList(tareas);
    }

    public long pendientes() {
        return tareas.stream().filter(t -> !t.isCompletada()).count();
    }
}
