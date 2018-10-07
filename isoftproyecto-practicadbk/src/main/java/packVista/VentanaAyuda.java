package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAyuda extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4669623672008095200L;
	private JPanelBackground panelInformacion;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaAyuda dialog = new VentanaAyuda();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAyuda() {
		initialize();
	}

	private void initialize() {
		setTitle("Ayuda");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());

		// Centrar ventana
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = this.getSize();
		if (windowSize.height > screenSize.height) {
			windowSize.height = screenSize.height;
		}
		if (windowSize.width > screenSize.width) {
			windowSize.width = screenSize.width;
		}
		setLocation((screenSize.width - windowSize.width) / 2, (screenSize.height - windowSize.height) / 2);

		{
			JPanel panelBoton = new JPanel();
			panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(panelBoton, BorderLayout.SOUTH);
			{
				JButton botonAceptar = new JButton("Aceptar");
				botonAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				botonAceptar.setActionCommand("OK");
				panelBoton.add(botonAceptar);
				getRootPane().setDefaultButton(botonAceptar);
				buttonGroup.add(botonAceptar);
			}
			{
				JButton btnSiguiente = new JButton("Siguiente >");
				btnSiguiente.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaAyuda2 va2 = new VentanaAyuda2();
						va2.setVisible(true);
						dispose();
					}
				});
				panelBoton.add(btnSiguiente);
				buttonGroup.add(btnSiguiente);
			}
		}
		getContentPane().add(getPanelInformacion(), BorderLayout.CENTER);
	}

	private JPanel getPanelInformacion() {
		if (panelInformacion == null) {
			panelInformacion = new JPanelBackground();
			panelInformacion.setLayout(new BorderLayout(0, 0));
			panelInformacion.setBackground(VentanaAyuda.class.getResource("/resources/ventana.png"));
		}
		return panelInformacion;
	}
}
