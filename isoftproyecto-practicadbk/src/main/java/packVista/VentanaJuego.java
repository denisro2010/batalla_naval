package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.BoxLayout;

import java.awt.Component;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import packControladores.ColocarBarcos;
import packModelos.Coordenadas;
import packModelos.barcos.TipoBarco;
import packModelos.tablero.Flota;
import packModelos.tablero.FlotaJugador;
import packModelos.tablero.FlotaOrdenador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaJuego extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7000472198076846515L;
	private JPanel contentPane;
	private JPanel panelTiro;
	private JPanel panelBarcos;
	private JPanel panelOrientacion;
	private JPanel panelArmamento;
	private final ButtonGroup botonesOrientacion = new ButtonGroup();
	private JButton botonBomba;
	private JButton botonMisil;
	private JButton botonEscudo;
	private JButton botonRadar;
	private JButton botonTienda;
	private static Flota flota;
	private final ButtonGroup botonArmamento = new ButtonGroup();
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalGlue_2;
	private static final int NumeroCasillas = 10;
	final static List<JButton> listaBotonesJugador = new ArrayList<JButton>();
	static List<Coordenadas> listaCoord = new ArrayList<Coordenadas>();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel panelCentro;
	private JPanel panelTipoBarco;
	private JButton botonPortavion;
	private JButton botonFragata;
	private JButton botonDestructor;
	private JButton botonSubmarino;
	private static JLabel lblCantidad;
	private static JLabel lblCantidad_1;
	private static JLabel lblCantidad_2;
	private static JLabel lblCantidad_3;
	private static JLabel lblDineroJuego;
	private Component horizontalStrut;
	private Component horizontalStrut_2;
	private Component horizontalGlue_3;
	private Component horizontalGlue_4;
	private static JLabel cantidadPortaaviones;
	private static JLabel cantidadFragatas;
	private static JLabel cantidadDestructores;
	private static JLabel cantidadSubmarinos;
	private Component horizontalGlue_5;
	private Component horizontalGlue_6;
	private int fila;
	private int columna;
	private Flota flotaJug;
	static Flota flotaIA;
	private boolean orientacion = true;
	private int x = 0;
	private int y = 0;
	private boolean portaavion = false;
	private static int numPortaaviones = 1;
	private boolean fragata = false;
	private static int numFragatas = 4;
	private static int numDestructores = 3;
	private boolean destructor = false;
	private static int numSubmarinos = 2;
	private boolean submarino = false;
	// El tipo de arma a usar (para el tiro)
	private static boolean usarBomba;
	private static boolean usarMisil;
	private static boolean usarRadar;
	private static boolean usarReparacion;
	private static boolean usarEscudo;
	private static boolean colocarBarcosJugador = false; // Indica si el jugador
															// ha
															// colocado todos
															// los barcos

	/*
	 * Colores Casillas
	 */
	static final Color agua = new Color(79, 171, 216);
	static final Color barco = new Color(96, 107, 119);
	static final Color barcoHundido = Color.RED;
	static final Color dado = Color.RED;
	static final Color tableroOculto = Color.BLACK; // para el panel de
	private JButton button;
	private static JLabel lblCantidad_4;
	private Component horizontalGlue_7;
	private Component horizontalGlue_8;
	private Component horizontalGlue_9;
	final static List<JButton> listaBotonesIA = new ArrayList<JButton>();
	static List<Coordenadas> listaCoordIA = new ArrayList<Coordenadas>();
	private static JLabel lblPuntos;
	private Component horizontalStrut_1;
	private JButton btnReiniciar;
	// tiro

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaJuego() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaJuego.class.getResource("/resources/tienda.png")));
		initialize();
	}

	private void initialize() {
		setBackground(new Color(176, 224, 230));
		setTitle("Practica DBK: Battleship");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1200, 800, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		contentPane.add(getPanelOrientacion(), BorderLayout.NORTH);
		contentPane.add(getPanelArmamento(), BorderLayout.SOUTH);
		centrarVentana();
		contentPane.add(getPanelTipoBarco(), BorderLayout.EAST);
	}

	private void centrarVentana() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		if (windowSize.height > screenSize.height) {
			windowSize.height = screenSize.height;
		}
		if (windowSize.width > screenSize.width) {
			windowSize.width = screenSize.width;
		}
		setLocation((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) / 2);
	}

	private JPanel getPanelTiro() {
		if (panelTiro == null) {
			panelTiro = new JPanel();
			panelTiro.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
			GridLayout gl_panelTiro = new GridLayout(10, 10);
			gl_panelTiro.setVgap(1);
			gl_panelTiro.setHgap(1);
			panelTiro.setLayout(gl_panelTiro);
			setFlotaIA(new FlotaOrdenador());
			for (int i = 0; i < 100; i++) {
				setFila(i / NumeroCasillas);
				setColumna(i % NumeroCasillas);
				JButton boton = new JButton();
				listaBotonesIA.add(boton);
				boton.setToolTipText(fila + " , " + columna);
				boton.setBackground(tableroOculto);
				boton.setBorderPainted(false);
				boton.setForeground(Color.cyan);
				boton.setOpaque(true);
				panelTiro.add(boton);
				Coordenadas c = new Coordenadas();
				c.setX(getFila());
				c.setY(getColumna());
				c.setObjetoGuardado(boton);
				listaCoordIA.add(c);
				boton.addActionListener(new ColocarBarcosIA());
				boton.addActionListener(new TiroJugador());
			}
		}
		return panelTiro;
	}

	public void setFlotaIA(Flota flotaIA) {
		VentanaJuego.flotaIA = flotaIA;
	}

	private JPanel getPanelBarcos() {
		if (panelBarcos == null) {
			panelBarcos = new JPanel();

			panelBarcos.setName("");
			panelBarcos.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
			GridLayout gl_panelBarcos = new GridLayout(10, 10);
			gl_panelBarcos.setVgap(1);
			gl_panelBarcos.setHgap(1);
			panelBarcos.setLayout(gl_panelBarcos);
			flotaJug = new FlotaJugador(VentanaNombreDeUsuario.jugador);
			for (int i = 0; i < 100; i++) {
				setFila(i / NumeroCasillas);
				setColumna(i % NumeroCasillas);
				JButton boton = new JButton();
				boton.setToolTipText(fila + " , " + columna);
				boton.setBackground(agua);
				boton.setBorderPainted(false);
				boton.setForeground(Color.blue);
				boton.setOpaque(true);
				boton.addActionListener(this);
				boton.addActionListener(new DefensaJugador());
				listaBotonesJugador.add(boton);
				panelBarcos.add(boton);

				// Guarda las coordenadas ordenadas ya que las que da el JTable
				// son
				// numeros muy grandes y caoticos
				Coordenadas c = new Coordenadas();
				c.setX(getFila());
				c.setY(getColumna());
				c.setObjetoGuardado(boton);
				listaCoord.add(c);
			}
		}
		return panelBarcos;
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton b;
		ColocarBarcos cb = new ColocarBarcos((FlotaJugador) flotaJug); // Comprobar
																		// que
																		// el
																		// barco
																		// no se
																		// sale
																		// del
																		// tablero

		if (portaavion && orientacion) { // Si se ha pulsado el boton portaavion
											// y la orientacion es horizontal

			cb.setTipoBarco(TipoBarco.PORTAAVIONES);
			cb.setOrientacionActual(true);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, true, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y); // Booleano
																// que
			// indica si NO
			// se
			// sale del
			// tablero
			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
													// barco
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {

					for (int k = y + 1; k < y + 4; k++) {
						b = getGridButton(x, k);
						pegado = comprobarBarcosPegados(b, true, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere || pegado) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = y + 1; i < y + 4; i++) {
							b = getGridButton(x, i);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numPortaaviones--;
					cantidadPortaaviones.setText("Cantidad: " + numPortaaviones);
					if (numPortaaviones == 0) {
						botonPortavion.setEnabled(false);
						portaavion = false;
					}
				}

			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);
		} // FIN

		else if (portaavion && !orientacion) { // Si se ha pulsado el boton
												// portaavion y la orientacion
												// es vertical

			cb.setTipoBarco(TipoBarco.PORTAAVIONES);
			cb.setOrientacionActual(false);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, false, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y); // Booleano
																// que
			// indica si NO
			// se
			// sale del
			// tablero

			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
													// barco
					b = (JButton) arg0.getSource();
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {
					for (int k = x + 1; k < x + 4; k++) {
						b = getGridButton(k, y);
						pegado = comprobarBarcosPegados(b, false, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = x + 1; i < x + 4; i++) {
							b = getGridButton(i, y);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numPortaaviones--;
					cantidadPortaaviones.setText("Cantidad: " + numPortaaviones);
					if (numPortaaviones == 0) {
						botonPortavion.setEnabled(false);
						portaavion = false;
					}
				}
			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);
		} // FIN

		else if (fragata) { // Si se ha pulsado el boton fragata
							// y la orientacion da igual porque la longitud = 1
			boolean sePuede;
			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, false, true, false);

			if (b.getBackground().equals(barco) || pegado) {
				// JOptionPane.showMessageDialog(null, "Cerca de esa posicion ya
				// existe un barco. Por favor elige otra.", "Error", 0);
				sePuede = false;
			} else {
				b.setBackground(barco);
				sePuede = true;
			}

			if (sePuede && !pegado) {
				// TODO poner lo de setPosBarco..
				numFragatas--;
				cantidadFragatas.setText("Cantidad: " + numFragatas);
				if (numFragatas == 0) {
					botonFragata.setEnabled(false);
					fragata = false;
				}
			}

			else
				JOptionPane.showMessageDialog(null, "No puedes colocar tu barco en este sitio. Por favor elige otro.",
						"Error", 0);
		} // FIN

		else if (destructor && orientacion) { // Si se ha pulsado el boton
												// destructor y la orientacion
												// es horizontal
			cb.setTipoBarco(TipoBarco.DESTRUCTOR);
			cb.setOrientacionActual(true);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, true, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y);
			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
													// barco
					b = (JButton) arg0.getSource();
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {
					for (int k = y + 1; k < y + 2; k++) {
						b = getGridButton(x, k);
						pegado = comprobarBarcosPegados(b, true, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = y + 1; i < y + 2; i++) {
							b = getGridButton(x, i);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numDestructores--;
					cantidadDestructores.setText("Cantidad: " + numDestructores);
					if (numDestructores == 0) {
						botonDestructor.setEnabled(false);
						destructor = false;
					}
				}
			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);
		} // FIN

		else if (destructor && !orientacion) { // Si se ha pulsado el boton //
												// destructor y la orientacion
												// es vertical
			cb.setTipoBarco(TipoBarco.DESTRUCTOR);
			cb.setOrientacionActual(false);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, false, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y);
			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
													// barco
					b = (JButton) arg0.getSource();
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {
					for (int k = x + 1; k < x + 2; k++) {
						b = getGridButton(k, y);
						pegado = comprobarBarcosPegados(b, false, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere || pegado) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = x + 1; i < x + 2; i++) {
							b = getGridButton(i, y);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numDestructores--;
					cantidadDestructores.setText("Cantidad: " + numDestructores);
					if (numDestructores == 0) {
						botonDestructor.setEnabled(false);
						destructor = false;
					}
				}
			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);

		} // FIN
		else if (submarino && orientacion) { // Si se ha pulsado el boton
												// destructor y la orientacion
												// es horizontal
			cb.setTipoBarco(TipoBarco.SUBMARINO);
			cb.setOrientacionActual(true);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, true, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y);
			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
					// barco
					b = (JButton) arg0.getSource();
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {
					for (int k = y + 1; k < y + 3; k++) {
						b = getGridButton(x, k);
						pegado = comprobarBarcosPegados(b, true, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere || pegado) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = y + 1; i < y + 3; i++) {
							b = getGridButton(x, i);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numSubmarinos--;
					cantidadSubmarinos.setText("Cantidad: " + numSubmarinos);
					if (numSubmarinos == 0) {
						botonSubmarino.setEnabled(false);
						submarino = false;
					}
				}
			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);

		} // FIN

		else if (submarino && !orientacion) { // Si se ha pulsado el boton
			// destructor y la orientacion
			// es vertical
			cb.setTipoBarco(TipoBarco.SUBMARINO);
			cb.setOrientacionActual(false);

			b = (JButton) arg0.getSource();
			boolean pegado = comprobarBarcosPegados(b, false, false, true);

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
			}
			boolean noSale = cb.comprobarPosicionBarco(x, y);
			boolean sePuede = false;
			boolean interfiere = false;

			if (noSale && !pegado) {

				if (b.getBackground() != barco) { // Si en ese sitio no hay otro
					// barco
					b = (JButton) arg0.getSource();
					b.setBackground(barco);
					sePuede = true;
				} else {
					JOptionPane.showMessageDialog(null, "No puedes colocar un barco encima de otro.", "Error", 0);
					sePuede = false;
				}

				if (sePuede) {
					for (int k = x + 1; k < x + 3; k++) {
						b = getGridButton(k, y);
						pegado = comprobarBarcosPegados(b, false, false, false);
						if (b.getBackground().equals(barco) || pegado) {
							interfiere = true;
						}
						if (interfiere || pegado) {
							b = (JButton) arg0.getSource();
							b.setBackground(agua);
						}
					} // Fin if sePuede

					if (!interfiere && !pegado) {
						for (int i = x + 1; i < x + 3; i++) {
							b = getGridButton(i, y);
							b.setBackground(barco);
						}
					} // Fin if interfiere
					else
						JOptionPane.showMessageDialog(null,
								"Cerca de esa posicion ya existe un barco. Por favor elige otra.", "Error", 0);

				}
				if (sePuede && !interfiere && !pegado) {
					// TODO poner lo de setPosBarco...
					numSubmarinos--;
					cantidadSubmarinos.setText("Cantidad: " + numSubmarinos);
					if (numSubmarinos == 0) {
						botonSubmarino.setEnabled(false);
						submarino = false;
					}
				}
			} else
				JOptionPane.showMessageDialog(null,
						"Tu barco se sale del tablero o esta pegado a otro barco. Por favor elige otra posicion.",
						"Error", 0);
		} // FIN
		/**
		 * Desactivar los botones de orientacion despues de haber colocado todos
		 * los barcos
		 **/
		if (numPortaaviones == 0 && numFragatas == 0 && numDestructores == 0 && numSubmarinos == 0) {
			rdbtnNewRadioButton.setEnabled(false);
			rdbtnNewRadioButton_1.setEnabled(false);
			JButton but = listaCoordIA.get(0).getObjetoGuardado();
			TiroJugador.setTurnoJugador(true);
			colocarBarcosJugador = true;
			but.doClick();
			ColocarBarcosIA.cambiarFondoBarco();
			JOptionPane.showMessageDialog(null,
					"El ordenador acaba de colocar sus barcos. Puedes disparar. Â¡Buena suerte!");
			for (JButton obj : listaBotonesJugador) {
				obj.removeActionListener(this);
			}
		}

	}

	public static boolean isUsarBomba() {
		return usarBomba;
	}

	public static void setUsarBomba(boolean pUsarBomba) {
		usarBomba = pUsarBomba;
	}

	public static boolean isUsarMisil() {
		return usarMisil;
	}

	public static void setUsarMisil(boolean pUsarMisil) {
		usarMisil = pUsarMisil;
	}

	public static boolean isUsarRadar() {
		return usarRadar;
	}

	public static void setUsarRadar(boolean pUsarRadar) {
		usarRadar = pUsarRadar;
	}

	public static boolean isUsarReparacion() {
		return usarReparacion;
	}

	public static void setUsarReparacion(boolean pUsarReparacion) {
		usarReparacion = pUsarReparacion;
	}

	public static boolean isUsarEscudo() {
		return usarEscudo;
	}

	public static void setUsarEscudo(boolean pUsarEscudo) {
		usarEscudo = pUsarEscudo;
	}

	public boolean comprobarBarcosPegados(JButton b, boolean pOrientacion, boolean esFragata, boolean primeraCasilla) {
		int xLado = 0;
		int yLado = 0;
		int xLado2 = 0;
		int yLado2 = 0;
		boolean pegado = false;

		if (pOrientacion == true && primeraCasilla == true) { // HORIZONTAL

			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					xLado = objeto.getX() + 1;
					xLado2 = objeto.getX() - 1;
					yLado = objeto.getY() + 1;
					yLado2 = objeto.getY() - 1;

					/*
					 * Por si la casilla proxima se sale del tablero, que no
					 * compruebe si hay un barco al lado
					 */
					JButton boton = new JButton();
					boton.setBackground(Color.RED);

					if (xLado < 10 && xLado >= 0)
						boton = getGridButton(xLado, objeto.getY());
					if (boton.getBackground().equals(barco))
						pegado = true;
					else {
						if (xLado2 < 10 && xLado2 >= 0)
							boton = getGridButton(xLado2, objeto.getY());
						if (boton.getBackground().equals(barco))
							pegado = true;
						else {
							if (yLado2 < 10 && yLado2 >= 0)
								boton = getGridButton(objeto.getX(), yLado2);
							if (boton.getBackground().equals(barco))
								pegado = true;
							//
							else {
								if (yLado2 < 10 && yLado2 >= 0 && xLado < 10 && xLado >= 0)
									boton = getGridButton(xLado, yLado2);
								if (boton.getBackground().equals(barco))
									pegado = true;
								else {
									if (yLado2 < 10 && yLado2 >= 0 && xLado2 < 10 && xLado2 >= 0)
										boton = getGridButton(xLado2, yLado2);
									if (boton.getBackground().equals(barco))
										pegado = true;
								}
							}
						}
					}
				} // FIN if1
			} // FIN for

		} else if (pOrientacion == false && primeraCasilla == true) { // VERTICAL
			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					xLado = objeto.getX() + 1;
					xLado2 = objeto.getX() - 1;
					yLado = objeto.getY() + 1;
					yLado2 = objeto.getY() - 1;

					/*
					 * Por si la casilla proxima se sale del tablero, que no
					 * compruebe si hay un barco al lado
					 */
					JButton boton = new JButton();
					boton.setBackground(Color.RED);

					if (xLado2 < 10 && xLado2 >= 0)
						boton = getGridButton(xLado2, objeto.getY());
					if (boton.getBackground().equals(barco))
						pegado = true;
					else {
						if (yLado < 10 && yLado >= 0)
							boton = getGridButton(objeto.getX(), yLado);
						if (boton.getBackground().equals(barco))
							pegado = true;
						else {
							if (yLado2 < 10 && yLado2 >= 0)
								boton = getGridButton(objeto.getX(), yLado2);
							if (boton.getBackground().equals(barco))
								pegado = true;
							//
							else {
								if (yLado < 10 && yLado >= 0 && xLado2 < 10 && xLado2 >= 0)
									boton = getGridButton(xLado2, yLado);
								if (boton.getBackground().equals(barco))
									pegado = true;
								else {
									if (yLado2 < 10 && yLado2 >= 0 && xLado2 < 10 && xLado2 >= 0)
										boton = getGridButton(xLado2, yLado2);
									if (boton.getBackground().equals(barco))
										pegado = true;
								}
							}
						}
					}
				} // FIN if1
			} // FIN for
		} else if (esFragata == true) { // El caso de la fragata, donde la
										// orientacion da igual
			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					xLado = objeto.getX() + 1;
					xLado2 = objeto.getX() - 1;
					yLado = objeto.getY() + 1;
					yLado2 = objeto.getY() - 1;

					/*
					 * Por si la casilla proxima se sale del tablero, que no
					 * compruebe si hay un barco al lado
					 */
					JButton boton = new JButton();
					boton.setBackground(Color.RED);

					if (xLado < 10 && xLado >= 0)
						boton = getGridButton(xLado, objeto.getY());
					if (boton.getBackground().equals(barco))
						pegado = true;
					else {
						if (xLado2 < 10 && xLado2 >= 0)
							boton = getGridButton(xLado2, objeto.getY());
						if (boton.getBackground().equals(barco))
							pegado = true;
						else {
							if (yLado < 10 && yLado >= 0)
								boton = getGridButton(objeto.getX(), yLado);
							if (boton.getBackground().equals(barco))
								pegado = true;
							else {
								if (yLado2 < 10 && yLado2 >= 0)
									boton = getGridButton(objeto.getX(), yLado2);
								if (boton.getBackground().equals(barco))
									pegado = true;
								//
								else {
									if (yLado < 10 && yLado >= 0 && xLado < 10 && xLado >= 0)
										boton = getGridButton(xLado, yLado);
									if (boton.getBackground().equals(barco))
										pegado = true;
									else {
										if (yLado < 10 && yLado >= 0 && xLado2 < 10 && xLado2 >= 0)
											boton = getGridButton(xLado2, yLado);
										if (boton.getBackground().equals(barco))
											pegado = true;
										//
										else {
											if (yLado2 < 10 && yLado2 >= 0 && xLado < 10 && xLado >= 0)
												boton = getGridButton(xLado, yLado2);
											if (boton.getBackground().equals(barco))
												pegado = true;
											else {
												if (yLado2 < 10 && yLado2 >= 0 && xLado2 < 10 && xLado2 >= 0)
													boton = getGridButton(xLado2, yLado2);
												if (boton.getBackground().equals(barco))
													pegado = true;
											}
										}
									}
								}
							}
						}
					}
				} // FIN if1
			} // FIN for

		} else if (pOrientacion == true && primeraCasilla == false) {
			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					xLado = objeto.getX() + 1;
					xLado2 = objeto.getX() - 1;
					yLado = objeto.getY() + 1;
					yLado2 = objeto.getY() - 1;

					/*
					 * Por si la casilla proxima se sale del tablero, que no
					 * compruebe si hay un barco al lado
					 */
					JButton boton = new JButton();
					boton.setBackground(Color.RED);

					if (xLado < 10 && xLado >= 0)
						boton = getGridButton(xLado, objeto.getY());
					if (boton.getBackground().equals(barco))
						pegado = true;
					else {
						if (xLado2 < 10 && xLado2 >= 0)
							boton = getGridButton(xLado2, objeto.getY());
						if (boton.getBackground().equals(barco))
							pegado = true;
						else {
							if (yLado < 10 && yLado >= 0)
								boton = getGridButton(objeto.getX(), yLado);
							if (boton.getBackground().equals(barco))
								pegado = true;
							else {
								if (yLado < 10 && yLado >= 0 && xLado < 10 && xLado >= 0)
									boton = getGridButton(xLado, yLado);
								if (boton.getBackground().equals(barco))
									pegado = true;
								else {
									if (yLado < 10 && yLado >= 0 && xLado2 < 10 && xLado2 >= 0)
										boton = getGridButton(xLado2, yLado);
									if (boton.getBackground().equals(barco))
										pegado = true;
								}
							}
						}
					}
				} // FIN if1
			} // FIN for

		} else if (pOrientacion == false && primeraCasilla == false) {
			for (Coordenadas objeto : listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					xLado = objeto.getX() + 1;
					xLado2 = objeto.getX() - 1;
					yLado = objeto.getY() + 1;
					yLado2 = objeto.getY() - 1;

					/*
					 * Por si la casilla proxima se sale del tablero, que no
					 * compruebe si hay un barco al lado
					 */
					JButton boton = new JButton();
					boton.setBackground(Color.RED);

					if (xLado < 10 && xLado >= 0)
						boton = getGridButton(xLado, objeto.getY());
					if (boton.getBackground().equals(barco))
						pegado = true;
					else {
						if (yLado < 10 && yLado >= 0)
							boton = getGridButton(objeto.getX(), yLado);
						if (boton.getBackground().equals(barco))
							pegado = true;
						else {
							if (yLado2 < 10 && yLado2 >= 0)
								boton = getGridButton(objeto.getX(), yLado2);
							if (boton.getBackground().equals(barco))
								pegado = true;
							else {
								if (yLado < 10 && yLado >= 0 && xLado < 10 && xLado >= 0)
									boton = getGridButton(xLado, yLado);
								if (boton.getBackground().equals(barco))
									pegado = true;
								else {
									if (yLado2 < 10 && yLado2 >= 0 && xLado < 10 && xLado >= 0)
										boton = getGridButton(xLado, yLado2);
									if (boton.getBackground().equals(barco))
										pegado = true;
								}
							}
						}
					}
				} // FIN if1
			} // FIN for
		}
		return pegado;
	}

	public static JButton getGridButton(int pFila, int pColumna) {
		int index;

		index = pFila * 10 + pColumna;

		return listaBotonesJugador.get(index);
	}

	public static List<Coordenadas> getListaCoordIA() {
		return listaCoordIA;
	}

	private JPanel getPanelOrientacion() {
		if (panelOrientacion == null) {
			panelOrientacion = new JPanel();
			panelOrientacion.setLayout(new BoxLayout(panelOrientacion, BoxLayout.X_AXIS));
			panelOrientacion.add(getRdbtnNewRadioButton());
			panelOrientacion.add(getRdbtnNewRadioButton_1());
			panelOrientacion.add(getHorizontalGlue_2());
		}
		return panelOrientacion;
	}

	private JPanel getPanelArmamento() {
		if (panelArmamento == null) {
			panelArmamento = new JPanel();
			panelArmamento.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
			panelArmamento.add(getHorizontalGlue());
			panelArmamento.add(getHorizontalGlue_4());
			panelArmamento.add(getHorizontalGlue_9());
			panelArmamento.add(getBotonBomba());
			panelArmamento.add(getLblCantidad());
			panelArmamento.add(getBotonMisil());
			panelArmamento.add(getLblCantidad_1());
			panelArmamento.add(getBotonEscudo());
			panelArmamento.add(getLblCantidad_2());
			panelArmamento.add(getBotonRadar());
			panelArmamento.add(getLblCantidad_3());
			panelArmamento.add(getButton());
			panelArmamento.add(getLblCantidad_4());
			panelArmamento.add(getHorizontalStrut());
			panelArmamento.add(getHorizontalGlue_5());
			panelArmamento.add(getHorizontalGlue_6());
			panelArmamento.add(getHorizontalGlue_7());
			panelArmamento.add(getHorizontalStrut_2());
			panelArmamento.add(getBotonTienda());
			panelArmamento.add(getHorizontalGlue_8());
			panelArmamento.add(getLblDinero());
			panelArmamento.add(getHorizontalStrut_1());
			panelArmamento.add(getLblPuntos());
			panelArmamento.add(getBtnReiniciar());
			panelArmamento.add(getHorizontalGlue_3());
			panelArmamento.add(getHorizontalGlue_1());
		}
		return panelArmamento;
	}

	private JButton getBotonBomba() {
		if (botonBomba == null) {
			botonBomba = new JButton("");
			try {
				Image img = ImageIO.read(getClass().getResource("/resources/bomba.png"));
				botonBomba.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/bomba.png")));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			botonArmamento.add(botonBomba);
			// botonBomba.setIcon(new
			// ImageIcon(this.getClass().getResource(String.format("/resources/bomba.png"))));
			botonBomba.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					if (VentanaNombreDeUsuario.jugador.getNumBombas() < 1) {
						JOptionPane.showMessageDialog(null, "No tienes bombas. Puedes adquirir mas en la tienda",
								"Advertencia", 0);
						usarBomba = false;
					} else {
						usarBomba = true;
						usarMisil = false;
						usarRadar = false;
						usarReparacion = false;
						usarEscudo = false;
					}
				}
			});
		}
		return botonBomba;
	}

	private JButton getBotonMisil() {
		if (botonMisil == null) {
			botonMisil = new JButton("");
			try {
				Image img = ImageIO.read(getClass().getResource("/resources/misil.png"));
				botonMisil.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/misil.png")));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			botonArmamento.add(botonMisil);
			botonMisil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (VentanaNombreDeUsuario.jugador.getNumMisiles() < 1) {
						JOptionPane.showMessageDialog(null, "No tienes misiles. Puedes adquirir mas en la tienda",
								"Advertencia", 0);
						usarMisil = false;
					} else {
						usarBomba = false;
						usarMisil = true;
						usarRadar = false;
						usarReparacion = false;
						usarEscudo = false;
					}
				}
			});
		}
		return botonMisil;
	}

	private JButton getBotonEscudo() {
		if (botonEscudo == null) {
			botonEscudo = new JButton("");
			try {
				Image img = ImageIO.read(getClass().getResource("/resources/escudo.png"));
				botonEscudo.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/escudo.png")));
			} catch (Exception ex) {
				System.out.println(ex);
			}
			botonArmamento.add(botonEscudo);
			botonEscudo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (VentanaNombreDeUsuario.jugador.getNumEscudos() < 1) {
						JOptionPane.showMessageDialog(null, "No tienes escudos. Puedes adquirir mas en la tienda",
								"Advertencia", 0);
						usarEscudo = false;
					} else {
						usarBomba = false;
						usarMisil = false;
						usarRadar = false;
						usarReparacion = false;
						usarEscudo = true;
					}
				}
			});
		}
		return botonEscudo;
	}

	private JButton getBotonRadar() {
		if (botonRadar == null) {
			botonRadar = new JButton("");
			botonRadar.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/radar.png")));
			botonArmamento.add(botonRadar);
			botonRadar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (VentanaNombreDeUsuario.jugador.getNumRadares() < 1) {
						JOptionPane.showMessageDialog(null, "No tienes radares. Puedes adquirir mas en la tienda",
								"Advertencia", 0);
						usarRadar = false;
					} else {
						usarBomba = false;
						usarMisil = false;
						usarRadar = true;
						usarReparacion = false;
						usarEscudo = false;
					}
				}
			});
		}
		return botonRadar;
	}

	private JButton getBotonTienda() {
		if (botonTienda == null) {
			botonTienda = new JButton("");
			botonTienda.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/tienda.png")));
			botonTienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaTienda vT = new VentanaTienda();
					vT.setVisible(true);
				}
			});
			botonArmamento.add(botonTienda);
		}
		return botonTienda;
	}

	private Component getHorizontalGlue() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}

	private Component getHorizontalGlue_1() {
		if (horizontalGlue_1 == null) {
			horizontalGlue_1 = Box.createHorizontalGlue();
		}
		return horizontalGlue_1;
	}

	private Component getHorizontalGlue_2() {
		if (horizontalGlue_2 == null) {
			horizontalGlue_2 = Box.createHorizontalGlue();
		}
		return horizontalGlue_2;
	}

	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Barco horizontal");
			botonesOrientacion.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setSelected(true);
			rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setOrientacion(true);
				}
			});
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Barco vertical");
			botonesOrientacion.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setOrientacion(false);
				}
			});
		}
		return rdbtnNewRadioButton_1;
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(0, 2, 1, 1));
			panelCentro.add(getPanelBarcos());
			panelCentro.add(getPanelTiro());

		}
		return panelCentro;

	}

	private JPanel getPanelTipoBarco() {
		if (panelTipoBarco == null) {
			panelTipoBarco = new JPanel();
			panelTipoBarco.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
			GridBagLayout gbl_panelTipoBarco = new GridBagLayout();
			gbl_panelTipoBarco.columnWidths = new int[] { 62, 0 };
			gbl_panelTipoBarco.rowHeights = new int[] { 51, 38, 0, 55, 31, 36, 44, 31, 27, 23, 0, 0 };
			gbl_panelTipoBarco.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panelTipoBarco.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0,
					Double.MIN_VALUE };
			panelTipoBarco.setLayout(gbl_panelTipoBarco);
			GridBagConstraints gbc_botonPortavion = new GridBagConstraints();
			gbc_botonPortavion.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonPortavion.insets = new Insets(0, 0, 5, 0);
			gbc_botonPortavion.gridx = 0;
			gbc_botonPortavion.gridy = 0;
			panelTipoBarco.add(getBotonPortavion(), gbc_botonPortavion);
			GridBagConstraints gbc_cantidadPortaaviones = new GridBagConstraints();
			gbc_cantidadPortaaviones.insets = new Insets(0, 0, 5, 0);
			gbc_cantidadPortaaviones.gridx = 0;
			gbc_cantidadPortaaviones.gridy = 1;
			panelTipoBarco.add(getCantidadPortaaviones(), gbc_cantidadPortaaviones);
			GridBagConstraints gbc_botonSubmarino = new GridBagConstraints();
			gbc_botonSubmarino.insets = new Insets(0, 0, 5, 0);
			gbc_botonSubmarino.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonSubmarino.gridx = 0;
			gbc_botonSubmarino.gridy = 3;
			panelTipoBarco.add(getBotonSubmarino(), gbc_botonSubmarino);
			GridBagConstraints gbc_cantidadSubmarinos = new GridBagConstraints();
			gbc_cantidadSubmarinos.insets = new Insets(0, 0, 5, 0);
			gbc_cantidadSubmarinos.gridx = 0;
			gbc_cantidadSubmarinos.gridy = 4;
			panelTipoBarco.add(getCantidadSubmarinos(), gbc_cantidadSubmarinos);
			GridBagConstraints gbc_botonDestructor = new GridBagConstraints();
			gbc_botonDestructor.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonDestructor.insets = new Insets(0, 0, 5, 0);
			gbc_botonDestructor.gridx = 0;
			gbc_botonDestructor.gridy = 6;
			panelTipoBarco.add(getBotonDestructor(), gbc_botonDestructor);
			GridBagConstraints gbc_cantidadDestructores = new GridBagConstraints();
			gbc_cantidadDestructores.insets = new Insets(0, 0, 5, 0);
			gbc_cantidadDestructores.gridx = 0;
			gbc_cantidadDestructores.gridy = 7;
			panelTipoBarco.add(getCantidadDestructores(), gbc_cantidadDestructores);
			GridBagConstraints gbc_botonFragata = new GridBagConstraints();
			gbc_botonFragata.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonFragata.insets = new Insets(0, 0, 5, 0);
			gbc_botonFragata.gridx = 0;
			gbc_botonFragata.gridy = 9;
			panelTipoBarco.add(getBotonFragata(), gbc_botonFragata);
			GridBagConstraints gbc_cantidadFragatas = new GridBagConstraints();
			gbc_cantidadFragatas.gridx = 0;
			gbc_cantidadFragatas.gridy = 10;
			panelTipoBarco.add(getCantidadFragatas(), gbc_cantidadFragatas);
		}
		return panelTipoBarco;
	}

	private JButton getBotonPortavion() {
		if (botonPortavion == null) {
			botonPortavion = new JButton("Portaavion");
			botonPortavion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					portaavion = true;
					fragata = false;
					destructor = false;
					submarino = false;
				}
			});

			botonPortavion.setMinimumSize(new Dimension(75, 29));
			botonPortavion.setMaximumSize(new Dimension(75, 29));
		}
		return botonPortavion;
	}

	private JButton getBotonFragata() {
		if (botonFragata == null) {
			botonFragata = new JButton("Fragata");
			botonFragata.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fragata = true;
					portaavion = false;
					destructor = false;
					submarino = false;
				}
			});
		}
		return botonFragata;
	}

	private JButton getBotonDestructor() {
		if (botonDestructor == null) {
			botonDestructor = new JButton("Destructor");
			botonDestructor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					destructor = true;
					portaavion = false;
					fragata = false;
					submarino = false;
				}
			});
		}
		return botonDestructor;
	}

	private JButton getBotonSubmarino() {
		if (botonSubmarino == null) {
			botonSubmarino = new JButton("Submarino");
			botonSubmarino.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					submarino = true;
					portaavion = false;
					fragata = false;
					destructor = false;
				}
			});
		}
		return botonSubmarino;
	}

	public String getNombreJugador() {
		return VentanaNombreDeUsuario.jugador.getNombre();
	}

	protected static JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumBombas());
		}
		return lblCantidad;
	}

	static JLabel getLblCantidad_1() {
		if (lblCantidad_1 == null) {
			lblCantidad_1 = new JLabel("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumMisiles());
		}
		return lblCantidad_1;
	}

	static JLabel getLblCantidad_2() {
		if (lblCantidad_2 == null) {
			lblCantidad_2 = new JLabel("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumEscudos());
		}
		return lblCantidad_2;
	}

	static JLabel getLblCantidad_3() {
		if (lblCantidad_3 == null) {
			lblCantidad_3 = new JLabel("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumRadares());
		}
		return lblCantidad_3;
	}

	/**
	 * Protected para que el dinero mostrado en esta ventana se actualice segun
	 * lo que se haga en la ventana de la tienda
	 */
	protected static JLabel getLblDinero() {
		if (lblDineroJuego == null) {
			lblDineroJuego = new JLabel("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
		}
		return lblDineroJuego;
	}

	private Component getHorizontalStrut() {
		if (horizontalStrut == null) {
			horizontalStrut = Box.createHorizontalStrut(20);
		}
		return horizontalStrut;
	}

	private Component getHorizontalStrut_2() {
		if (horizontalStrut_2 == null) {
			horizontalStrut_2 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_2;
	}

	private Component getHorizontalGlue_3() {
		if (horizontalGlue_3 == null) {
			horizontalGlue_3 = Box.createHorizontalGlue();
		}
		return horizontalGlue_3;
	}

	private Component getHorizontalGlue_4() {
		if (horizontalGlue_4 == null) {
			horizontalGlue_4 = Box.createHorizontalGlue();
		}
		return horizontalGlue_4;
	}

	static JLabel getCantidadPortaaviones() {
		if (cantidadPortaaviones == null) {
			cantidadPortaaviones = new JLabel("Cantidad: " + numPortaaviones);
		}
		return cantidadPortaaviones;
	}

	static JLabel getCantidadFragatas() {
		if (cantidadFragatas == null) {
			cantidadFragatas = new JLabel("Cantidad: " + numFragatas);
		}
		return cantidadFragatas;
	}

	static JLabel getCantidadDestructores() {
		if (cantidadDestructores == null) {
			cantidadDestructores = new JLabel("Cantidad: " + numDestructores);
		}
		return cantidadDestructores;
	}

	static JLabel getCantidadSubmarinos() {
		if (cantidadSubmarinos == null) {
			cantidadSubmarinos = new JLabel("Cantidad: " + numSubmarinos);
		}
		return cantidadSubmarinos;
	}

	private Component getHorizontalGlue_5() {
		if (horizontalGlue_5 == null) {
			horizontalGlue_5 = Box.createHorizontalGlue();
		}
		return horizontalGlue_5;
	}

	private Component getHorizontalGlue_6() {
		if (horizontalGlue_6 == null) {
			horizontalGlue_6 = Box.createHorizontalGlue();
		}
		return horizontalGlue_6;
	}

	public Flota getFlota() {
		return flota;
	}

	public void setFlota(Flota pFlota) {
		flota = pFlota;
	}

	public void setFila(int pFila) {
		fila = pFila;
	}

	public void setColumna(int pColumna) {
		columna = pColumna;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public static int getNumSubmarinos() {
		return numSubmarinos;
	}

	public static void setNumSubmarinos(int pNumSubmarinos) {
		numSubmarinos = pNumSubmarinos;
	}

	public boolean isSubmarino() {
		return submarino;
	}

	public void setSubmarino(boolean pSubmarino) {
		submarino = pSubmarino;
	}

	public boolean isOrientacion() {
		return orientacion;
	}

	public void setOrientacion(boolean orientacion) {
		this.orientacion = orientacion;
	}

	public boolean isPortaavion() {
		return portaavion;
	}

	public void setPortaavion(boolean portaavion) {
		this.portaavion = portaavion;
	}

	public int getX() {
		return x;
	}

	public void setX(int pX) {
		x = pX;
	}

	public int getY() {
		return y;
	}

	public void setY(int pY) {
		y = pY;
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.setIcon(new ImageIcon(VentanaJuego.class.getResource("/resources/arreglar.png")));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (VentanaNombreDeUsuario.jugador.getNumReparaciones() < 1) {
						JOptionPane.showMessageDialog(null,
								"No tienes creditos de reparaciones. Puedes adquirir mas en la tienda", "Advertencia",
								0);
						usarReparacion = false;
					} else {
						usarBomba = false;
						usarMisil = false;
						usarRadar = false;
						usarReparacion = true;
						usarEscudo = false;
					}
				}
			});
		}
		return button;
	}

	static JLabel getLblCantidad_4() {
		if (lblCantidad_4 == null) {
			lblCantidad_4 = new JLabel("Cantidad " + VentanaNombreDeUsuario.jugador.getNumReparaciones());
		}
		return lblCantidad_4;
	}

	private Component getHorizontalGlue_7() {
		if (horizontalGlue_7 == null) {
			horizontalGlue_7 = Box.createHorizontalGlue();
		}
		return horizontalGlue_7;
	}

	private Component getHorizontalGlue_8() {
		if (horizontalGlue_8 == null) {
			horizontalGlue_8 = Box.createHorizontalGlue();
		}
		return horizontalGlue_8;
	}

	private Component getHorizontalGlue_9() {
		if (horizontalGlue_9 == null) {
			horizontalGlue_9 = Box.createHorizontalGlue();
		}
		return horizontalGlue_9;
	}

	public static boolean isColocarBarcosJugador() {
		return colocarBarcosJugador;
	}

	public Flota getFlotaIA() {
		return flotaIA;
	}

	static JLabel getLblPuntos() {
		if (lblPuntos == null) {
			lblPuntos = new JLabel("Puntos: " + TiroJugador.getPuntuacion());
		}
		return lblPuntos;
	}

	private Component getHorizontalStrut_1() {
		if (horizontalStrut_1 == null) {
			horizontalStrut_1 = Box.createHorizontalStrut(20);
		}
		return horizontalStrut_1;
	}

	private JButton getBtnReiniciar() {
		if (btnReiniciar == null) {
			btnReiniciar = new JButton("");
			btnReiniciar.setIcon(
					new ImageIcon(VentanaJuego.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
			btnReiniciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Cuando el juego haya finalizado...
					// o antes de que haya finalizado... por si el jugador
					// quiere reiniciar la partida o ver las puntuaciones

					if (JOptionPane.showConfirmDialog(null, "¿Volver al menu principal?", "Advertencia",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
						VentanaPrincipal vP = new VentanaPrincipal();
						vP.setVisible(true);
						dispose();
					}

				}
			});
		}
		return btnReiniciar;
	}
}
