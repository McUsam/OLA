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
import cat.iespaucasesnoves.swpro.jdbc.dades.Autor;
import cat.iespaucasesnoves.swpro.jdbc.dades.Nacionalitat;

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
		if (Validacio.validaString(url))
			this.url = url;
		else {
			throw new ValidacioException("La url no pot ser null ni una cadena buida");
		}
	}

	public Properties getPropietats() {
		return propietats;
	}

	public void setPropietats(Properties propietats) throws ValidacioException {
		if (Validacio.validaPropietats(propietats))
			this.propietats = propietats;
		else {
			throw new ValidacioException("Les propietats no poden ser null o estar buides");
		}
	}

	public ArrayList<Nacionalitat> getNacionalitats() throws ValidacioException {
		ArrayList<Nacionalitat> llista = new ArrayList<Nacionalitat>();
		try {
			Connection con = DriverManager.getConnection(url, propietats);
			Statement st = con.createStatement();
			try (ResultSet rs = st.executeQuery("Select NACIONALITAT from NACIONALITATS")) {
				while (rs.next()) {
					llista.add(new Nacionalitat(rs.getString(1)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return llista;

	}

	public ArrayList<String> tronaLlengues() {
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

	public ArrayList<String> tronaLlibres(String m) {
		ArrayList<String> llista = new ArrayList<String>();
		try {
			Connection con = DriverManager.getConnection(url, propietats);
			Statement st = con.createStatement();
			try (ResultSet rs = st.executeQuery("Select titol from LLIBRES where FK_LLENGUA='" + m + "\'")) {
				while (rs.next()) {
					llista.add(rs.getString("titol"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return llista;

	}

	public ArrayList<String> tronaLlibresPrepared(String m) {
		ArrayList<String> llista = new ArrayList<String>();
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con.prepareStatement("Select titol from LLIBRES where FK_LLENGUA=?")) {
			st.setString(1, m);
			System.out.println(st);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					llista.add(rs.getString("titol"));
				}

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return llista;

	}

	public Autor getAutor(int m) throws ValidacioException {
		Autor autor = new Autor();
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con
						.prepareStatement("Select id_aut, nom_aut, fk_nacionalitat from AUTORS where id_aut=?")) {
			st.setInt(1, m);
			System.out.println(st);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					autor = new Autor(rs.getInt(1), rs.getString("nom_aut"), rs.getString("fk_nacionalitat"));
				}

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return autor;

	}

	public ArrayList<Autor> getAutors(Nacionalitat nacionalitat) throws ValidacioException {
		ArrayList<Autor> llista = new ArrayList<Autor>();
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con.prepareStatement(
						"Select id_aut, nom_aut, fk_nacionalitat from AUTORS where fk_nacionalitat=?")) {
			st.setString(1, nacionalitat.getNacionalitat());
			System.out.println(st);
			try (ResultSet rs = st.executeQuery()) {
				while (rs.next()) {
					llista.add(new Autor(rs.getInt(1), rs.getString("nom_aut"), rs.getString("fk_nacionalitat")));
				}

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return llista;

	}

	public void insereixNacionalitatAutors(Nacionalitat nacionalitat, ArrayList<Autor> llista) {
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con.prepareStatement("Insert into nacionalitats values(?)");
				PreparedStatement st1 = con.prepareStatement("Insert into autors values(?,?,?)")) {
			st.setString(1, nacionalitat.getNacionalitat());
			int rs = st.executeUpdate();
			for (int i = 0; i < llista.size(); i++) {
				st1.setInt(1, llista.get(i).getId_aut());
				st1.setString(2, llista.get(i).getNom_aut());
				st1.setString(3, llista.get(i).getFk_nacionalitat());
				st1.executeUpdate();
			}
			System.out.println(st);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void esborraNacionalitatAutors(Nacionalitat nacionalitat) {
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con.prepareStatement("Delete from nacionalitats where nacionalitat=?");
				PreparedStatement st1 = con.prepareStatement("Delete from autors where fk_nacionalitat=?")) {
			st.setString(1, nacionalitat.getNacionalitat());
			st1.setString(1, nacionalitat.getNacionalitat());
			int rs = st.executeUpdate();
			int rs1 = st1.executeUpdate();

		} catch (SQLException e1) {

		}
	}

	public void insereixNacionalitatAutorsTransaccio(Nacionalitat nacionalitat, ArrayList<Autor> llista) {
		try (Connection con = DriverManager.getConnection(url, propietats);
				PreparedStatement st = con.prepareStatement("Insert into nacionalitats values(?)");
				PreparedStatement st1 = con.prepareStatement("Insert into autors values(?,?,?)");) {
			con.setAutoCommit(false);
			st.setString(1, nacionalitat.getNacionalitat());

			int rs = st.executeUpdate();
			for (int i = 0; i < llista.size(); i++) {
				st1.setInt(1, llista.get(i).getId_aut());
				st1.setString(2, llista.get(i).getNom_aut());
				st1.setString(3, llista.get(i).getFk_nacionalitat());
				st1.executeUpdate();
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
