package packVista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packBatallaNaval.BatallaNaval;
import packModelos.Clasificacion;
import packModelos.Coordenadas;
import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Bomba;
import packModelos.tiendaYarmamento.Misil;
import packModelos.tiendaYarmamento.Radar;


public class TiroJugador implements ActionListener{
	static boolean turnoJugador = false;
	static ArrayList<JButton> barcosGolpeadosIA = new ArrayList<JButton>();
	private static int puntuacion = 0;

	public boolean isTurnoJugador() {
		return turnoJugador;
	}

	public static void setTurnoJugador(boolean pTurnoJugador) {
		turnoJugador = pTurnoJugador;
	}

	public void actionPerformed(ActionEvent pE) {
		JButton b;
		
		//Por si el usuario se queda sin dinero
		if((VentanaNombreDeUsuario.jugador.getDinero().getCantidad() < 100) && VentanaNombreDeUsuario.jugador.getNumBombas() == 0){
			VentanaNombreDeUsuario.jugador.getDinero().setCantidad(100);
		JOptionPane.showMessageDialog(null, "¡Te has quedado sin dinero! Te hemos ingresado 100 monedas para que puedas seguir jugando.",
				"Advertencia", 0);
		VentanaJuego.getLblDinero().setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
		}
		
		if(VentanaJuego.isColocarBarcosJugador() == true && ColocarBarcosIA.isColocarBarcosIA() == true){ //Solo si los barcos se han colocado
			if(isTurnoJugador() == true){
				
			if(VentanaJuego.isUsarBomba() == true){ //Si disparas con bomba
			    b = (JButton) pE.getSource();
			    boolean posNoValida = false;
			    if(b.getBackground().equals(ColocarBarcosIA.barcoOculto) && ColocarBarcosIA.esCasillaBarco(b)){
			    	b.setBackground(ColocarBarcosIA.dado);
			    	setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
                    TiroOrdenador.disparoIA();
			    	barcosGolpeadosIA.add(b);
			    	VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+200);
			    	setPuntuacion(getPuntuacion() + 1);
			    	VentanaJuego.getLblPuntos().setText("Puntos: " + TiroJugador.getPuntuacion());
			    }
			    else if(b.getBackground().equals(ColocarBarcosIA.tableroOculto) && !ColocarBarcosIA.esCasillaBarco(b)){
			    	b.setBackground(ColocarBarcosIA.agua);
			    	setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
			    	TiroOrdenador.disparoIA();
			    	VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+100);
			    }
			    /*else if(b.getBackground().equals(ColocarBarcosIA.escudoOculto)){ //FALTA POR HACER UNA LISTA DE ESCUDOS!!!
			    	b.setBackground(ColocarBarcosIA.escudo);
			    	setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
			    	TiroOrdenador.disparoIA();
			    	VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+200);
			    }*/
			    else if(b.getBackground().equals(ColocarBarcosIA.escudo)){ //Si ya ha golpeado en el escudo una vez
			    	b.setBackground(ColocarBarcosIA.dado);
			    	setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
			    	TiroOrdenador.disparoIA();
			    	barcosGolpeadosIA.add(b);
			    	VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+200);
			    	setPuntuacion(getPuntuacion() + 1);
			    	VentanaJuego.getLblPuntos().setText("Puntos: " + TiroJugador.getPuntuacion());
			    }
			    else if(b.getBackground().equals(ColocarBarcosIA.barco)){
			    	b.setBackground(ColocarBarcosIA.dado);
			    	setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
			    	TiroOrdenador.disparoIA();
			    	barcosGolpeadosIA.add(b);
			    	VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+200);
			    	setPuntuacion(getPuntuacion() + 1);
			    	VentanaJuego.getLblPuntos().setText("Puntos: " + TiroJugador.getPuntuacion());
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "La posicion que has elegido para disparar no es valida.",
							"Advertencia", 0);
			    	posNoValida = true;
			    }
			    if(posNoValida==false){
			    //DECREMENTAR ARMA
			    LinkedList<Armamento> a = new LinkedList<Armamento>();
			    int cont = 0;
			    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
			    	if(obj instanceof Bomba && cont == 0)
			    		cont = 1;
			    	else
			    		a.add(obj);
			    }
			    VentanaJuego.getLblDinero().setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
			    VentanaNombreDeUsuario.jugador.setArmamento(a);
			    VentanaJuego.getLblCantidad().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumBombas());
			    if(VentanaNombreDeUsuario.jugador.getNumBombas() == 0)
			    	VentanaJuego.setUsarBomba(false);
			    }
			    posNoValida=false;
			}
			
			if(VentanaJuego.isUsarRadar() == true){ //Si usas radar
				int x = 0;
				int y = 0;
				b = (JButton) pE.getSource();
				boolean esBarco = false;
				
				for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
					if (b.equals(objeto.getObjetoGuardado())) {
						x = objeto.getX();
						y = objeto.getY();
					}
			    }
				
				if(!ColocarBarcosIA.esCasillaBarco(b))
					 b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else
					b.setBackground(ColocarBarcosIA.barco);
				
				for(int i = x; i < x+2; i++){
					    if(i >= 0 && i < 10)
						b = ColocarBarcosIA.getGridButton(i, y);
						if(ColocarBarcosIA.esCasillaBarco(b))
							esBarco=true;
					    
						if(!esBarco)
						   b.setBackground(ColocarBarcosIA.agua);
						else if(b.getBackground().equals(Color.RED))
						{}
						else{
						   b.setBackground(ColocarBarcosIA.barco);
						   esBarco = false;
						}		
				}
					    
				for(int j = y; j < y+2; j++){
				    if(j >= 0 && j < 10)
				    	b = ColocarBarcosIA.getGridButton(x, j);
					if(ColocarBarcosIA.esCasillaBarco(b))
						esBarco=true;
				    
					if(!esBarco)
					   b.setBackground(ColocarBarcosIA.agua);
					else if(b.getBackground().equals(Color.RED))
					{}
					else{
					   b.setBackground(ColocarBarcosIA.barco);
					   esBarco = false;
					}	
			    }
				
				for(int i = x-1; i < x; i++){
					if(i >= 0 && i < 10)
				    	b = ColocarBarcosIA.getGridButton(i, y);
					if(ColocarBarcosIA.esCasillaBarco(b))
						esBarco=true;
				    
					if(!esBarco)
					   b.setBackground(ColocarBarcosIA.agua);
					else if(b.getBackground().equals(Color.RED))
					{}
					else{
					   b.setBackground(ColocarBarcosIA.barco);
					   esBarco = false;
					}	
			    }
				
			for(int j = y-1; j < y; j++){
				if(j >= 0 && j < 10)
			    	b = ColocarBarcosIA.getGridButton(x, j);
				if(ColocarBarcosIA.esCasillaBarco(b))
					esBarco=true;
			    
				if(!esBarco)
				   b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else{
				   b.setBackground(ColocarBarcosIA.barco);
				   esBarco = false;
				}	
		    }
			
				if(x+1 >= 0 && y+1 < 10 && y+1 >= 0 && x+1 < 10)
			    	b = ColocarBarcosIA.getGridButton(x+1, y+1);
				if(ColocarBarcosIA.esCasillaBarco(b))
					esBarco=true;
				if(!esBarco)
				   b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else{
				   b.setBackground(ColocarBarcosIA.barco);
				   esBarco = false;
				}	
				
				if(x-1 >= 0 && y-1 < 10 && y-1 >= 0 && x-1 < 10)
			    	b = ColocarBarcosIA.getGridButton(x-1, y-1);
				if(ColocarBarcosIA.esCasillaBarco(b))
					esBarco=true;
				if(!esBarco)
				   b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else{
				   b.setBackground(ColocarBarcosIA.barco);
				   esBarco = false;
				}	
				
				if(x+1 >= 0 && y-1 < 10 && y+1 >= 0 && x+1 < 10)
			    	b = ColocarBarcosIA.getGridButton(x+1, y-1);
				if(ColocarBarcosIA.esCasillaBarco(b))
					esBarco=true;
				if(!esBarco)
				   b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else{
				   b.setBackground(ColocarBarcosIA.barco);
				   esBarco = false;
				}	
				
				if(x-1 >= 0 && y+1 < 10 && y+1 >= 0 && x-1 < 10)
			    	b = ColocarBarcosIA.getGridButton(x-1, y+1);
				if(ColocarBarcosIA.esCasillaBarco(b))
					esBarco=true;
				if(!esBarco)
				   b.setBackground(ColocarBarcosIA.agua);
				else if(b.getBackground().equals(Color.RED))
				{}
				else{
				   b.setBackground(ColocarBarcosIA.barco);
				   esBarco = false;
				}
		    	
				setTurnoJugador(true);
		    	TiroOrdenador.setTurnoOrdenador(false);
		    	VentanaJuego.setUsarBomba(true);
		    	//DECREMENTAR ARMA
			    LinkedList<Armamento> a = new LinkedList<Armamento>();
			    int cont = 0;
			    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
			    	if(obj instanceof Radar && cont == 0)
			    		cont = 1;
			    	else
			    		a.add(obj);
			    }
			    VentanaNombreDeUsuario.jugador.setArmamento(a);
			    VentanaJuego.getLblCantidad_3().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumRadares());
			    if(VentanaNombreDeUsuario.jugador.getNumRadares() == 0)
			    	VentanaJuego.setUsarRadar(false);
			
		    }//fin
			
			if(VentanaJuego.isUsarMisil() == true){ //Si usa misil
				int x = 0;
				int y = 0;
				b = (JButton) pE.getSource();
				
				
				if(ColocarBarcosIA.esCasillaBarco(b) && !b.getBackground().equals(ColocarBarcosIA.barcoHundido)){
					for (Coordenadas objeto : VentanaJuego.listaCoordIA) {
						if (b.equals(objeto.getObjetoGuardado())) {
							x = objeto.getX();
							y = objeto.getY();
						}
				    }
					boolean esta=false;
					for(JButton obj: barcosGolpeadosIA){
						if(obj.equals(b))
							esta = true;
					}
					if(!esta)
						 barcosGolpeadosIA.add(b);
					esta = false;
					b.setBackground(ColocarBarcosIA.barcoHundido);
					
					if(x+1 < 10 && x+1 >= 0)
						b = ColocarBarcosIA.getGridButton(x+1, y);
					if(ColocarBarcosIA.esCasillaBarco(b)==false){}
					else{
						for(JButton obj: barcosGolpeadosIA){
							if(obj.equals(b))
								esta = true;
						}
						if(!esta)
							 barcosGolpeadosIA.add(b);
						esta = false;
						b.setBackground(ColocarBarcosIA.barcoHundido);
						if(x+2 < 10 && x+2 >= 0)
							b = ColocarBarcosIA.getGridButton(x+2, y);
						if(ColocarBarcosIA.esCasillaBarco(b)==false){}
						else{
							for(JButton obj: barcosGolpeadosIA){
								if(obj.equals(b))
									esta = true;
							}
							if(!esta)
								 barcosGolpeadosIA.add(b);
							esta = false;
							b.setBackground(ColocarBarcosIA.barcoHundido);
							if(x+3 < 10 && x+3 >= 0)
								b = ColocarBarcosIA.getGridButton(x+3, y);
							if(ColocarBarcosIA.esCasillaBarco(b)==false){}
							else
								b.setBackground(ColocarBarcosIA.barcoHundido);
						}
					}
					
					if(y+1 < 10 && y+1 >= 0)
						b = ColocarBarcosIA.getGridButton(x, y+1);
					if(ColocarBarcosIA.esCasillaBarco(b)==false){}
					else{
						for(JButton obj: barcosGolpeadosIA){
							if(obj.equals(b))
								esta = true;
						}
						if(!esta)
							 barcosGolpeadosIA.add(b);
						esta = false;
						b.setBackground(ColocarBarcosIA.barcoHundido);
						if(y+2 < 10 && y+2 >= 0)
							b = ColocarBarcosIA.getGridButton(x, y+2);
						if(ColocarBarcosIA.esCasillaBarco(b)==false){}
						else{
							for(JButton obj: barcosGolpeadosIA){
								if(obj.equals(b))
									esta = true;
							}
							if(!esta)
								 barcosGolpeadosIA.add(b);
							esta = false;
							b.setBackground(ColocarBarcosIA.barcoHundido);
							if(y+3 < 10 && y+3 >= 0)
								b = ColocarBarcosIA.getGridButton(x, y+3);
							if(ColocarBarcosIA.esCasillaBarco(b)==false){}
							else
								b.setBackground(ColocarBarcosIA.barcoHundido);
						}
					}
					
					if(x-1 < 10 && x-1 >= 0)
						b = ColocarBarcosIA.getGridButton(x-1, y);
					if(ColocarBarcosIA.esCasillaBarco(b)==false){}
					else{
						for(JButton obj: barcosGolpeadosIA){
							if(obj.equals(b))
								esta = true;
						}
						if(!esta)
							 barcosGolpeadosIA.add(b);
						esta = false;
						b.setBackground(ColocarBarcosIA.barcoHundido);
						if(x-2 < 10 && x-2 >= 0)
							b = ColocarBarcosIA.getGridButton(x-2, y);
						if(ColocarBarcosIA.esCasillaBarco(b)==false){}
						else{
							for(JButton obj: barcosGolpeadosIA){
								if(obj.equals(b))
									esta = true;
							}
							if(!esta)
								 barcosGolpeadosIA.add(b);
							esta = false;
							b.setBackground(ColocarBarcosIA.barcoHundido);
							if(x-3 < 10 && x-3 >= 0)
								b = ColocarBarcosIA.getGridButton(x-3, y);
							if(ColocarBarcosIA.esCasillaBarco(b)==false){}
							else
								b.setBackground(ColocarBarcosIA.barcoHundido);
						}
					}
					
					if(y-1 < 10 && y-1 >= 0)
						b = ColocarBarcosIA.getGridButton(x, y-1);
					if(ColocarBarcosIA.esCasillaBarco(b)==false){}
					else{
						for(JButton obj: barcosGolpeadosIA){
							if(obj.equals(b))
								esta = true;
						}
						if(!esta)
							 barcosGolpeadosIA.add(b);
						esta = false;
						b.setBackground(ColocarBarcosIA.barcoHundido);
						if(y-2 < 10 && y-2 >= 0)
							b = ColocarBarcosIA.getGridButton(x, y-2);
						if(ColocarBarcosIA.esCasillaBarco(b)==false){}
						else{
							for(JButton obj: barcosGolpeadosIA){
								if(obj.equals(b))
									esta = true;
							}
							if(!esta)
								 barcosGolpeadosIA.add(b);
							esta = false;
							b.setBackground(ColocarBarcosIA.barcoHundido);
							if(y-3 < 10 && y-3 >= 0)
								b = ColocarBarcosIA.getGridButton(x, y-3);
							if(ColocarBarcosIA.esCasillaBarco(b)==false){}
							else
								b.setBackground(ColocarBarcosIA.barcoHundido);
						}
					}
					VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+200);
					setPuntuacion(getPuntuacion() + 1);
					VentanaJuego.getLblPuntos().setText("Puntos: " + TiroJugador.getPuntuacion());
				
				
				setTurnoJugador(false);
		    	TiroOrdenador.setTurnoOrdenador(true);

		    	//DECREMENTAR ARMA
			    LinkedList<Armamento> a = new LinkedList<Armamento>();
			    int cont = 0;
			    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
			    	if(obj instanceof Misil && cont == 0)
			    		cont = 1;
			    	else
			    		a.add(obj);
			    }
			    VentanaNombreDeUsuario.jugador.setArmamento(a);
			    VentanaJuego.getLblCantidad_1().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumMisiles());
			    if(VentanaNombreDeUsuario.jugador.getNumMisiles() == 0)
			    	VentanaJuego.setUsarMisil(false);  
			    
			    VentanaJuego.getLblDinero().setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
			    TiroOrdenador.disparoIA();
				}
				else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido) || b.getBackground().equals(ColocarBarcosIA.agua)){
					JOptionPane.showMessageDialog(null, "La posicion que has elegido para disparar no es valida.",
							"Advertencia", 0);
					VentanaJuego.setUsarMisil(true);
				}
				else if(b.getBackground().equals(Color.BLACK) && ColocarBarcosIA.esCasillaBarco(b) == false){
					b.setBackground(ColocarBarcosIA.agua);
					VentanaNombreDeUsuario.jugador.getDinero().setCantidad(VentanaNombreDeUsuario.jugador.getDinero().getCantidad()+100);
					setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);

			    	//DECREMENTAR ARMA
				    LinkedList<Armamento> a = new LinkedList<Armamento>();
				    int cont = 0;
				    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
				    	if(obj instanceof Misil && cont == 0)
				    		cont = 1;
				    	else
				    		a.add(obj);
				    }
				    VentanaNombreDeUsuario.jugador.setArmamento(a);
				    VentanaJuego.getLblCantidad_1().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumMisiles());
				    if(VentanaNombreDeUsuario.jugador.getNumMisiles() == 0)
				    	VentanaJuego.setUsarMisil(false);  
				    
				    VentanaJuego.getLblDinero().setText("Dinero: " + VentanaNombreDeUsuario.jugador.getDinero().getCantidad());
				    TiroOrdenador.disparoIA();
				}
			}//fin si usa misil
			
			int barcos = contBotonesBarco();
			int tocados = contBarcosTocados();
			
			if(barcos == tocados){
				JOptionPane.showMessageDialog(null, "¡Enhorabuena, has ganado!");
				setTurnoJugador(false);
				TiroOrdenador.setTurnoOrdenador(false);
			    Clasificacion.setNombre(VentanaNombreDeUsuario.jugador.getNombre());
				Clasificacion.setVictoria("Victoria");
				Clasificacion.setPuntos(getPuntuacion());
				Clasificacion.rellenarFichero();
			}

		}//Fin if turno jugador

	} //fin if jugador ha colocado barcos
}
	
	public static int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int punt) {
		puntuacion = punt;
	}

	public int contBotonesBarco(){
		int cont = 0;
		
		for(JButton obj: ColocarBarcosIA.botonesBarco){
			if(obj != null)
			cont++;
		}
		return cont;
	}
	
	public int contBarcosTocados(){
		int cont = 0;
		
		for(JButton obj: barcosGolpeadosIA){
			if(obj != null)
			cont++;
		}
		return cont;
	}
	
	}
