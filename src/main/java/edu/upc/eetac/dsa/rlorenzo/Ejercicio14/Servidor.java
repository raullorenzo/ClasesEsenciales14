package edu.upc.eetac.dsa.rlorenzo.Ejercicio14;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) {

		ServerSocket puerto; // Socket servidor
		Socket sc; // Socket cliente

		PrintStream escribir;
		BufferedReader leer;

		Date now = new Date();
		Date now2 = new Date();

		try {
			// Creo el socket server

			puerto = new ServerSocket(1024);
			System.out.println("Esperando conexi�n");

			// Invoco el metodo accept del socket servidor, me devuelve una
			// referencia al socket cliente
			sc = puerto.accept();

			System.out.println("Nuevo cliente conectado");
			while (true) {
				escribir = new PrintStream(sc.getOutputStream());
				leer = new BufferedReader(new InputStreamReader(
						sc.getInputStream()));

				int mensajeRecibido;
				String mensajeEnviar;
				mensajeRecibido = Integer.parseInt(leer.readLine());

				switch (mensajeRecibido) {

				case 0:
					SimpleDateFormat fecha = new SimpleDateFormat(
							"dd/MM/yyyy HH:mm:ss");
					mensajeEnviar = fecha.format(now);
					escribir.println(mensajeEnviar);
					break;

				case 1:
					SimpleDateFormat fecha1 = new SimpleDateFormat(
							"EE,dd de MM de yyyy, HH:mm:ss");
					mensajeEnviar = fecha1.format(now2);
					escribir.println(mensajeEnviar);

					break;

				default:
					mensajeEnviar = "Operaci�n no encontrada";
					escribir.println(mensajeEnviar);
					break;

				}
				break;
			}
			sc.close();
			puerto.close();
			leer.close();
			escribir.close();

		} catch (IOException e) {
			System.out.println("No puedo crear el socket");
		}
	}
}