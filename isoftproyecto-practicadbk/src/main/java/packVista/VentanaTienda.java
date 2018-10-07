package packVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import java.awt.Component;

import javax.swing.Box;

import packModelos.tiendaYarmamento.Bomba;
import packModelos.tiendaYarmamento.Escudo;
import packModelos.tiendaYarmamento.Misil;
import packModelos.tiendaYarmamento.Radar;
import packModelos.tiendaYarmamento.Reparacion;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class VentanaTienda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3450761459643576312L;
	private final JPanel panelArmas = new JPanel();
	private static final int maxNumArmasComprar = 5;
	private int precioTotal_RADAR = 0;
	private int precioTotal_ESCUDO = 0;
	private int precioTotal_BOMBA = 0;
	private int precioTotal_MISIL = 0;
	private int precioTotal_REPARACION = 0;
	private int precioTotal = 0;
	private int precioBomba = new Bomba().getPrecio().getCantidad();
	private int precioRadar = new Radar().getPrecio().getCantidad();
	private int precioMisil = new Misil().getPrecio().getCantidad();
	private int precioEscudo = new Escudo().getPrecio().getCantidad();
	private int precioReparacion = new Reparacion().getPrecio().getCantidad();
	/**
	 * Estos atributos solo sirven para comunicar el boton comprar con el
	 * JComboBox, no indica cuantas armas tiene el jugador realmente
	 **/
	private static int cantBombas = 0;
	private static int cantMisiles = 0;
	private static int cantEscudos = 0;
	private static int cantRadares = 0;
	private static int cantReparacion = 0;
	/**
	 * He definido el JLabel fuera del todo para que todas las armas puedan
	 * acceder a el, si no, se crearian tantos JLabel como armas existen, uno
	 * encima del otro.
	 */
	JLabel lblDinero = new JLabel("Precio total " + precioTotal);

	public static void main(String[] args) {
		try {
			VentanaTienda dialog = new VentanaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setCantReparacion(int pCantReparacion) {
		cantReparacion = pCantReparacion;
	}

	public int getPrecioTotal_REPARACION() {
		return precioTotal_REPARACION;
	}

	public void setPrecioTotal_REPARACION(int pPrecioTotal_REPARACION) {
		precioTotal_REPARACION = pPrecioTotal_REPARACION;
	}
	
	public static int getCantReparacion() {
		return cantReparacion;
	}

	public static int getCantBombas() {
		return cantBombas;
	}

	public static int getCantMisiles() {
		return cantMisiles;
	}

	public static int getCantEscudos() {
		return cantEscudos;
	}

	public static int getCantRadares() {
		return cantRadares;
	}

	public void setCantBombas(int cantBombas) {
		VentanaTienda.cantBombas = cantBombas;
	}

	public void setCantMisiles(int cantMisiles) {
		VentanaTienda.cantMisiles = cantMisiles;
	}

	public void setCantEscudos(int cantEscudos) {
		VentanaTienda.cantEscudos = cantEscudos;
	}

	public void setCantRadares(int cantRadares) {
		VentanaTienda.cantRadares = cantRadares;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public void setPrecioTotal_RADAR(int precioTotal_RADAR) {
		this.precioTotal_RADAR = precioTotal_RADAR;
	}

	public void setPrecioTotal_ESCUDO(int precioTotal_ESCUDO) {
		this.precioTotal_ESCUDO = precioTotal_ESCUDO;
	}

	public void setPrecioTotal_BOMBA(int precioTotal_BOMBA) {
		this.precioTotal_BOMBA = precioTotal_BOMBA;
	}

	public void setPrecioTotal_MISIL(int precioTotal_MISIL) {
		this.precioTotal_MISIL = precioTotal_MISIL;
	}

	public VentanaTienda() {
		setSize(new Dimension(800, 500));
		initialize();
		// Colocar ventana en el centro
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

	private void initialize() {
		setTitle("Tienda");
		// setBounds(100, 100, 500, 320);
		getContentPane().setLayout(new BorderLayout());
		panelArmas.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelArmas, BorderLayout.CENTER);
		GridBagLayout gbl_panelArmas = new GridBagLayout();
		gbl_panelArmas.columnWidths = new int[] { 0, 73, 110, 110, 110, 110, 110, 90, 8, 0 };
		gbl_panelArmas.rowHeights = new int[] { 101, 0, 29, 0, 0 };
		gbl_panelArmas.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelArmas.rowWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		panelArmas.setLayout(gbl_panelArmas);
		{
			JLabel lblPrecioRadar = new JLabel("Precio: 500");
			GridBagConstraints gbc_lblPrecioRadar = new GridBagConstraints();
			gbc_lblPrecioRadar.fill = GridBagConstraints.VERTICAL;
			gbc_lblPrecioRadar.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioRadar.gridx = 2;
			gbc_lblPrecioRadar.gridy = 0;
			panelArmas.add(lblPrecioRadar, gbc_lblPrecioRadar);
		}
		{
			JLabel lblNewLabel = new JLabel("Precio: 200");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 3;
			gbc_lblNewLabel.gridy = 0;
			panelArmas.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblPrecioMisil = new JLabel("Precio: 300");
			GridBagConstraints gbc_lblPrecioMisil = new GridBagConstraints();
			gbc_lblPrecioMisil.fill = GridBagConstraints.VERTICAL;
			gbc_lblPrecioMisil.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioMisil.gridx = 4;
			gbc_lblPrecioMisil.gridy = 0;
			panelArmas.add(lblPrecioMisil, gbc_lblPrecioMisil);
		}
		{
			JLabel lblPrecio = new JLabel("Precio: 100");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.fill = GridBagConstraints.VERTICAL;
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 5;
			gbc_lblPrecio.gridy = 0;
			panelArmas.add(lblPrecio, gbc_lblPrecio);
		}
		{
			final JComboBox radar = new JComboBox();
			GridBagConstraints gbc_radar = new GridBagConstraints();
			gbc_radar.insets = new Insets(0, 0, 5, 5);
			gbc_radar.fill = GridBagConstraints.BOTH;
			gbc_radar.gridx = 2;
			gbc_radar.gridy = 2;

			for (int i = 0; i <= maxNumArmasComprar; i++) {
				radar.addItem(new Integer(i));
			}

			radar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int state = (Integer) radar.getSelectedItem();

					if (state == 1) {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(1);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 2) {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(2);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 3) {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(3);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 4) {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(4);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 5) {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(5);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else {
						precioTotal_RADAR = state * precioRadar;
						setPrecioTotal_RADAR(precioTotal_RADAR);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantRadares(0);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					}
				}
			});
			{
				JLabel lblPrecioReparacion = new JLabel("Precio: " + precioReparacion);
				GridBagConstraints gbc_lblPrecioReparacion = new GridBagConstraints();
				gbc_lblPrecioReparacion.insets = new Insets(0, 0, 5, 5);
				gbc_lblPrecioReparacion.gridx = 6;
				gbc_lblPrecioReparacion.gridy = 0;
				panelArmas.add(lblPrecioReparacion, gbc_lblPrecioReparacion);
			}

			{
				JLabel lblTuDinero = new JLabel("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
				GridBagConstraints gbc_lblTuDinero = new GridBagConstraints();
				gbc_lblTuDinero.fill = GridBagConstraints.VERTICAL;
				gbc_lblTuDinero.insets = new Insets(0, 0, 5, 5);
				gbc_lblTuDinero.gridx = 7;
				gbc_lblTuDinero.gridy = 0;
				panelArmas.add(lblTuDinero, gbc_lblTuDinero);
			}
			{
				JLabel lblRadar = new JLabel("Radar");
				lblRadar.setIcon(new ImageIcon(VentanaTienda.class.getResource("/resources/radar.png")));
				GridBagConstraints gbc_lblRadar = new GridBagConstraints();
				gbc_lblRadar.insets = new Insets(0, 0, 5, 5);
				gbc_lblRadar.gridx = 2;
				gbc_lblRadar.gridy = 1;
				panelArmas.add(lblRadar, gbc_lblRadar);
			}
			{
				JLabel lblEscudo = new JLabel("Escudo");
				lblEscudo.setIcon(new ImageIcon(VentanaTienda.class.getResource("/resources/escudo.png")));
				GridBagConstraints gbc_lblEscudo = new GridBagConstraints();
				gbc_lblEscudo.insets = new Insets(0, 0, 5, 5);
				gbc_lblEscudo.gridx = 3;
				gbc_lblEscudo.gridy = 1;
				panelArmas.add(lblEscudo, gbc_lblEscudo);
			}
			{
				JLabel lblMisil = new JLabel("Misil");
				lblMisil.setIcon(new ImageIcon(VentanaTienda.class.getResource("/resources/misil.png")));
				GridBagConstraints gbc_lblMisil = new GridBagConstraints();
				gbc_lblMisil.insets = new Insets(0, 0, 5, 5);
				gbc_lblMisil.gridx = 4;
				gbc_lblMisil.gridy = 1;
				panelArmas.add(lblMisil, gbc_lblMisil);
			}
			{
				JLabel lblBomba = new JLabel("Bomba");
				lblBomba.setIcon(new ImageIcon(VentanaTienda.class.getResource("/resources/bomba.png")));
				GridBagConstraints gbc_lblBomba = new GridBagConstraints();
				gbc_lblBomba.insets = new Insets(0, 0, 5, 5);
				gbc_lblBomba.gridx = 5;
				gbc_lblBomba.gridy = 1;
				panelArmas.add(lblBomba, gbc_lblBomba);
			}
			{
				JLabel lblReparacion = new JLabel("Reparacion");
				lblReparacion.setIcon(new ImageIcon(VentanaTienda.class.getResource("/resources/arreglar.png")));
				GridBagConstraints gbc_lblReparacion = new GridBagConstraints();
				gbc_lblReparacion.insets = new Insets(0, 0, 5, 5);
				gbc_lblReparacion.gridx = 6;
				gbc_lblReparacion.gridy = 1;
				panelArmas.add(lblReparacion, gbc_lblReparacion);
			}
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
				gbc_horizontalGlue.fill = GridBagConstraints.VERTICAL;
				gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
				gbc_horizontalGlue.gridx = 0;
				gbc_horizontalGlue.gridy = 2;
				panelArmas.add(horizontalGlue, gbc_horizontalGlue);
			}
			{
				JLabel lblCantidad = new JLabel("Cantidad");
				GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
				gbc_lblCantidad.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblCantidad.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidad.gridx = 1;
				gbc_lblCantidad.gridy = 2;
				panelArmas.add(lblCantidad, gbc_lblCantidad);
			}
			panelArmas.add(radar, gbc_radar);
		}
		{
			final JComboBox escudo = new JComboBox();
			GridBagConstraints gbc_escudo = new GridBagConstraints();
			gbc_escudo.insets = new Insets(0, 0, 5, 5);
			gbc_escudo.fill = GridBagConstraints.BOTH;
			gbc_escudo.gridx = 3;
			gbc_escudo.gridy = 2;
			for (int i = 0; i <= maxNumArmasComprar; i++) {
				escudo.addItem(new Integer(i));
			}
			panelArmas.add(escudo, gbc_escudo);

			escudo.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					int state = (Integer) escudo.getSelectedItem();

					if (state == 1) {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(1);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 2) {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(2);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 3) {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(3);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 4) {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(4);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 5) {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(5);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else {
						precioTotal_ESCUDO = state * precioEscudo;
						setPrecioTotal_ESCUDO(precioTotal_ESCUDO);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantEscudos(0);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					}
				}
			});
		}
		{
			final JComboBox misil = new JComboBox();
			GridBagConstraints gbc_misil = new GridBagConstraints();
			gbc_misil.insets = new Insets(0, 0, 5, 5);
			gbc_misil.fill = GridBagConstraints.BOTH;
			gbc_misil.gridx = 4;
			gbc_misil.gridy = 2;

			for (int i = 0; i <= maxNumArmasComprar; i++) {
				misil.addItem(new Integer(i));
			}
			panelArmas.add(misil, gbc_misil);

			misil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int state = (Integer) misil.getSelectedItem();

					if (state == 1) {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(1);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 2) {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(2);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 3) {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(3);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 4) {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(4);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 5) {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(5);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else {
						precioTotal_MISIL = state * precioMisil;
						setPrecioTotal_MISIL(precioTotal_MISIL);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantMisiles(0);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					}
				}
			});
		}
		{
			final JComboBox bomba = new JComboBox();
			GridBagConstraints gbc_bomba = new GridBagConstraints();
			gbc_bomba.insets = new Insets(0, 0, 5, 5);
			gbc_bomba.fill = GridBagConstraints.BOTH;
			gbc_bomba.gridx = 5;
			gbc_bomba.gridy = 2;
			for (int i = 0; i <= maxNumArmasComprar; i++) {
				bomba.addItem(new Integer(i));
			}
			panelArmas.add(bomba, gbc_bomba);

			bomba.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					int state = (Integer) bomba.getSelectedItem();

					if (state == 1) {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(1);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 2) {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(2);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 3) {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(3);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 4) {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(4);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 5) {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(5);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else {
						precioTotal_BOMBA = state * precioBomba;
						setPrecioTotal_BOMBA(precioTotal_BOMBA);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA);
						setCantBombas(0);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					}
				}
			});
		}
		{
			final JComboBox reparacion = new JComboBox();
			reparacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int state = (Integer) reparacion.getSelectedItem();

					if (state == 1) {
						precioTotal_REPARACION = state * precioReparacion;
						setPrecioTotal_REPARACION(precioTotal_REPARACION);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA
								+ precioTotal_REPARACION);
						setCantReparacion(1);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 2) {
						precioTotal_REPARACION = state * precioReparacion;
						setPrecioTotal_REPARACION(precioTotal_REPARACION);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA
								+ precioTotal_REPARACION);
						setCantReparacion(2);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else if (state == 3) {
						precioTotal_REPARACION = state * precioReparacion;
						setPrecioTotal_REPARACION(precioTotal_REPARACION);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA
								+ precioTotal_REPARACION);
						setCantReparacion(3);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					} else {
						precioTotal_REPARACION = state * precioReparacion;
						setPrecioTotal_REPARACION(precioTotal_REPARACION);
						setPrecioTotal(precioTotal_ESCUDO + precioTotal_RADAR + precioTotal_MISIL + precioTotal_BOMBA
								+ precioTotal_REPARACION);
						setCantReparacion(0);
						lblDinero.setText("Precio total: " + getPrecioTotal());
						validate();
					}

				}
			});
			for (int i = 0; i <= 3; i++) {
				reparacion.addItem(new Integer(i));
			}
			GridBagConstraints gbc_reparacion = new GridBagConstraints();
			gbc_reparacion.insets = new Insets(0, 0, 5, 5);
			gbc_reparacion.fill = GridBagConstraints.HORIZONTAL;
			gbc_reparacion.gridx = 6;
			gbc_reparacion.gridy = 2;
			panelArmas.add(reparacion, gbc_reparacion);
		}
		{
			Component horizontalGlue = Box.createHorizontalGlue();
			GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
			gbc_horizontalGlue.fill = GridBagConstraints.VERTICAL;
			gbc_horizontalGlue.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalGlue.gridx = 8;
			gbc_horizontalGlue.gridy = 2;
			panelArmas.add(horizontalGlue, gbc_horizontalGlue);
		}
		{
			JPanel panelBotones = new JPanel();
			panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				panelBotones.add(horizontalGlue);
			}
			{
				GridBagConstraints gbc_lblDinero = new GridBagConstraints();
				gbc_lblDinero.insets = new Insets(0, 0, 0, 5);
				gbc_lblDinero.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblDinero.gridx = 7;
				gbc_lblDinero.gridy = 3;
				panelArmas.add(lblDinero, gbc_lblDinero);
			}
			{
				JButton botonComprar = new JButton("Comprar");
				botonComprar.setActionCommand("Comprar");
				panelBotones.add(botonComprar);
				getRootPane().setDefaultButton(botonComprar);
				botonComprar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (VentanaNombreDeUsuario.jugador.getDinero().getCantidad() < precioTotal) {
							JOptionPane.showMessageDialog(null, "No tienes suficiente dinero");
						} else {
							if (getCantBombas() == 0 && getCantRadares() == 0 && getCantMisiles() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								JOptionPane.showMessageDialog(null, "No has seleccionado ningun objeto para comprar");
							}
							//Comprar reparaciones aparte
							else if((getCantBombas() != 0 || getCantRadares() != 0 || getCantMisiles() != 0
									|| getCantEscudos() != 0) && getCantReparacion() != 0){
								
								JOptionPane.showMessageDialog(null, "Por favor, compra las reparaciones aparte", "Advertencia", 1);
							}
							// Bombas
							else if (getCantBombas() >= 1 && getCantRadares() == 0 && getCantMisiles() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- (getCantBombas() * precioBomba));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantBombas() + " bombas.");
								dispose();
							}
							// Reparaciones
							else if (getCantReparacion()>= 1 && getCantBombas() == 0 && getCantRadares() == 0 && getCantMisiles() == 0
									&& getCantEscudos() == 0) {
								for (int i = 0; i < getCantReparacion(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Reparacion());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- (getCantReparacion() * precioReparacion));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantReparacion() + " reparaciones para tus barcos.");
								dispose();
							}
							// Escudos
							else if (getCantEscudos() >= 1 && getCantRadares() == 0 && getCantMisiles() == 0
									&& getCantBombas() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- (getCantEscudos() * precioEscudo));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantEscudos() + " escudos.");
								dispose();
							}
							// Radares
							else if (getCantRadares() >= 1 && getCantBombas() == 0 && getCantMisiles() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- (getCantRadares() * precioRadar));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantRadares() + " radares.");
								dispose();
							}
							// Misiles
							else if (getCantMisiles() >= 1 && getCantRadares() == 0 && getCantBombas() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- (getCantMisiles() * precioMisil));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantMisiles() + " misiles.");
								dispose();
							}
							// Bombas y escudos
							else if (getCantBombas() >= 1 && getCantEscudos() >= 1 && getCantRadares() == 0
									&& getCantMisiles() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador
										.getDinero().getCantidad()
										- ((getCantBombas() * precioBomba) + (getCantEscudos() * precioEscudo)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantBombas() + " bombas y "
										+ getCantEscudos() + " escudos.");
								dispose();
							}
							// Bombas y radares
							else if (getCantBombas() >= 1 && getCantRadares() >= 1 && getCantMisiles() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantBombas() * precioBomba) + (getCantRadares() * precioRadar)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantBombas() + " bombas y "
										+ getCantRadares() + " radares.");
								dispose();
							}
							// Bombas y misiles
							else if (getCantBombas() >= 1 && getCantMisiles() >= 1 && getCantRadares() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantBombas() * precioBomba) + (getCantMisiles() * precioMisil)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantBombas() + " bombas y "
										+ getCantMisiles() + " misiles.");
								dispose();
							}
							// Radares y misiles
							else if (getCantRadares() >= 1 && getCantMisiles() >= 1 && getCantBombas() == 0
									&& getCantEscudos() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador
										.getDinero().getCantidad()
										- ((getCantRadares() * precioRadar) + (getCantMisiles() * precioMisil)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantRadares() + " radares y "
										+ getCantMisiles() + " misiles.");
								dispose();
							}
							// Radares y escudos
							else if (getCantRadares() >= 1 && getCantEscudos() >= 1 && getCantBombas() == 0
									&& getCantMisiles() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador
										.getDinero().getCantidad()
										- ((getCantRadares() * precioRadar) + (getCantEscudos() * precioEscudo)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantRadares() + " radares y "
										+ getCantEscudos() + " escudos.");
								dispose();
							}

							// Misiles y escudos
							else if (getCantMisiles() >= 1 && getCantEscudos() >= 1 && getCantBombas() == 0
									&& getCantRadares() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador
										.getDinero().getCantidad()
										- ((getCantMisiles() * precioMisil) + (getCantEscudos() * precioEscudo)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantMisiles() + " misiles y "
										+ getCantEscudos() + " escudos.");
								dispose();
							}
							// Misiles, escudos y bombas
							else if (getCantMisiles() >= 1 && getCantEscudos() >= 1 && getCantBombas() >= 1
									&& getCantRadares() == 0 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantBombas() * precioBomba) + (getCantEscudos() * precioEscudo)
														+ (getCantMisiles() * precioMisil)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantMisiles() + " misiles, "
										+ getCantEscudos() + " escudos y " + getCantBombas() + " bombas.");
								dispose();
							}
							// Misiles, escudos y radares
							else if (getCantMisiles() >= 1 && getCantEscudos() >= 1 && getCantBombas() == 0
									&& getCantRadares() >= 1 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantRadares() * precioRadar) + (getCantEscudos() * precioEscudo)
														+ (getCantMisiles() * precioMisil)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantMisiles() + " misiles, "
										+ getCantEscudos() + " escudos y " + getCantRadares() + " radares.");
								dispose();
							}
							// Bombas, radares y misiles
							else if (getCantMisiles() >= 1 && getCantEscudos() == 0 && getCantBombas() >= 1
									&& getCantRadares() >= 1 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantBombas() * precioBomba) + (getCantRadares() * precioRadar)
														+ (getCantMisiles() * precioMisil)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantMisiles() + " misiles, "
										+ getCantBombas() + " bombas y " + getCantRadares() + " radares.");
								dispose();
							}
							// Bombas, radares y escudos
							else if (getCantMisiles() == 0 && getCantEscudos() >= 1 && getCantBombas() >= 1
									&& getCantRadares() >= 1 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								VentanaNombreDeUsuario.jugador.getDinero()
										.setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()
												- ((getCantBombas() * precioBomba) + (getCantEscudos() * precioEscudo)
														+ (getCantRadares() * precioRadar)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null, "Has comprado " + getCantEscudos() + " escudos, "
										+ getCantBombas() + " bombas y " + getCantRadares() + " radares.");
								dispose();
							}
							// Todos los objetos (menos reparaciones)
							else if (getCantMisiles() >= 1 && getCantEscudos() >= 1 && getCantBombas() >= 1
									&& getCantRadares() >= 1 && getCantReparacion() == 0) {
								for (int i = 0; i < getCantEscudos(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Escudo());
								}
								for (int i = 0; i < getCantBombas(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Bomba());
								}
								for (int i = 0; i < getCantRadares(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Radar());
								}
								for (int i = 0; i < getCantMisiles(); i++) {
									VentanaNombreDeUsuario.jugador.getArmamento().add(new Misil());
								}
								VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador
										.getDinero().getCantidad()
										- ((getCantBombas() * precioBomba) + (getCantEscudos() * precioEscudo)
												+ (getCantMisiles() * precioMisil) + (getCantRadares() * precioRadar)));
								VentanaJuego.getLblDinero()
										.setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
								JOptionPane.showMessageDialog(null,
										"Has comprado " + getCantRadares() + " radares, " + getCantEscudos()
												+ " escudos, " + getCantMisiles() + " misiles y " + getCantBombas()
												+ " bombas.");
								dispose();
							}

							// Para comprobar que todas las armas se a�aden
							// correctamente a la lista de armas del jugador
							System.out.println(VentanaNombreDeUsuario.jugador.getArmamento().toString());
							setCantRadares(0);
							setCantBombas(0);
							setCantEscudos(0);
							setCantMisiles(0);
							setCantReparacion(0);
							VentanaJuego.getLblCantidad_1()
									.setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumMisiles());
							VentanaJuego.getLblCantidad_3()
									.setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumRadares());
							VentanaJuego.getLblCantidad_2()
									.setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumEscudos());
							VentanaJuego.getLblCantidad()
									.setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumBombas());
							VentanaJuego.getLblCantidad_4()
							.setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumReparaciones());

						}
					}
				});
			}
			{
				JButton botonCancelar = new JButton("Volver");
				botonCancelar.setActionCommand("Volver");
				panelBotones.add(botonCancelar);
				botonCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setCantRadares(0);
						setCantBombas(0);
						setCantEscudos(0);
						setCantMisiles(0);
						dispose();
					}
				});
			}
		}
	}

	public int getPrecioReparacion() {
		return precioReparacion;
	}

	public void setPrecioReparacion(int pPrecioReparacion) {
		precioReparacion = pPrecioReparacion;
	}

}
