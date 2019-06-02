package cat.iespaucasesnoves.swpro.provaPila;

import static org.junit.Assert.*;

import javax.swing.text.html.parser.Element;

import org.junit.Before;
import org.junit.Test;

public class PilaTest {
	private Pila b;
	private Pila c;
	private Pila d;

	@Before
	public void PilaTest1() {
		c = new Pila();

		d = new Pila();
		d.inserir(5);

		b = new Pila();
		b.inserir(3);
		b.inserir(5);
		b.inserir(-10);
	}

	@Test
	public void testInserir() {
		c.inserir(3);
		d.inserir(5);
		b.inserir(-903131221);
		assertTrue(c.mida() == 1 && c.primer() == 3);
		assertTrue(d.mida() == 2 && d.primer() == 5);

	}

	@Test
	public void testExtreure() {
		assertEquals(Integer.MAX_VALUE, c.extreure());
		assertEquals(5, d.extreure());
		assertEquals(-10, b.extreure());
	}

	@Test
	public void testBuida() {
		assertTrue(c.buida());
		assertFalse(d.buida());
		assertFalse(b.buida());
	}

	@Test
	public void testMida() {
		assertEquals(0, c.mida());
		assertEquals(1, d.mida());
		assertEquals(3, b.mida());
	}

	@Test
	public void testPrimer() {
		assertEquals(Integer.MAX_VALUE, c.primer());
		assertEquals(5, d.primer());
		assertEquals(-10, b.primer());
	}

}
