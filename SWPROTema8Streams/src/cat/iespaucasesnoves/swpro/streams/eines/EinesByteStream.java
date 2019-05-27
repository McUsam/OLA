package cat.iespaucasesnoves.swpro.streams.eines;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EinesByteStream {
	public static void escriuByte(String desti, byte[] dades) throws IOException {
		FileOutputStream p = new FileOutputStream(desti);
		p.write(dades);
		p.close();
	}

	public static void mostraBytes(String origen) throws IOException {
		FileInputStream p = null;
		int c;
		try {
			p = new FileInputStream(origen);
			while ((c = p.read()) != -1) {
				System.out.print((byte) c + "\t");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (p != null) {
				p.close();
			}
		}
	}

	public static byte[] tornaBytes(String origen) throws IOException {
		byte[] bytes;
		ArrayList<Byte> llista = new ArrayList<Byte>();
		FileInputStream p = null;
		int c;
		try {
			p = new FileInputStream(origen);
			while ((c = p.read()) != -1) {
				llista.add((byte) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (p != null) {
				p.close();
			}
		}
		bytes = new byte[llista.size()];
		for (int i = 0; i < llista.size(); i++) {
			bytes[i] = llista.get(i);
		}

		return bytes;
	}
	public static void copiaBytes(String origen, String desti) {
		try {
			byte[] llista = tornaBytes(origen);
			escriuByte(desti,llista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
