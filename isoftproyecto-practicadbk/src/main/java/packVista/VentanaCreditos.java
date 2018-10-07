package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCreditos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8369194992833170444L;
	private final JPanelBackground panelCreditos = new JPanelBackground();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaCreditos dialog = new VentanaCreditos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaCreditos() {
		initialize();
	}

	private void initialize() {
		setTitle("Creditos");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		panelCreditos.setLayout(new FlowLayout());
		panelCreditos.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panelCreditos, BorderLayout.CENTER);
		panelCreditos.setBackground(VentanaCreditos.class.getResource("/resources/credits.png"));

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
			}
		}
	}

}
