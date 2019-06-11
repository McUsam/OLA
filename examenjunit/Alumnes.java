package examenjunit;

public class Alumnes {
	class Alumne {
		String nom;
		double nota;
	}
	
	private Alumne[] llista;
	private int numero; // nombre actual d'alumnes a la llista
	
	public Alumnes(int num) { // constructor que rep el màxim d'alumnes que pot tenir la llista
		llista = new Alumne[num];
		numero = 0;
	}
	
	public int  nombreAlumnes() {
		return numero;
	}
	
	public int nombreSuspesos() {
		int resultat = 0;
		
		for (int i=0; i<numero; i++)
			if (llista[i].nota < 5)
				resultat++;
		
		return resultat;
	}
	
	public void afegir(String pnom, double pnota) throws Exception {
		if (llista.length == numero)
			throw new Exception("La llista és plena");
		
		Alumne alumne = new Alumne();
		alumne.nom = pnom;
		alumne.nota = pnota;
		
		llista[numero] = alumne;
		++numero;
	}
	
	public String llistar() {
		String resultat = "";
		
		for (int i=0; i<numero; i++)
			resultat = resultat+" ["+llista[i].nom+","+llista[i].nota+"]";
		
		resultat = resultat.trim(); // per eliminar blancs de l'inici i del final
		return resultat;
	}
	
	public int mitja() {
		double suma = 0;
		for (int i=0; i<numero; i++)
			suma += llista[i].nota;
		
		return (int) (suma/numero);
	}
	
	public Alumne millorAlumne() {
		if (numero == 0)
			return null;
		
		double millor = -1;
		int pos = -1;
		
		for (int i=0; i<numero; i++)
			if (llista[i].nota>millor) {
				millor = llista[i].nota;
				pos = i;
			}
		return llista[pos];
	}

	public static void main(String[] args) {
		Alumnes alumnes = new Alumnes(10);
		Alumnes llista = new Alumnes(2);
		System.out.println("Nombre d'alumnes abans d'afegir = "+alumnes.nombreAlumnes());
		try {
			llista.afegir("Joan", 5);
			llista.afegir("Toni", 2);
			System.out.println(llista.llistar());
			alumnes.afegir("Aina", 10);
			alumnes.afegir("Toni", 5);
			alumnes.afegir("Xesc", 4);
			alumnes.afegir("Jordi", 9.5);
			alumnes.afegir("Joan", 7.8);
			alumnes.afegir("Maria", 6.2);
			alumnes.afegir("Antònia", 8.9);
			System.out.println("Nombre d'alumnes després d'afegir = "+alumnes.nombreAlumnes());
			
			System.out.println(alumnes.llistar());
			System.out.println();			
			Alumne millor = alumnes.millorAlumne();
			System.out.println("millor alumne: "+millor.nom+" ("+millor.nota+")");
			
			alumnes.afegir("Júlia", 7.2);
			alumnes.afegir("Gibert", 2.5);
			System.out.println("mitja = "+alumnes.mitja());
			//alumnes.afegir("Jaona", 9.8);
			//alumnes.afegir("Pep", 3);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(alumnes.llistar());
		System.out.println("Nombre de suspesos: "+alumnes.nombreSuspesos());
	}
}
