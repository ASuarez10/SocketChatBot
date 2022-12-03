package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
		this.correoCliente = null;
	}

	@Override
	public void run() {

		Map<String, String> usuarios = new HashMap<String, String>();
		
		usuarios.put("sebastian@gmail.com", "1111");
		
		boolean parar = false;

		while (!parar) {

			try {
				out.writeUTF("Hola " + nombreCliente + "! Escoge una de las siguientes opciones: \n"
						+ "1. Ver emprendimientos. \n" + "2. Eres emprendedor. \n" + "3. PQRS. \n" + "4. Salir");

				int opcion = Integer.parseInt(in.readUTF());
				;

				switch (opcion) {

				// Ver emprendimientos
				case 1:
					boolean pararCategorias = false;

					while (!pararCategorias) {

						out.writeUTF(
								"Categorias disponibles: \n" + "1. Comida. \n" + "2. Accesorios. \n" + "0. Volver.");

						int opcionCategoria = Integer.parseInt(in.readUTF());
						;

						switch (opcionCategoria) {

						// Comida
						case 1:
							boolean pararComida = false;

							while (!pararComida) {

								out.writeUTF("Emprendimientos disponibles: \n" + "1. Cubanitos. \n" + "2. Ñam. \n"
										+ "0. Volver");

								int opcionComida = Integer.parseInt(in.readUTF());
								;

								switch (opcionComida) {

								// Cubanitos
								case 1:
									boolean pararCubanitos = false;

									while (!pararCubanitos) {
										out.writeUTF(
												"Productos/servicios disponibles: \n" + "1. Cubanito normal -- $3500 \n"
														+ "2. Cubanitos especial -- $4500 \n" + "0. Volver");

										int opcionCubanitos = Integer.parseInt(in.readUTF());
										;

										switch (opcionCubanitos) {

										// Cubanito normal
										case 1:
											boolean pararCN = false;

											while (!pararCN) {
												out.writeUTF(
														"Descripción: colita cubana con jamon, queso y salsa de ajo.\n"
																+ "1. Ordenar.\n" + "0. Volver.");

												int opcionCN = Integer.parseInt(in.readUTF());
												;

												switch (opcionCN) {

												// Ordenar
												case 1:
													boolean pararOrdenarCN = false;

													while (!pararOrdenarCN) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadCN = Integer.parseInt(in.readUTF());
														;

														if (cantidadCN != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccion = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadCN
																			+ "\n-Direccion: " + direccion
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarCN = true;
														pararCN = true;
													}

													break;

												// Volver
												case 0:
													pararCN = true;
													break;
												}
											}
											break;

										// Cubanito especial
										case 2:
											boolean pararCE = false;

											while (!pararCE) {
												out.writeUTF(
														"Descripción: colita cubana con doble jamon, doble queso y salsa de ajo.\n"
																+ "1. Ordenar.\n" + "0. Volver.");

												int opcionCE = Integer.parseInt(in.readUTF());
												;

												switch (opcionCE) {

												// Ordenar
												case 1:
													boolean pararOrdenarCE = false;

													while (!pararOrdenarCE) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadCE = Integer.parseInt(in.readUTF());
														;

														if (cantidadCE != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccionCE = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadCE
																			+ "\n-Direccion: " + direccionCE
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarCE = true;
														pararCE = true;
													}

													break;

												// Volver
												case 0:
													pararCE = true;
													break;
												}
											}
											break;

										// Volver
										case 0:
											pararCubanitos = true;
											break;
										}
									}

//									
									break;
								// Ñam
								case 2:

									boolean pararNam = false;

									while (!pararNam) {
										out.writeUTF(
												"Productos/servicios disponibles: \n" + "1. Ñam cordero -- $5000 \n"
														+ "2. Ñam pollo desmechado -- $5000 \n" + "0. Volver");

										int opcionNam = Integer.parseInt(in.readUTF());
										;

										switch (opcionNam) {

										// Ñam cordero
										case 1:
											boolean pararNC = false;

											while (!pararNC) {
												out.writeUTF(
														"Descripción: sandwich de pan arabe, cordero, queso y salsas.\n"
																+ "1. Ordenar.\n" + "0. Volver.");

												int opcionNC = Integer.parseInt(in.readUTF());
												;

												switch (opcionNC) {

												// Ordenar
												case 1:
													boolean pararOrdenarNC = false;

													while (!pararOrdenarNC) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadNC = Integer.parseInt(in.readUTF());
														;

														if (cantidadNC != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccionNC = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadNC
																			+ "\n-Direccion: " + direccionNC
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarNC = true;
														pararNC = true;
													}

													break;

												// Volver
												case 0:
													pararNC = true;
													break;
												}
											}
											break;

										// Ñam Pollo
										case 2:
											boolean pararNP = false;

											while (!pararNP) {
												out.writeUTF(
														"Descripción: sandwich de pan arabe, pollo desmechado, queso y salsaso.\n"
																+ "1. Ordenar.\n" + "0. Volver.");

												int opcionNP = Integer.parseInt(in.readUTF());
												;

												switch (opcionNP) {

												// Ordenar
												case 1:
													boolean pararOrdenarNP = false;

													while (!pararOrdenarNP) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadNP = Integer.parseInt(in.readUTF());
														;

														if (cantidadNP != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccionNP = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadNP
																			+ "\n-Direccion: " + direccionNP
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarNP = true;
														pararNP = true;
													}

													break;

												// Volver
												case 0:
													pararNP = true;
													break;
												}
											}
											break;

										// Volver
										case 0:
											pararNam = true;
											break;
										}
									}

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
								out.writeUTF(
										"Emprendimientos disponibles: \n" + "1. Pulseras de goma. \n" + "0. Volver");

								int opcionAccesorios = Integer.parseInt(in.readUTF());
								;

								switch (opcionAccesorios) {

								// Pulseras de goma
								case 1:

									boolean pararPulsera = false;

									while (!pararPulsera) {
										out.writeUTF(
												"Productos/servicios disponibles: \n" + "1. Pulsera escamas -- $3500 \n"
														+ "2. Pulsera ZigZag -- $4500 \n" + "0. Volver");

										int opcionPulsera = Integer.parseInt(in.readUTF());
										;

										switch (opcionPulsera) {

										// Pulsera escamas
										case 1:
											boolean pararPE = false;

											while (!pararPE) {
												out.writeUTF("Descripción: pulsera de goma con diseño de escamas.\n"
														+ "1. Ordenar.\n" + "0. Volver.");

												int opcionPE = Integer.parseInt(in.readUTF());
												;

												switch (opcionPE) {

												// Ordenar
												case 1:
													boolean pararOrdenarPE = false;

													while (!pararOrdenarPE) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadPE = Integer.parseInt(in.readUTF());
														;

														if (cantidadPE != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccionPE = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadPE
																			+ "\n-Direccion: " + direccionPE
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarPE = true;
														pararPE = true;
													}

													break;

												// Volver
												case 0:
													pararPE = true;
													break;
												}
											}
											break;

										// Pulsera ZigZag
										case 2:
											boolean pararPZ = false;

											while (!pararPZ) {
												out.writeUTF("Descripción: pulsera de goma con diseño ZigZag.\n"
														+ "1. Ordenar.\n" + "0. Volver.");

												int opcionPZ = Integer.parseInt(in.readUTF());
												;

												switch (opcionPZ) {

												// Ordenar
												case 1:
													boolean pararOrdenarPZ = false;

													while (!pararOrdenarPZ) {
														out.writeUTF(
																"¿Que cantidad deseas ordenar? En caso de ser un servicio digita 0.\n"
																		+ "Para volver digita 100");

														int cantidadPZ = Integer.parseInt(in.readUTF());
														;

														if (cantidadPZ != 100) {
															out.writeUTF(
																	"Escribe la direccion a donde quieres que vaya el emprendedor.");
															String direccionPZ = in.readUTF();
															out.writeUTF(
																	"Listo!. Se le envio el pedido al emprendedor:\n"
																			+ "-Unidades: " + cantidadPZ
																			+ "\n-Direccion: " + direccionPZ
																			+ "\nPronto te llegara un mensaje indicando si el emprendedor acepto o no el pedido.");
															in.readUTF();

														}
														pararOrdenarPZ = true;
														pararPZ = true;
													}

													break;

												// Volver
												case 0:
													pararPZ = true;
													break;
												}
											}
											break;

										// Volver
										case 0:
											pararPulsera = true;
											break;
										}
									}

//									
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
					
					if(correoCliente == null) {
						
						boolean pararEmprendedor = false;

						while (!pararEmprendedor) {

							out.writeUTF("Elige una de las siguientes: \n" + "1. Iniciar sesion. \n" + "2. Registrarse \n"
									+ "0. Volver.");

							int opcionEmprendedor = Integer.parseInt(in.readUTF());
							;

							switch (opcionEmprendedor) {

							// Iniciar sesion
							case 1:
								out.writeUTF("Digita tu correo registrado");
								String email = in.readUTF();
								//correoCliente = email;
								
								if(usuarios.containsKey(email)) {
									out.writeUTF("Digita tu contraseña");
									String password = in.readUTF();
									
								}else {
									
								}
								
								

								pararEmprendedor = true;

								break;

							// Registrarse
							case 2:
								out.writeUTF("Digita tu correo para registrar");
								String emailRegistro = in.readUTF();
								if(usuarios.containsKey(emailRegistro)) {
									out.writeUTF("Error! Este correo ya está registrado. Inicia sesion.");
									in.readUTF();
								}else {
									
									out.writeUTF("Digita tu contraseña.");
									String passwordRegistro = in.readUTF();
									out.writeUTF("Listo! Se ha registrado tu usuario.");
									out.writeUTF("Escribe tu nombre y apellidos para guardarlos en tu cuenta.");
									String nombreUsuarioNuevo = in.readUTF();
								}
								
								
								
								

								pararEmprendedor = true;

								break;
								
							// Volver
							case 0: 
								pararEmprendedor = true;
								break;
							}

						}
					}else {
						//TODO
					}
					
					
					
					break;

				// PQRS
				case 3:
					
					boolean pararPQRS = false;
					
					while(!pararPQRS) {
						
						out.writeUTF("Escoge una de las siguientes opciones:\n"
								+ 	 "1.Reportar PQRS.\n"
								+ 	 "0. Volver.");
						
						int opcionPQRS = Integer.parseInt(in.readUTF());
						
						switch(opcionPQRS) {
						
						case 1:
							
							if (correoCliente != null) {
								out.writeUTF("Listo! Enviaremos un mensaje a tu correo.");
								in.readUTF();
							} else {
								out.writeUTF("Ingresa tu correo electrónico para enviarte un mensaje y resolver tus inquietudes.");
								in.readUTF();
								out.writeUTF("Listo! Enviaremos un mensaje a tu correo.");
								in.readUTF();
							}
							
							pararPQRS = true;
							break;
							
						case 0:
							pararPQRS = true;
							break;
						}
						
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

}
