package cat.iespaucasesnoves.swpro.prova;

public class Missatge {
	private String salutacio;
	
	public Missatge(String salutacio) {
		super();
		this.salutacio = salutacio;
	}
	public String mostra() {
		return salutacio;
	}
	public static void main(String[] args) {
		Missatge m = new Missatge("Hola");
		m.mostra();

	}

}
