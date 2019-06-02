package cat.iespaucasesnoves.swpro.provaTermometre;

import static org.junit.Assert.*;

import org.junit.Test;

public class TermometreTest {
	private Termometre b;
	
	public TermometreTest() throws TemperaturaForaRangExcepcio  {
		b= new Termometre(4);
	}
	@Test(expected = TemperaturaForaRangExcepcio.class)
	public void testTermometre() throws TemperaturaForaRangExcepcio {
		Termometre a= new Termometre(200);
	}
	@Test
	public void testTermometre1() throws TemperaturaForaRangExcepcio {
		Termometre a= new Termometre(1);
	}

	@Test(expected = TemperaturaForaRangExcepcio.class)
	public void testGetTemperatura() throws TemperaturaForaRangExcepcio {
		Termometre a= new Termometre(-5001);
		a.getTemperatura();
	}

	@Test(expected = TemperaturaForaRangExcepcio.class)
	public void testSetTemperatura() throws TemperaturaForaRangExcepcio {
		b.setTemperatura(-000211);
	}

}
