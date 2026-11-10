package com.edil.tareas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GestorTareasTest {
    private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    void agregarAsignaIdsConsecutivos() {
        assertEquals(1, gestor.agregar("Estudiar").getId());
        assertEquals(2, gestor.agregar("Programar").getId());
        assertEquals(2, gestor.listar().size());
    }

    @Test
    void agregarRechazaDescripcionVacia() {
        assertThrows(IllegalArgumentException.class, () -> gestor.agregar("   "));
        assertTrue(gestor.listar().isEmpty());
    }

    @Test
    void completarMarcaLaTarea() {
        gestor.agregar("Estudiar");
        assertTrue(gestor.completar(1));
        assertTrue(gestor.buscar(1).orElseThrow().isCompletada());
        assertEquals(0, gestor.pendientes());
    }

    @Test
    void completarDevuelveFalseSiNoExiste() {
        assertFalse(gestor.completar(99));
    }

    @Test
    void eliminarQuitaLaTarea() {
        gestor.agregar("Estudiar");
        assertTrue(gestor.eliminar(1));
        assertFalse(gestor.eliminar(1));
        assertTrue(gestor.listar().isEmpty());
    }
}
