package packVista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import packModelos.tablero.FlotaOrdenador;
import javax.swing.JButton;
import packControladores.ColocarBarcosOrdenador;
import packModelos.Coordenadas;
import packModelos.barcos.TipoBarco;

public class ColocarBarcosIA implements ActionListener{

	private int y;
	private int x;
	private boolean orientacion;
	private static int numPortaavionesIA = 1;
	static ArrayList<JButton> botonesBarco = new ArrayList<JButton>();
	private static int numFragatasIA = 4;
	private static int numDestructoresIA = 3;
	private static int numSubmarinosIA = 2;
	static final Color agua = new Color(79, 171, 216);
	static final Color barco = new Color(96, 107, 119); //esto se va a borrar cuando hayamos comprobado que todo funciona!
	static final Color barcoOculto = Color.BLACK;
	static final Color barcoHundido = Color.RED;
	static final Color dado = Color.RED;
	static final Color tableroOculto = Color.BLACK;
	//static final Color escudoOculto = Color.BLACK;
	static final Color escudo = Color.WHITE;
	static final Color escudo2 = Color.WHITE; //para el jugador
	private static boolean colocarBarcosIA = false; //indica si el ordenador ha colocado sus barcos

	public void actionPerformed(ActionEvent e) {
		
		if(VentanaJuego.isColocarBarcosJugador()==true){
		//Portaavion
		while(numPortaavionesIA > 0){
			colocarPortaavion();
		}

		//Submarinos
		while(numSubmarinosIA > 0){
			colocarSubmarinos();

		}
		
		//Destructores
		while(numDestructoresIA > 0){
			 colocarDestructores();
		}
		
		//Fragatas
		while(numFragatasIA > 0){
			  colocarFragatas();
		}
		
		for (JButton obj : VentanaJuego.listaBotonesIA) {
			obj.removeActionListener(this);
		}
		setColocarBarcosIA(true); //La IA ha colocado sus barcos, se puede empezar a disparar
	    }
	}
	
	public static void cambiarFondoBarco(){
		for(JButton obj: botonesBarco){
		    obj.setBackground(barcoOculto);
		}
	}
	
	public static boolean isColocarBarcosIA() {
		return colocarBarcosIA;
	}

	public static void setColocarBarcosIA(boolean pColocarBarcosIA) {
		colocarBarcosIA = pColocarBarcosIA;
	}

	public void colocarFragatas(){
		    JButton b;
			boolean sePuede = true; //si no se pone uno encima del otro
			Random index = new Random();
			int i = index.nextInt(100);
			b = VentanaJuego.getListaCoordIA().get(i).getObjetoGuardado(); //Coge una casilla aleatoria del tablero
		    boolean pegados = comprobarBarcosPegadosIA(b, false, true, false);
		    
		    if(b.getBackground().equals(barco))
		    		sePuede = false;
		    if(!pegados && sePuede){
			b.setBackground(barco);
			botonesBarco.add(b);
			numFragatasIA--;
		    }
	}
	
	public void colocarPortaavion(){
		JButton boton;
		JButton b;
		ColocarBarcosOrdenador cb = new ColocarBarcosOrdenador((FlotaOrdenador) VentanaJuego.flotaIA);
		Random index = new Random();
		int i = index.nextInt(100);
		b = VentanaJuego.getListaCoordIA().get(i).getObjetoGuardado(); //Coge una casilla aleatoria del tablero
		Random orient = new Random();
		orientacion = orient.nextBoolean();
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		cb.setOrientacionActual(orientacion);
		
	    for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
			if (b.equals(objeto.getObjetoGuardado())) {
				x = objeto.getX();
				y = objeto.getY();
			}
		}
	  //  boolean sePuede = true; //si no se pone uno encima del otro
		boolean noSale = cb.comprobarPosicionBarco(x, y);
		boolean pegado = comprobarBarcosPegadosIA(b, orientacion, false, true);
		boolean superpuesto = barcoSuperpuesto(b);
		boolean superpuesto2 = false;
		boolean pegado2 = false;
		
