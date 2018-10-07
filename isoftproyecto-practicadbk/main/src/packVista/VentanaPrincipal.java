package packVista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 102673009839160787L;
	private JPanel panelBotones;
	private JButton btnJugar;
	private JButton btnAyuda;
	private JButton btnPuntuaciones;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnCreditos;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component verticalGlue_1;
	private Component verticalStrut;

	/**
	 * Iniciar la aplicacion.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crear la ventana.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/resources/radar.png")));
		setTitle("Practica DBK: Battleship");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 343);
		panelBotones = new JPanel();
		panelBotones.setBackground(new Color(176, 224, 230));
		panelBotones.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		panelBotones.setForeground(new Color(0, 0, 0));
		setContentPane(panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[] { 223, 152, 205, 0 };
		gbl_panelBotones.rowHeights = new int[] { 120, 29, 29, 0, 29, 29, 63, 0 };
		gbl_panelBotones.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelBotones.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelBotones.setLayout(gbl_panelBotones);
		centrarVentana();
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 0;
		panelBotones.add(getVerticalStrut(), gbc_verticalStrut);
		GridBagConstraints gbc_btnJugar = new GridBagConstraints();
		gbc_btnJugar.fill = GridBagConstraints.BOTH;
		gbc_btnJugar.insets = new Insets(0, 0, 5, 5);
		gbc_btnJugar.gridx = 1;
		gbc_btnJugar.gridy = 1;
		panelBotones.add(getBtnJugar(), gbc_btnJugar);
		GridBagConstraints gbc_btnPuntuaciones = new GridBagConstraints();
		gbc_btnPuntuaciones.fill = GridBagConstraints.BOTH;
		gbc_btnPuntuaciones.insets = new Insets(0, 0, 5, 5);
		gbc_btnPuntuaciones.gridx = 1;
		gbc_btnPuntuaciones.gridy = 2;
		panelBotones.add(getBtnPuntuaciones(), gbc_btnPuntuaciones);
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue.gridx = 0;
		gbc_horizontalGlue.gridy = 3;
		panelBotones.add(getHorizontalGlue_1(), gbc_horizontalGlue);
		GridBagConstraints gbc_btnAyuda = new GridBagConstraints();
		gbc_btnAyuda.fill = GridBagConstraints.BOTH;
		gbc_btnAyuda.insets = new Insets(0, 0, 5, 5);
		gbc_btnAyuda.gridx = 1;
		gbc_btnAyuda.gridy = 3;
		panelBotones.add(getBtnAyuda(), gbc_btnAyuda);
		GridBagConstraints gbc_horizontalGlue_1 = new GridBagConstraints();
		gbc_horizontalGlue_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_horizontalGlue_1.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalGlue_1.gridx = 2;
		gbc_horizontalGlue_1.gridy = 3;
		panelBotones.add(getHorizontalGlue_1_1(), gbc_horizontalGlue_1);
		GridBagConstraints gbc_btnCreditos = new GridBagConstraints();
		gbc_btnCreditos.fill = GridBagConstraints.BOTH;
		gbc_btnCreditos.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreditos.gridx = 1;
		gbc_btnCreditos.gridy = 4;
		panelBotones.add(getBtnCreditos(), gbc_btnCreditos);
		GridBagConstraints gbc_verticalGlue_1 = new GridBagConstraints();
		gbc_verticalGlue_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_verticalGlue_1.insets = new Insets(0, 0, 0, 5);
		gbc_verticalGlue_1.gridx = 1;
		gbc_verticalGlue_1.gridy = 6;
		panelBotones.add(getVerticalGlue_1_1(), gbc_verticalGlue_1);
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

	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.setHorizontalTextPosition(SwingConstants.CENTER);
			buttonGroup.add(btnJugar);
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaNombreDeUsuario v = new VentanaNombreDeUsuario();
					v.setVisible(true);
					dispose();
				}
			});
		}
		return btnJugar;
	}

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
			btnAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaAyuda vA = new VentanaAyuda();
					vA.setVisible(true);
				}
			});
			buttonGroup.add(btnAyuda);
		}
		return btnAyuda;
	}

	private JButton getBtnPuntuaciones() {
		if (btnPuntuaciones == null) {
			btnPuntuaciones = new JButton("Puntuaciones");
			btnPuntuaciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaPuntuaciones vP = new VentanaPuntuaciones();
					vP.setVisible(true);
				}
			});
			buttonGroup.add(btnPuntuaciones);
		}
		return btnPuntuaciones;
	}

	private JButton getBtnCreditos() {
		if (btnCreditos == null) {
			btnCreditos = new JButton("Creditos");
			btnCreditos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					VentanaCreditos vC = new VentanaCreditos();
					vC.setVisible(true);
				}
			});
			buttonGroup.add(btnCreditos);
		}
		return btnCreditos;
	}

	private Component getHorizontalGlue_1() {
		if (horizontalGlue == null) {
			horizontalGlue = Box.createHorizontalGlue();
		}
		return horizontalGlue;
	}

	private Component getHorizontalGlue_1_1() {
		if (horizontalGlue_1 == null) {
			horizontalGlue_1 = Box.createHorizontalGlue();
		}
		return horizontalGlue_1;
	}

	private Component getVerticalGlue_1_1() {
		if (verticalGlue_1 == null) {
			verticalGlue_1 = Box.createVerticalGlue();
		}
		return verticalGlue_1;
	}

	private Component getVerticalStrut() {
		if (verticalStrut == null) {
			verticalStrut = Box.createVerticalStrut(20);
		}
		return verticalStrut;
	}
}
