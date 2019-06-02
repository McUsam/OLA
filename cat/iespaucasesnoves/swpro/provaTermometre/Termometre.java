package cat.iespaucasesnoves.swpro.provaTermometre;

class TemperaturaForaRangExcepcio extends Exception {
	public TemperaturaForaRangExcepcio(String missatge) {
		super("PROBLEMA: " + missatge);
	}
}

public class Termometre {
	private int temperatura;

	public Termometre(int tem) throws TemperaturaForaRangExcepcio {
		if (tem < -192 || tem > 100)
			throw new TemperaturaForaRangExcepcio(tem + " graus de temperatura és fora del rang [-192,100]");
		temperatura = tem;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) throws TemperaturaForaRangExcepcio {
		if (temperatura < -192 || temperatura > 100)
			throw new TemperaturaForaRangExcepcio(temperatura + " graus de temperatura és fora del rang [-192,100]");

		this.temperatura = temperatura;
	}
}
