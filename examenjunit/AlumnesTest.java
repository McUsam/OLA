package examenjunit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import examenjunit.Alumnes.Alumne;

public class AlumnesTest {
	private Alumnes alumnes;

	public AlumnesTest() throws Exception {
		this.alumnes = new Alumnes(10);
		alumnes.afegir("Joan", 5);
		alumnes.afegir("Toni", 4);
	}

	@Test
	public void testNombreSuspesos() {
		assertTrue(1 == alumnes.nombreSuspesos());
	}

	@Test
	public void testNombreAlumnes() {
		assertTrue(2 == alumnes.nombreAlumnes());
		assertFalse(3 == alumnes.nombreAlumnes());
	}

	@Test
	public void testLlistar() throws Exception {
		assertTrue(alumnes.llistar().equals("[Joan,5.0] [Toni,4.0]"));
	}

	@Test
	public void testMitja() {
		assertTrue(4 == alumnes.mitja());
	}

	@Test
	public void testAfegir() throws Exception {
		alumnes.afegir("Usama", 5);
		assertEquals(3, alumnes.nombreAlumnes());
	}

	@Test(expected = Exception.class)
	public void testAfegirExcepcio() throws Exception {
		Alumnes llista = new Alumnes(0);
		llista.afegir("Usama", 5);
	}

	@Test
	public void testMillorAlumne() {
		Alumne alumne = alumnes.millorAlumne();
		assertTrue(alumne == alumnes.millorAlumne());
	}

}
