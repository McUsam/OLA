package cat.iespaucasesnoves.swpro.provaPila;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith (Parameterized.class)
public class PilaTestParametrizada {
	private Pila pila;
	private int _mida;
	private boolean _buida;
	private int _primer;
	private int _extreure;
	public PilaTestParametrizada(Pila p, int m,boolean b,int d, int f) {
		pila=p;
		_mida=m;
		_buida=b;
		_primer=d;
		_extreure=f;
	}
	@Parameters
	public static Collection<Object[]> parametres(){
		Pila pila1 = new Pila();

		Pila pila2 = new Pila();
		pila2.inserir(5);

		Pila pila3 = new Pila();
		pila3.inserir(3);
		pila3.inserir(5);
		pila3.inserir(-10);
		
		return Arrays.asList(new Object[][] {{pila1,0,true,Integer.MAX_VALUE,Integer.MAX_VALUE},{pila2,1,false,5,5},{pila3,3,false,-10,-10}});
	}
	@Test
	public void testMida() {
		assertEquals(_mida,pila.mida());
	}
	@Test
	public void testBuida() {
		assertTrue(_buida==pila.buida());
	}
	@Test
	public void testPrimer() {
		assertTrue(_primer==pila.primer());
	}
	@Test
	public void testExtreure() {
		assertTrue(_primer==pila.extreure());
	}

}
