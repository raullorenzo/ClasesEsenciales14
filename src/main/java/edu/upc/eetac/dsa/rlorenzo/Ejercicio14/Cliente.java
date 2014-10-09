package edu.upc.eetac.dsa.rlorenzo.Ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

		// leer del teclado
		Scanner sr = new Scanner(System.in);
		int op;

		try {

			Socket s;
			PrintStream escribir;
			BufferedReader leer;
			s = new Socket("127.0.0.1", 1024);
			String mensajeRecibido;

			escribir = new PrintStream(s.getOutputStream());
			leer = new BufferedReader(new InputStreamReader(s.getInputStream()));

			System.out.println("Introduce la operaci�n que quiere realizar");
			System.out.println("0:formato dia/mes/a�o hora:minutos:segundos");
			System.out
					.println("1:formato d�a de la semana,d�a del mes de mes de a�o, hora:minutos:segundos");
			op = sr.nextInt();
			escribir.println(op);

			// Espero la respuesta por el canal de lectura
			mensajeRecibido = leer.readLine();
			System.out.println(mensajeRecibido);

			escribir.close();
			leer.close();
			s.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}