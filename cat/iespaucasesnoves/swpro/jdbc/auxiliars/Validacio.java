package cat.iespaucasesnoves.swpro.jdbc.auxiliars;

import java.util.Properties;

public class Validacio {
	public static boolean validaString(String m) {
		return (m!=null && !"".equals(m.trim()));
	}
	public static boolean validaPropietats(Properties p) {
		return (p!=null && !p.isEmpty());
	}
	public static boolean validaInt(Integer m) {
		return (m!=null && m>0);
	}
	public static boolean validaStringNull(String m) {
		return (m!=null && !"".equals(m.trim()));
	}
}
