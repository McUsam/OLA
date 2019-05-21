package cat.iespaucasesnoves.swpro.provaEnters;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class TaulaEntersTest {
	private TaulaEnters numeros;
	

	public TaulaEntersTest() {
		int[] llista = {2,42,323,2,1,-1};
		this.numeros = new TaulaEnters(llista);
	}

	@Test
	public void testSumaTaula() {
		assertEquals(369, numeros.sumaTaula());
	}

	@Test
	public void testMajorTaula() {
		assertEquals(323,numeros.majorTaula());
	}

	@Test
	public void testPosicioTaula() {
		assertEquals(1,numeros.posicioTaula(42));
	}
	
	@Test (expected = NoSuchElementException.class)
	public void testNoExisteix() {
		numeros.posicioTaula(3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testTaulaBuida() {
		int[] a = {};
		new TaulaEnters(a);
	}
}
