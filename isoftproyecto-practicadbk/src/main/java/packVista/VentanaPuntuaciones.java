package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import packModelos.Clasificacion;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class VentanaPuntuaciones extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4867925894489793793L;
	private JTable table;
	private TableModel modeloDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPuntuaciones dialog = new VentanaPuntuaciones();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPuntuaciones() {
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Puntuaciones");
		// Centrar ventana
		centrarVentana();
		{
			JPanel panelBoton = new JPanel();
			panelBoton.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(panelBoton, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				panelBoton.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			getContentPane().add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable(getModeloDatos());
				table.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
				table.setFillsViewportHeight(true);
				scrollPane.setViewportView(table);
			}
		}
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

	private TableModel getModeloDatos() {
		if (modeloDatos == null) {
			modeloDatos = new Clasificacion();
		}
		return modeloDatos;
	}

}
