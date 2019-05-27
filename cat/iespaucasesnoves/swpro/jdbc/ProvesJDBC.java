package cat.iespaucasesnoves.swpro.jdbc;

import java.util.ArrayList;
import java.util.Properties;

import cat.iespaucasesnoves.swpro.jdbc.auxiliars.ValidacioException;
import cat.iespaucasesnoves.swpro.jdbc.baseDades.BibliotecaDao;
import cat.iespaucasesnoves.swpro.jdbc.dades.Autor;
import cat.iespaucasesnoves.swpro.jdbc.dades.Nacionalitat;

public class ProvesJDBC {

	public static void main(String[] args) throws ValidacioException {
		Properties propietats = new Properties();
		propietats.put("user", "usuari");
		propietats.put("password", "seCret_18");
		propietats.put("useSSL", "false");
		ArrayList<String> llista= new ArrayList<String>();
		ArrayList<Nacionalitat> nacionalitats= new ArrayList<Nacionalitat>();
		ArrayList<Autor> autor= new ArrayList<Autor>();
		Nacionalitat aleman = new Nacionalitat("ALEMAN");
		try {
			BibliotecaDao conexio = new BibliotecaDao("jdbc:mysql://192.168.1.134:3306/biblioteca",propietats);
			System.out.println(conexio.getAutor(3).getNom_aut());
			/*autor= conexio.getAutors(aleman);
			for(Autor s:autor) {
				System.out.println(s.getNom_aut());
			}
			llista = conexio.tronaLlibres("Catalana");
			nacionalitats = conexio.getNacionalitats();
			for(String s:llista) {
				System.out.println(s);
			}
			for(Nacionalitat s: nacionalitats) {
				System.out.println(s.getNacionalitat());
			}*/
			
		} catch (ValidacioException e) {
			e.printStackTrace();
		}
	}

}
