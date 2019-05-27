package cat.iespaucasesnoves.swpro.streams.eines;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class EinesBufferedStream {

	public static void escriuByte(String desti, byte[] dades) throws IOException {
		OutputStream p = new BufferedOutputStream(new FileOutputStream(desti));
		p.write(dades);
		p.close();
	}
	public static void mostraBytes(String origen) throws IOException {
		InputStream p = null;
		int c;
		try {
			p = new BufferedInputStream(new FileInputStream(origen));
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
		InputStream p = null;
		int c;
		try {
			p = new BufferedInputStream(new FileInputStream(origen));
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
