package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.util.List;
import java.util.ArrayList;
import modelo.usuarios.Profesor;
import modelo.actividades.Actividad;
import modelo.LearningPath;

class ProfesorTest {

	private Profesor profesor;

    @BeforeEach
    public void setup() {
        profesor = new Profesor("Juan Pérez", "juan.perez@example.com", "profesor1", "1234");
    }

    @Test
    public void testCrearLearningPath() {
        List<Actividad> actividades = new ArrayList<>();
        actividades.add(new Actividad("Actividad 1", "Descripción 1", "Principiante", 30));
        actividades.add(new Actividad("Actividad 2", "Descripción 2", "Intermedio", 60));

        // Crear un Learning Path
        LearningPath lp = profesor.crearLearningPath("Python Básico", "Introducción a Python", "Principiante", 90, actividades);
        assertNotNull(lp);
        assertEquals("Python Básico", lp.getTitulo());
        assertEquals(2, lp.getActividades().size());
        assertTrue(profesor.getLearningPathsCreados().contains(lp));
    }

    @Test
    public void testGetLearningPathbyNombre() {
        profesor.crearLearningPath("Python Básico", "Introducción a Python", "Principiante", 90, new ArrayList<>());
        profesor.crearLearningPath("Java Avanzado", "Técnicas avanzadas en Java", "Avanzado", 120, new ArrayList<>());
        LearningPath lp = profesor.getLearningPathbyNombre("Java Avanzado");
        assertNotNull(lp);
        assertEquals("Java Avanzado", lp.getTitulo());
        LearningPath lpInexistente = profesor.getLearningPathbyNombre("C++ Intermedio");
        assertNull(lpInexistente);
    }

    @Test
    public void testGetActividadesCreadas() {
        assertTrue(profesor.getActividadesCreadas().isEmpty());
        Actividad actividad1 = new Actividad("Actividad 1", "Descripción 1", "Principiante", 30);
        Actividad actividad2 = new Actividad("Actividad 2", "Descripción 2", "Intermedio", 60);

        profesor.getActividadesCreadas().add(actividad1);
        profesor.getActividadesCreadas().add(actividad2);

        assertEquals(2, profesor.getActividadesCreadas().size());
        assertTrue(profesor.getActividadesCreadas().contains(actividad1));
        assertTrue(profesor.getActividadesCreadas().contains(actividad2));
    }

    @AfterEach
    public void cleanup() {
        profesor = null;
    }
}

}
