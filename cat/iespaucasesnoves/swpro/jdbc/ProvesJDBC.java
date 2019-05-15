package cat.iespaucasesnoves.swpro.jdbc;

import java.util.ArrayList;
import java.util.Properties;

import cat.iespaucasesnoves.swpro.jdbc.auxiliars.ValidacioException;
import cat.iespaucasesnoves.swpro.jdbc.baseDades.BibliotecaDao;

public class ProvesJDBC {

	public static void main(String[] args) {
		Properties propietats = new Properties();
		propietats.put("user", "usuari");
		propietats.put("password", "seCret_18");
		propietats.put("useSSL", "false");
		ArrayList<String> llista= new ArrayList<String>();
		try {
			BibliotecaDao conexio = new BibliotecaDao("jdbc:mysql://192.168.1.134:3306/biblioteca",propietats);
			llista = conexio.tronaLlengues();
			for(String s: llista) {
				System.out.println(s);
			}
			
		} catch (ValidacioException e) {
			e.printStackTrace();
		}
	}

}
