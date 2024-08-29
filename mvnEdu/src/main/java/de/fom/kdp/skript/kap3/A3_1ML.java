package de.fom.kdp.skript.kap3;


public class A3_1ML {

	public static void main(String[] args) {
		// Deklarieren Sie ein Array vom Datentyp byte und speichern Sie drei
		// Zahlenwerte Ihrer Wahl darin ab. Danach geben Sie die drei Werte über
		// System.out.println() aus.
		byte[] b = new byte[3];
		b[0] = 1;
		b[1] = 2;
		b[2] = 3;
		System.out.println(b[0]);
		System.out.println(b[1]);
		System.out.println(b[2]);

		byte[] ba = { 1, 2, 3 };
		System.out.println(ba[0]);
		System.out.println(ba[1]);
		System.out.println(ba[2]);

	}

}
