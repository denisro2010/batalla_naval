package packVista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;

public class VentanaJuego extends JFrame {

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
	private final ButtonGroup botonArmamento = new ButtonGroup();
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private Component horizontalGlue_2;

	private static final int NumeroCasillas = 10;
	private final List<JButton> list = new ArrayList<JButton>();
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JPanel panelCentro;
	private JPanel panelTipoBarco;
	private JButton botonPortavion;
	private JButton botonFragata;
	private JButton botonDestructor;
	private JButton botonSubmarino;

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
		initialize();
	}

	private void initialize() {
		setBackground(new Color(176, 224, 230));
		setTitle("Practica DBK: Battleship");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 600, 800, 600);
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
			for (int i = 0; i < 100; i++) {
				int fila = i / NumeroCasillas;
				int col = i % NumeroCasillas;
				JButton boton = new JButton();
				list.add(boton);
				boton.setToolTipText(fila + " , " + col);
				boton.setBackground(Color.BLUE);
				boton.setForeground(Color.cyan);
				boton.setOpaque(true);
				panelTiro.add(boton);

			}
		}
		return panelTiro;
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
			for (int i = 0; i < 100; i++) {
				int fila = i / NumeroCasillas;
				int col = i % NumeroCasillas;
				JButton boton = new JButton();
				boton.setToolTipText(fila + " , " + col);
				boton.setBackground(Color.BLUE);
				boton.setForeground(Color.cyan);
				boton.setOpaque(true);
				list.add(boton);
				panelBarcos.add(boton);

			}
		}
		return panelBarcos;
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
			panelArmamento.add(getHorizontalGlue());
			panelArmamento.add(getBotonBomba());
			panelArmamento.add(getBotonMisil());
			panelArmamento.add(getBotonEscudo());
			panelArmamento.add(getBotonRadar());
			panelArmamento.add(getBotonTienda());
			panelArmamento.add(getHorizontalGlue_1());
		}
		return panelArmamento;
	}

	private JButton getBotonBomba() {
		if (botonBomba == null) {
			botonBomba = new JButton("Bomba");
			botonArmamento.add(botonBomba);
			botonBomba.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
		}
		return botonBomba;
	}

	private JButton getBotonMisil() {
		if (botonMisil == null) {
			botonMisil = new JButton("Misil");
			botonArmamento.add(botonMisil);
		}
		return botonMisil;
	}

	private JButton getBotonEscudo() {
		if (botonEscudo == null) {
			botonEscudo = new JButton("Escudo");
			botonArmamento.add(botonEscudo);
		}
		return botonEscudo;
	}

	private JButton getBotonRadar() {
		if (botonRadar == null) {
			botonRadar = new JButton("Radar");
			botonArmamento.add(botonRadar);
		}
		return botonRadar;
	}

	private JButton getBotonTienda() {
		if (botonTienda == null) {
			botonTienda = new JButton("Tienda");
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
		}
		return rdbtnNewRadioButton;
	}

	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("Barco vertical");
			botonesOrientacion.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(0, 2, 1, 1));
			panelCentro.add(getPanelTiro());
			panelCentro.add(getPanelBarcos());

		}
		return panelCentro;

	}

	private JButton getGridButton(int r, int c) {
		int index = r * NumeroCasillas + c;
		return list.get(index);
	}

	private JPanel getPanelTipoBarco() {
		if (panelTipoBarco == null) {
			panelTipoBarco = new JPanel();
			panelTipoBarco.setLayout(new GridLayout(4, 1, 4, 0));
			panelTipoBarco.add(getBotonPortavion());
			panelTipoBarco.add(getBotonFragata());
			panelTipoBarco.add(getBotonDestructor());
			panelTipoBarco.add(getBotonSubmarino());
		}
		return panelTipoBarco;
	}

	private JButton getBotonPortavion() {
		if (botonPortavion == null) {
			botonPortavion = new JButton("Portaavion");
			botonPortavion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return botonPortavion;
	}

	private JButton getBotonFragata() {
		if (botonFragata == null) {
			botonFragata = new JButton("Fragata");
		}
		return botonFragata;
	}

	private JButton getBotonDestructor() {
		if (botonDestructor == null) {
			botonDestructor = new JButton("Destructor");
		}
		return botonDestructor;
	}

	private JButton getBotonSubmarino() {
		if (botonSubmarino == null) {
			botonSubmarino = new JButton("Submarino");
		}
		return botonSubmarino;
	}
}