	    	if(orientacion==true){
	    		 if(!superpuesto && noSale && !pegado){
	    			 b.setBackground(barco);
	    			 botonesBarco.add(b);
	    			 for (int k = y+1; k < y + 4; k++) {
							boton = getGridButton(x, k);
							if(comprobarBarcosPegadosIA(boton, true, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
	    			 if(!pegado2 && !superpuesto2){
	    			 for (int j = y+1; j < y + 4; j++) {
							boton = getGridButton(x, j);
							boton.setBackground(barco);
							botonesBarco.add(boton);
						}
	    			 numPortaavionesIA = numPortaavionesIA - 1;
	    			 }
	    			 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	}//FIN IF ORIENTACION
	    	else{
	    		if(!superpuesto && noSale && !pegado){
	    			b.setBackground(barco);
	    			botonesBarco.add(b);
	    			 for (int k = x+1; k < x + 4; k++) {
							boton = getGridButton(k, y);
							if(comprobarBarcosPegadosIA(boton, false, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
	    			 if(!pegado2 && !superpuesto2){
		    			 for (int j = x+1; j < x + 4; j++) {
								boton = getGridButton(j, y);
								boton.setBackground(barco);
								botonesBarco.add(boton);
							}
		    			 numPortaavionesIA = numPortaavionesIA - 1;
		    			 }
	    			 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	} 
	}
	
	public void colocarSubmarinos(){
		JButton boton;
		JButton b;
		ColocarBarcosOrdenador cb = new ColocarBarcosOrdenador((FlotaOrdenador) VentanaJuego.flotaIA);
		Random index = new Random();
		int i = index.nextInt(100);
		b = VentanaJuego.getListaCoordIA().get(i).getObjetoGuardado(); //Coge una casilla aleatoria del tablero
		Random orient = new Random();
		orientacion = orient.nextBoolean();
		cb.setTipoBarco(TipoBarco.SUBMARINO);
		cb.setOrientacionActual(orientacion);
		
	    for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
			if (b.equals(objeto.getObjetoGuardado())) {
				x = objeto.getX();
				y = objeto.getY();
			}
		}
	  //  boolean sePuede = true; //si no se pone uno encima del otro
		boolean noSale = cb.comprobarPosicionBarco(x, y);
		boolean pegado = comprobarBarcosPegadosIA(b, orientacion, false, true);
		boolean superpuesto = barcoSuperpuesto(b);
		boolean superpuesto2 = false;
		boolean pegado2 = false;
	    
	    	if(orientacion==true){
	    		 if(!superpuesto && noSale && !pegado){
	    			 b.setBackground(barco);
	    			 botonesBarco.add(b);
	    			 for (int k = y+1; k < y + 3; k++) {
							boton = getGridButton(x, k);
							if(comprobarBarcosPegadosIA(boton, true, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
	    			 if(!pegado2 && !superpuesto2){
	    			 for (int j = y+1; j < y + 3; j++) {
							boton = getGridButton(x, j);
							boton.setBackground(barco);
							botonesBarco.add(boton);
						}
	    			 numSubmarinosIA = numSubmarinosIA - 1;
	    			 }
	    			 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	}//FIN IF ORIENTACION
	    	else{
	    		if(!superpuesto && noSale && !pegado){
	    			b.setBackground(barco);
	    			botonesBarco.add(b);
	    			 for (int k = x+1; k < x + 3; k++) {
							boton = getGridButton(k, y);
							if(comprobarBarcosPegadosIA(boton, false, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
					if(!pegado2 && !superpuesto2){
		    			 for (int j = x+1; j < x + 3; j++) {
								boton = getGridButton(j, y);
								boton.setBackground(barco);
								botonesBarco.add(boton);
							}
		    			 numSubmarinosIA = numSubmarinosIA - 1;
		    			 }
					 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	} 
	}
	
	public void colocarDestructores(){
		JButton boton;
		JButton b;
		ColocarBarcosOrdenador cb = new ColocarBarcosOrdenador((FlotaOrdenador) VentanaJuego.flotaIA);
		Random index = new Random();
		int i = index.nextInt(100);
		b = VentanaJuego.getListaCoordIA().get(i).getObjetoGuardado(); //Coge una casilla aleatoria del tablero
		Random orient = new Random();
		orientacion = orient.nextBoolean();
		cb.setTipoBarco(TipoBarco.DESTRUCTOR);
		cb.setOrientacionActual(orientacion);
		
	    for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
			if (b.equals(objeto.getObjetoGuardado())) {
				x = objeto.getX();
				y = objeto.getY();
			}
		}
	  //  boolean sePuede = true; //si no se pone uno encima del otro
		boolean noSale = cb.comprobarPosicionBarco(x, y);
		boolean pegado = comprobarBarcosPegadosIA(b, orientacion, false, true);
		boolean superpuesto = barcoSuperpuesto(b);
		boolean superpuesto2 = false;
		boolean pegado2 = false;
	    
	    	if(orientacion==true){
	    		 if(!superpuesto && noSale && !pegado){
	    			 b.setBackground(barco);
	    			 botonesBarco.add(b);
	    			 for (int k = y+1; k < y + 2; k++) {
							boton = getGridButton(x, k);
							if(comprobarBarcosPegadosIA(boton, true, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
	    			 if(!pegado2 && !superpuesto2){
	    			 for (int j = y+1; j < y + 2; j++) {
							boton = getGridButton(x, j);
							boton.setBackground(barco);
							botonesBarco.add(boton);
						}
	    			 numDestructoresIA = numDestructoresIA - 1;
	    			 }
	    			 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	}//FIN IF ORIENTACION
	    	else{
	    		if(!superpuesto && noSale && !pegado){
	    			b.setBackground(barco);
	    			botonesBarco.add(b);
	    			 for (int k = x+1; k < x + 2; k++) {
							boton = getGridButton(k, y);
							if(comprobarBarcosPegadosIA(boton, false, false, false))
								pegado2 = true;
							if(barcoSuperpuesto(boton))
							    superpuesto2 = true;
	    			 }//FIN FOR
					if(!pegado2 && !superpuesto2){
		    			 for (int j = x+1; j < x + 2; j++) {
								boton = getGridButton(j, y);
								boton.setBackground(barco);
								botonesBarco.add(boton);
							}
		    			 numDestructoresIA = numDestructoresIA - 1;
		    			 } 
					 else {
	    				 b.setBackground(tableroOculto);
	    				 botonesBarco.remove(b);
	    			     superpuesto2 = false;
	    			     pegado2 = false;
	    			 }
	    		 }//FIN IF SEPUEDE
	    	} 
	}
	
	public boolean barcoSuperpuesto(JButton pBoton){
		boolean superpuesto = false;
		
		if(pBoton.getBackground().equals(barco))
    		superpuesto = true;
		
		return superpuesto;	
	}
	
	public static boolean esCasillaBarco(JButton b){
		boolean esCasillaBarco = false;
		
		for(JButton obj: botonesBarco){
			if(obj.equals(b))
				esCasillaBarco=true;
		}
		return esCasillaBarco;
	}
	
	public boolean comprobarBarcosPegadosIA(JButton b, boolean pOrientacion, boolean esFragata, boolean primeraCasilla) {
		int xLado = 0;
		int yLado = 0;
		int xLado2 = 0;
		int yLado2 = 0;
		boolean pegado = false;

		if (pOrientacion == true && primeraCasilla == true) { // HORIZONTAL

			for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
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
			for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
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
			for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
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
			for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
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
			for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
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

		return VentanaJuego.listaBotonesIA.get(index);
	}
	
	public static int getNumPortaavionesIA() {
		return numPortaavionesIA;
	}

	public static void setNumPortaavionesIA(int pNumPortaavionesIA) {
		numPortaavionesIA = pNumPortaavionesIA;
	}

	public static int getNumFragatasIA() {
		return numFragatasIA;
	}

	public static void setNumFragatasIA(int pNumFragatasIA) {
		numFragatasIA = pNumFragatasIA;
	}

	public static int getNumDestructoresIA() {
		return numDestructoresIA;
	}

	public static void setNumDestructoresIA(int pNumDestructoresIA) {
		numDestructoresIA = pNumDestructoresIA;
	}

	public static int getNumSubmarinosIA() {
		return numSubmarinosIA;
	}

	public static void setNumSubmarinosIA(int pNumSubmarinosIA) {
		numSubmarinosIA = pNumSubmarinosIA;
	}
}
