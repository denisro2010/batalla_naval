package packVista;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class VentanaAyuda3 extends JDialog {
	private JPanel panelBotones;
	private JButton btnAceptar;
	private JButton btnVolver;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanelBackground panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAyuda3 dialog = new VentanaAyuda3();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public VentanaAyuda3() {

		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().add(getPanelBotones(), BorderLayout.SOUTH);
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
		getContentPane().add(getPanel(), BorderLayout.CENTER);
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.add(getBtnAceptar());
			panelBotones.add(getBtnVolver());
		}
		return panelBotones;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			panelBotones.add(btnAceptar);
			buttonGroup.add(btnAceptar);
		}
		return btnAceptar;
	}

	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("< Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaAyuda2 v = new VentanaAyuda2();
					v.setVisible(true);
					dispose();
				}
			});
			panelBotones.add(btnVolver);
			buttonGroup.add(btnVolver);
		}
		return btnVolver;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanelBackground();
			panel.setBackground(VentanaAyuda.class.getResource("/resources/ventana3.png"));
		}
		return panel;
	}
}
