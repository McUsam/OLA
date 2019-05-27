package cat.iespaucasesnoves.swpro.streams.eines;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import cat.iespaucasesnoves.swpro.streams.auxiliar.Dades;

public abstract class EinesObjectStream {
	public static void escriuObjecte(String desti, Serializable object) {
		try (ObjectOutputStream p = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));) {
			p.writeObject(object);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void escriuTotsObjectes(String desti, ArrayList<Serializable> llista) {
		try (ObjectOutputStream p = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));) {
			p.writeObject(llista);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Serializable llegeixObjecte(String origen) {
		Dades a = null;
		try (ObjectInputStream p = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)));) {
			a = (Dades) p.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	public static ArrayList<Object> llegeixTotsObjectes(String origen) {
		ArrayList<Object> llista = new ArrayList<Object>();
		try (ObjectInputStream p = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)));) {

			try {
				while (true) {
					llista.add(p.readObject());
				}
			} catch (EOFException e) {

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return llista;
	}
}
