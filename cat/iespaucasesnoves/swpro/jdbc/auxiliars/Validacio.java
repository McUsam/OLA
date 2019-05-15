package cat.iespaucasesnoves.swpro.jdbc.auxiliars;

import java.util.Properties;

public class Validacio {
	public static boolean validaString(String m) {
		return (m!=null && !"".equals(m.trim()));
	}
	public static boolean validaPropietats(Properties p) {
		return (p!=null && !p.isEmpty());
	}
}
