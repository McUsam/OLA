package cat.iespaucasesnoves.swpro.provaPila;

public class Pila { // Llista tipus pila que conté nombres enters
	class Element {
		int info;
		Element seguent;
	}
	
	private Element cim;
	
	public Pila() {
		cim = null;
	}
	
	public void inserir(int valor) {
		Element nou = new Element();
		nou.info = valor;
		nou.seguent = cim;
		cim = nou;
	}
	
	public int extreure() {
		int valor;
		
		if (cim == null)
			return Integer.MAX_VALUE;
		else {
			valor = cim.info;
			cim = cim.seguent;
			return valor;
		}		
	}
	
	public boolean buida() {
		if (cim == null)
			return true;
		else
			return false;
	}
	
	public int mida() {
		int cont = 0;
		
		for (Element punter=cim; punter!=null; punter=punter.seguent)
			cont++;
		return cont;
	}
	
	public int primer() {
		if (buida())
			return Integer.MAX_VALUE;
		else
			return cim.info;
	}
}

