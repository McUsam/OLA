package cat.iespaucasesnoves.swpro.jdbc.dades;

import cat.iespaucasesnoves.swpro.jdbc.auxiliars.Validacio;
import cat.iespaucasesnoves.swpro.jdbc.auxiliars.ValidacioException;

public class Nacionalitat {
	private String nacionalitat;

	public Nacionalitat(String nacionalitat) throws ValidacioException {
		setNacionalitat(nacionalitat);
	}

	public String getNacionalitat() {
		return nacionalitat;
	}

	public void setNacionalitat(String nacionalitat) throws ValidacioException {
		if(Validacio.validaString(nacionalitat))
			this.nacionalitat = nacionalitat;
		else
			throw new ValidacioException();
	}
	
}
