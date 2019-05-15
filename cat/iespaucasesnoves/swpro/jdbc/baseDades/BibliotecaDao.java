package cat.iespaucasesnoves.swpro.jdbc.baseDades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import cat.iespaucasesnoves.swpro.jdbc.auxiliars.Validacio;
import cat.iespaucasesnoves.swpro.jdbc.auxiliars.ValidacioException;

public class BibliotecaDao {
	String url;
	Properties propietats;
	public BibliotecaDao(String url, Properties propietats) throws ValidacioException {
		super();
		setUrl(url);
		setPropietats(propietats);
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) throws ValidacioException {
		if(Validacio.validaString(url))
			this.url = url;
		else {
			throw new ValidacioException("La url no pot ser null ni una cadena buida");
		}
	}
	public Properties getPropietats() {
		return propietats;
	}
	public void setPropietats(Properties propietats) throws ValidacioException {
		if(Validacio.validaPropietats(propietats))
			this.propietats = propietats;
		else {
			throw new ValidacioException("Les propietats no poden ser null o estar buides");
		}
	}
	public ArrayList<String> tronaLlengues(){
		ArrayList<String> llista = new ArrayList<String>();
		try {
			Connection con = DriverManager.getConnection(url, propietats);
			Statement st = con.createStatement();
			try (ResultSet rs = st.executeQuery("Select LLENGUA from LLENGUES")) {
				while (rs.next()) {
					llista.add(rs.getString("LLENGUA"));
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return llista;
		
	}
	
}
