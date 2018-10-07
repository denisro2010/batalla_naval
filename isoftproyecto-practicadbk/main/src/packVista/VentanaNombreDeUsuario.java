package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;

import packModelos.jugador.Humano;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaNombreDeUsuario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5735550625691210170L;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaNombreDeUsuario dialog = new VentanaNombreDeUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaNombreDeUsuario() {
		initialize();
	}

	private void initialize() {
		setSize(new Dimension(600, 276));
		setTitle("Usuario");
		setResizable(false);
		// setBounds(100, 100, 486, 279);
		getContentPane().setLayout(new BorderLayout());

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
		{
			JPanel panelDatos = new JPanel();
			panelDatos.setBorder(
					new TitledBorder(null, "Nombre del usuario", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			getContentPane().add(panelDatos, BorderLayout.NORTH);
			GridBagLayout gbl_panelDatos = new GridBagLayout();
			gbl_panelDatos.columnWidths = new int[] { 101, 50, 0, 116, 56, 0 };
			gbl_panelDatos.rowHeights = new int[] { 22, 0, 0, 0, 0, 0 };
			gbl_panelDatos.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panelDatos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panelDatos.setLayout(gbl_panelDatos);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 1;
				gbc_lblNombre.gridy = 3;
				panelDatos.add(lblNombre, gbc_lblNombre);
			}
			{
				txtNombre = new JTextField();
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 3;
				gbc_txtNombre.gridy = 3;
				panelDatos.add(txtNombre, gbc_txtNombre);
				txtNombre.setColumns(10);
			}
		}
		{
			JPanel panelBotones = new JPanel();
			getContentPane().add(panelBotones, BorderLayout.SOUTH);
			{
				JButton btnAceptar = new JButton("Aceptar");
				panelBotones.add(btnAceptar);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (gettxtNombre().getText().equals("")) {
							JOptionPane.showMessageDialog(null, "El nombre no puede estar vac�o");
						} else {
							VentanaJuego vj = new VentanaJuego();
							vj.setVisible(true);
							dispose();
						}
					}
				});
			}

			{
				JButton btnBorrar = new JButton("Borrar");
				btnBorrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						gettxtNombre().setText("");
						gettxtNombre().requestFocus();
					}

					private JTextField gettxtNombre() {
						// TODO Auto-generated method stub
						return txtNombre;
					}
				});
				panelBotones.add(btnBorrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
				panelBotones.add(btnCancelar);
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VentanaPrincipal v = new VentanaPrincipal();
						v.setVisible(true);
						dispose();
					}
				});
			}

		}
	}

	public JTextField gettxtNombre() {
		return txtNombre;
	}

}
