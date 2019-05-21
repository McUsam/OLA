package cat.iespaucasesnoves.swpro.provaEnters;

public class TaulaEnters {
	private int[] taula;
	
	TaulaEnters(int[] tla){ // Constructor
		if (tla == null || tla.length == 0)
			throw new IllegalArgumentException("No hi ha elements");
		taula = tla;
	}
	
	// torna la suma dels elements de la taula
	public int sumaTaula() {
		int suma = 0;
		for (int i = 0; i < taula.length; i++) {
			suma += taula[i];
		}
		return suma;
	}
	
	// torna l'element major de la taula
	public int majorTaula() {
		int max = taula[0];
		for (int i = 1; i < taula.length; i++) {
			if (taula[i] > max) {
				max = taula[i];
			}
		}
		return max;
	}
	
	// torna la posició (la primera que troba) d'un element del qual passam el valor per paràmetre
	public int posicioTaula(int n) {
		for (int i = 0; i < taula.length; i++)
			if (taula[i] == n)
				return i;
		throw new java.util.NoSuchElementException("No existeix: "+n);
	}
}