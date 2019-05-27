package cat.iespaucasesnoves.swpro.streams.auxiliar;

import java.io.Serializable;

public class Dades implements Serializable{
	private int num;
	private String alfanum;
	public Dades(int num, String alfanum) {
		super();
		this.num = num;
		this.alfanum = alfanum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAlfanum() {
		return alfanum;
	}
	public void setAlfanum(String alfanum) {
		this.alfanum = alfanum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alfanum == null) ? 0 : alfanum.hashCode());
		result = prime * result + num;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dades other = (Dades) obj;
		if (alfanum == null) {
			if (other.alfanum != null)
				return false;
		} else if (!alfanum.equals(other.alfanum))
			return false;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dades [num=" + num + ", alfanum=" + alfanum + "]";
	}
	
}
