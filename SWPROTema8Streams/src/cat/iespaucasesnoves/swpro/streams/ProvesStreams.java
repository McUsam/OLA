package cat.iespaucasesnoves.swpro.streams;

import java.io.IOException;

import cat.iespaucasesnoves.swpro.streams.eines.Cronometre;
import cat.iespaucasesnoves.swpro.streams.eines.EinesByteStream;

public class ProvesStreams {

	public static void main(String[] args) {
		ProvesStreams p = new ProvesStreams();
		p.provesByteStreams();
		p.provesByteBufferedStreams();
	}
	public void provesByteStreams() {
		String desti= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova.byte";
		String desti1= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova1.byte";
		String origen= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\dni2.jpg";
		String desti3= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova2.jpg";
		byte[] dades = {5, 6, 7, 65, 66, 67, 124, 127};
		byte[] dades1 =  ("Bon dia Llorenç!".getBytes());
		byte[] dades2;
		Cronometre c = new Cronometre();
		c.start();
		EinesByteStream.copiaBytes(origen, desti3);
		c.stop();
		System.out.println(c.temps()/1E9);
		try {
			EinesByteStream.escriuByte(desti, dades);
			//EinesByteStream.escriuByte(desti1, dades1);
			//EinesByteStream.mostraBytes(desti);
			//System.out.println();
			//System.out.println();
			//EinesByteStream.mostraBytes(desti1);
			/*dades2= EinesByteStream.tornaBytes(desti);
			for(int i = 0; i<dades2.length;i++) {
				System.out.print(dades2[i]+"\t");
			}*/
			EinesByteStream.copiaBytes(origen, desti3);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void provesByteBufferedStreams() {
		String desti= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova.byte";
		String desti1= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova1.byte";
		String origen= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\dni2.jpg";
		String desti3= "C:\\Users\\usama\\Desktop\\FP\\Programacion\\jdcb\\Fitxers\\prova3.jpg";
		byte[] dades = {5, 6, 7, 65, 66, 67, 124, 127};
		byte[] dades1 =  ("Bon dia Llorenç!".getBytes());
		byte[] dades2;
		Cronometre c = new Cronometre();
		c.start();
		EinesByteStream.copiaBytes(origen, desti3);
		c.stop();
		System.out.println(c.temps()/1E9);
		try {
			EinesByteStream.escriuByte(desti, dades);
			//EinesByteStream.escriuByte(desti1, dades1);
			//EinesByteStream.mostraBytes(desti);
			//System.out.println();
			//System.out.println();
			//EinesByteStream.mostraBytes(desti1);
			/*dades2= EinesByteStream.tornaBytes(desti);
			for(int i = 0; i<dades2.length;i++) {
				System.out.print(dades2[i]+"\t");
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
