package cat.iespaucasesnoves.swpro.jdbc.dades;

import cat.iespaucasesnoves.swpro.jdbc.auxiliars.*;

public class Autor {
	private int id_aut;
	private String nom_aut;
	private String fk_nacionalitat;
	public Autor(int id_aut, String nom_aut, String fk_nacionalitat) throws ValidacioException {
		super();
		setId_aut(id_aut);
		setNom_aut(nom_aut);
		this.fk_nacionalitat = fk_nacionalitat;
	}
	public Autor() {
		
	}
	public int getId_aut() {
		return id_aut;
	}
	public void setId_aut(int id_aut) throws ValidacioException {
		if(Validacio.validaInt(id_aut))
			this.id_aut = id_aut;
		else
			throw new ValidacioException("Codi no vàlid.");
	}
	public void setNom_aut(String nom_aut) throws ValidacioException {
		if(Validacio.validaString(nom_aut))
			this.nom_aut = nom_aut;
		else
			throw new ValidacioException("Codi no vàlid.");
	}
	public void setFk_nacionalitat(String fk_nacionalitat) throws ValidacioException {
		if(Validacio.validaStringNull(fk_nacionalitat))
			this.fk_nacionalitat = fk_nacionalitat;
		else
			throw new ValidacioException("Codi no vàlid.");
	}
	public String getNom_aut() {
		return nom_aut;
	}
	public String getFk_nacionalitat() {
		return fk_nacionalitat;
	}
	
}
