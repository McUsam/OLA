package cat.iespaucasesnoves.swpro.prova.provaElMeuNom;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElMeuNomTest1 {
	private static ElMeuNom a;
	
	public ElMeuNomTest1(){
		a = new ElMeuNom("Usama","Ouekkai","Nieto");
	}
	/*@BeforeClass
	public static void Inicialitza() {
		a = new ElMeuNom("Usama","Ouekkai","Nieto");
	}*/
	@Test
	public void testInicials() {
		assertEquals("UON",a.inicials());
	}

	@Test
	public void testNomComplet() {
		assertFalse("Usama Ouekkai Nieto1".equals(a.nomComplet())&&"hola".equals(a.nomXifrat()));
	}

	@Test
	public void testNomXifrat() {
		assertTrue("Vtbnb".equals(a.nomXifrat()));
	}

}
