package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class ServidorHilo extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	private String nombreCliente;
	private String correoCliente;

	public ServidorHilo(DataInputStream in, DataOutputStream out, String nombreCliente) {
		this.in = in;
		this.out = out;
		this.nombreCliente = nombreCliente;
	}

	@Override
	public void run() {
//		int opcion;
//		File f = new File("numeros.txt");
		boolean parar = false;

		while (!parar) {

			try {
				out.writeUTF("Hola " + nombreCliente + "! Escoge una de las siguientes opciones: \n"
						+ "1. Ver emprendimientos. \n" + "2. Eres emprendedor. \n" + "3. PQRS. \n" + "4. Salir");

				int opcion = in.readInt();

				switch (opcion) {

				// Ver emprendimientos
				case 1:
					boolean pararCategorias = false;

					while (!pararCategorias) {

						out.writeUTF(
								"Categorias disponibles: \n" + "1. Comida. \n" + "2. Accesorios. \n" + "0. Volver.");

						int opcionCategoria = in.readInt();

						switch (opcionCategoria) {

						// Comida
						case 1:
							boolean pararComida = false;

							while (!pararComida) {

								out.writeUTF("Emprendimientos disponibles: \n" + "1. Cubanitos. \n" + "2. Ñam. \n"
										+ "0. Volver");

								int opcionComida = in.readInt();

								switch (opcionComida) {

								// Cubanitos
								case 1:
									pararCategorias = true;
									pararComida = true;
									// out.writeUTF("*Hacer pedido*");
									break;
								// Ñam
								case 2:
									pararCategorias = true;
									pararComida = true;
									// out.writeUTF("*Hacer pedido*");
									break;
								// Volver
								case 0:
									pararComida = true;
									break;
								}
							}
							break;

						// Accesorios
						case 2:
							boolean pararAccesorios = false;

							while (!pararAccesorios) {
								out.writeUTF("Emprendimientos disponibles: \n" + "1. Pulseras de goma. \n"
										+ "2. Estuches de telefono. \n" + "0. Volver");

								int opcionAccesorios = in.readInt();

								switch (opcionAccesorios) {

								// Cubanitos
								case 1:
									pararCategorias = true;
									pararAccesorios = true;
									// out.writeUTF("*Hacer pedido*");
									break;
								// Ñam
								case 2:
									pararCategorias = true;
									pararAccesorios = true;
									// out.writeUTF("*Hacer pedido*");
									break;
								// Volver
								case 0:
									pararAccesorios = true;
									break;
								}
							}
							break;
						// Volver
						case 0:
							pararCategorias = true;
							break;
						}
					}
					break;

				// Eres emprendedor
				case 2:
					boolean pararEmprendedor = false;
					
					while(!pararEmprendedor) {
						
						out.writeUTF("Elige una de las siguientes: \n"
								+	 "1. Iniciar sesion. \n"
								+	 "2. Registrarse \n"
								+	 "0. Volver.");
						
						int opcionEmprendedor = in.readInt();
						
						switch(opcionEmprendedor) {
						
						//Iniciar sesion
						case 1: 
							out.writeUTF("Digita tu correo registrado");
							String email = in.readUTF();
							correoCliente = email;
							out.writeUTF("Digita tu contraseña");
							String password = in.readUTF();
							
							pararEmprendedor = true;
							
							break;
							
						//Registrarse
						case 2:
							out.writeUTF("Digita tu correo para registrar");
							String emailRegistro = in.readUTF();
							correoCliente = emailRegistro;
							out.writeUTF("Digita tu contraseña");
							String passwordRegistro = in.readUTF();
							out.writeUTF("Confirma tu contraseña");
							String passwordRegistroC = in.readUTF();
							
							pararEmprendedor = true;
							
							break;
						}
						
					}
					out.writeUTF("Elige una de las siguientes: \n" + "1. Iniciar sesion. \n" + "2. Registrarse \n"
							+ "0. Volver.");
					
					int opcionEmprendedor = in.readInt();
					
					switch(opcionEmprendedor) {
					
					}
					break;

				// PQRS
				case 3:

					if (correoCliente != null) {
						out.writeUTF("Enviaremos un mensaje a tu correo.");
					} else {
						out.writeUTF("Debes registrarte");
					}

					break;

				case 4:

					parar = true;

				default:
					out.writeUTF("Conexion con el servidor terminada");
					parar = true;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} /////

		}

	}

//	public void escribirNumeroAleatorio(File f, int numeroAleatorio) throws IOException {
//
//		FileWriter fw = new FileWriter(f, true);
//		fw.write(nombreCliente + ":" + numeroAleatorio + "\r\n");
//		fw.close();
//
//	}

}
