package packVista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class VentanaTienda extends JDialog {

	private final JPanel panelArmas = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaTienda dialog = new VentanaTienda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaTienda() {
		initialize();
	}

	private void initialize() {
		setTitle("Tienda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelArmas.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelArmas, BorderLayout.CENTER);
		GridBagLayout gbl_panelArmas = new GridBagLayout();
		gbl_panelArmas.columnWidths = new int[] { 79, 89, 75, 105, 74, 0 };
		gbl_panelArmas.rowHeights = new int[] { 101, 29, 0, 0 };
		gbl_panelArmas.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelArmas.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelArmas.setLayout(gbl_panelArmas);
		{
			JLabel lblPrecioRadar = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecioRadar = new GridBagConstraints();
			gbc_lblPrecioRadar.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioRadar.gridx = 0;
			gbc_lblPrecioRadar.gridy = 0;
			panelArmas.add(lblPrecioRadar, gbc_lblPrecioRadar);
		}
		{
			JLabel lblNewLabel = new JLabel("Precio:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 0;
			panelArmas.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblPrecioMisil = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecioMisil = new GridBagConstraints();
			gbc_lblPrecioMisil.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecioMisil.gridx = 2;
			gbc_lblPrecioMisil.gridy = 0;
			panelArmas.add(lblPrecioMisil, gbc_lblPrecioMisil);
		}
		{
			JLabel lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 3;
			gbc_lblPrecio.gridy = 0;
			panelArmas.add(lblPrecio, gbc_lblPrecio);
		}
		{
			JButton botonRadar = new JButton("Radar");
			GridBagConstraints gbc_botonRadar = new GridBagConstraints();
			gbc_botonRadar.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonRadar.insets = new Insets(0, 0, 5, 5);
			gbc_botonRadar.gridx = 0;
			gbc_botonRadar.gridy = 1;
			panelArmas.add(botonRadar, gbc_botonRadar);
		}
		{
			JButton botonEscudo = new JButton("Escudo");
			GridBagConstraints gbc_botonEscudo = new GridBagConstraints();
			gbc_botonEscudo.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonEscudo.insets = new Insets(0, 0, 5, 5);
			gbc_botonEscudo.gridx = 1;
			gbc_botonEscudo.gridy = 1;
			panelArmas.add(botonEscudo, gbc_botonEscudo);
		}
		{
			JButton botonMisil = new JButton("Misil");
			GridBagConstraints gbc_botonMisil = new GridBagConstraints();
			gbc_botonMisil.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonMisil.insets = new Insets(0, 0, 5, 5);
			gbc_botonMisil.gridx = 2;
			gbc_botonMisil.gridy = 1;
			panelArmas.add(botonMisil, gbc_botonMisil);
		}
		{
			JButton botonBomba = new JButton("Bomba");
			GridBagConstraints gbc_botonBomba = new GridBagConstraints();
			gbc_botonBomba.fill = GridBagConstraints.HORIZONTAL;
			gbc_botonBomba.insets = new Insets(0, 0, 5, 5);
			gbc_botonBomba.gridx = 3;
			gbc_botonBomba.gridy = 1;
			panelArmas.add(botonBomba, gbc_botonBomba);
		}
		{
			JLabel lblDinero = new JLabel("Dinero:");
			GridBagConstraints gbc_lblDinero = new GridBagConstraints();
			gbc_lblDinero.insets = new Insets(0, 0, 5, 0);
			gbc_lblDinero.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblDinero.gridx = 4;
			gbc_lblDinero.gridy = 1;
			panelArmas.add(lblDinero, gbc_lblDinero);
		}
		{
			JPanel panelBotones = new JPanel();
			panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			{
				JButton botonComprar = new JButton("Comprar");
				botonComprar.setActionCommand("Comprar");
				panelBotones.add(botonComprar);
				getRootPane().setDefaultButton(botonComprar);
			}
			{
				JButton botonCancelar = new JButton("Cancelar");
				botonCancelar.setActionCommand("Cancelar");
				panelBotones.add(botonCancelar);
			}
		}
	}

}
