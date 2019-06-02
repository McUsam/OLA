package cat.iespaucasesnoves.swpro.prova;

import static org.junit.Assert.*;

import org.junit.*;

public class MissatgeTest {
	private static String men;
	@BeforeClass
	public static void inicialitza() {
		Missatge m = new Missatge("Hola");
		men = m.mostra();
	}
	@Test
	public void testMostra() {
		assertEquals("Hola", men);
	}

}
