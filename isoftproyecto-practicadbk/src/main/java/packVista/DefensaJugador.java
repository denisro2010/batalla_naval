package packVista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packModelos.Coordenadas;
import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Escudo;
import packModelos.tiendaYarmamento.Reparacion;

public class DefensaJugador implements ActionListener{

	public void actionPerformed(ActionEvent arg0) {
		if(VentanaJuego.isColocarBarcosJugador() == true && ColocarBarcosIA.isColocarBarcosIA() == true){
			
			if(VentanaJuego.isUsarReparacion() == true){ //Reparacion
				JButton b;
				int x = 0;
				int y = 0;
				b = (JButton) arg0.getSource();
				
				if(!b.getBackground().equals(ColocarBarcosIA.barco) && !b.getBackground().equals(ColocarBarcosIA.agua) && !b.getBackground().equals(Color.BLUE)){
					for (Coordenadas objeto : VentanaJuego.listaCoord) {
						if (b.equals(objeto.getObjetoGuardado())) {
							x = objeto.getX();
							y = objeto.getY();
						}
				    }
					b.setBackground(ColocarBarcosIA.barco);
					TiroOrdenador.barcosGolpeadosJugador.remove(b);
					
					if(x+1 >= 0 && x+1 < 10){
						b = VentanaJuego.getGridButton(x+1, y);
						if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
						else{
							TiroOrdenador.barcosGolpeadosJugador.remove(b);
							b.setBackground(ColocarBarcosIA.barco);
							if(x+2 >= 0 && x+2 < 10){
								b = VentanaJuego.getGridButton(x+2, y);
								if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
								else{
									TiroOrdenador.barcosGolpeadosJugador.remove(b);
									b.setBackground(ColocarBarcosIA.barco);
									if(x+3 >= 0 && x+3 < 10){
										b = VentanaJuego.getGridButton(x+3, y);
										if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
										else{
											TiroOrdenador.barcosGolpeadosJugador.remove(b);
											b.setBackground(ColocarBarcosIA.barco);
										}
								}
						}	
					}}}//
					
					if(y+1 >= 0 && y+1 < 10){
						b = VentanaJuego.getGridButton(x, y+1);
						if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
						else{
							TiroOrdenador.barcosGolpeadosJugador.remove(b);
							b.setBackground(ColocarBarcosIA.barco);
							if(y+2 >= 0 && y+2 < 10){
								b = VentanaJuego.getGridButton(x, y+2);
								if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
								else{
									TiroOrdenador.barcosGolpeadosJugador.remove(b);
									b.setBackground(ColocarBarcosIA.barco);
									if(y+3 >= 0 && y+3 < 10){
										b = VentanaJuego.getGridButton(x, y+3);
										if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
										else{
											TiroOrdenador.barcosGolpeadosJugador.remove(b);
											b.setBackground(ColocarBarcosIA.barco);
										}
								}
						}	
					}}}//
					
					if(x-1 >= 0 && x-1 < 10){
						b = VentanaJuego.getGridButton(x-1, y);
						if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
						else{
							TiroOrdenador.barcosGolpeadosJugador.remove(b);
							b.setBackground(ColocarBarcosIA.barco);
							if(x-2 >= 0 && x-2 < 10){
								b = VentanaJuego.getGridButton(x-2, y);
								if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
								else{
									TiroOrdenador.barcosGolpeadosJugador.remove(b);
									b.setBackground(ColocarBarcosIA.barco);
									if(x-3 >= 0 && x-3 < 10){
										b = VentanaJuego.getGridButton(x-3, y);
										if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
										else{
											TiroOrdenador.barcosGolpeadosJugador.remove(b);
											b.setBackground(ColocarBarcosIA.barco);
										}
								}
						}	
					}}}//
					
					if(y-1 >= 0 && y-1 < 10){
						b = VentanaJuego.getGridButton(x, y-1);
						if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
						else{
							TiroOrdenador.barcosGolpeadosJugador.remove(b);
							b.setBackground(ColocarBarcosIA.barco);
							if(y-2 >= 0 && y-2 < 10){
								b = VentanaJuego.getGridButton(x, y-2);
								if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
								else{
									TiroOrdenador.barcosGolpeadosJugador.remove(b);
									b.setBackground(ColocarBarcosIA.barco);
									if(y-3 >= 0 && y-3 < 10){
										b = VentanaJuego.getGridButton(x, y-3);
										if(!b.getBackground().equals(ColocarBarcosIA.dado)){}
										else{
											TiroOrdenador.barcosGolpeadosJugador.remove(b);
											b.setBackground(ColocarBarcosIA.barco);
										}
								}
						}	
					}}}//
					
					TiroJugador.setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
					//DECREMENTAR ARMA
				    LinkedList<Armamento> a = new LinkedList<Armamento>();
				    int cont = 0;
				    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
				    	if(obj instanceof Reparacion && cont == 0)
				    		cont = 1;
				    	else
				    		a.add(obj);
				    }
				    VentanaNombreDeUsuario.jugador.setArmamento(a);
				    VentanaJuego.getLblCantidad_4().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumReparaciones());
				    if(VentanaNombreDeUsuario.jugador.getNumReparaciones() == 0)
				    	VentanaJuego.setUsarReparacion(false);  
				    
				    TiroOrdenador.disparoIA();
					
			    }
				else{
					JOptionPane.showMessageDialog(null, "La posicion que has elegido para reparar no es valida.",
							"Advertencia", 0);
					VentanaJuego.setUsarReparacion(true);
				}
			
			}//Fin reparacion
			
			if(VentanaJuego.isUsarEscudo() == true){ //Usar Escudo
				JButton b;
				int x = 0;
				int y = 0;
				b = (JButton) arg0.getSource();
				
				if(!b.getBackground().equals(Color.RED) && !b.getBackground().equals(ColocarBarcosIA.agua) && !b.getBackground().equals(Color.BLUE)){
					for (Coordenadas objeto : VentanaJuego.listaCoord) {
						if (b.equals(objeto.getObjetoGuardado())) {
							x = objeto.getX();
							y = objeto.getY();
						}
				    }
					b.setBackground(ColocarBarcosIA.escudo);
					
						if(x+1 >= 0 && x+1 < 10){
							b = VentanaJuego.getGridButton(x+1, y);
							if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
							else{
								b.setBackground(ColocarBarcosIA.escudo);
								if(x+2 >= 0 && x+2 < 10){
									b = VentanaJuego.getGridButton(x+2, y);
									if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
									else{
										b.setBackground(ColocarBarcosIA.escudo);
										if(x+3 >= 0 && x+3 < 10){
											b = VentanaJuego.getGridButton(x+3, y);
											if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
											else{
												b.setBackground(ColocarBarcosIA.escudo);
											}
									}
							}	
						}}}//
								
								if(y+1 >= 0 && y+1 < 10){
									b = VentanaJuego.getGridButton(x, y+1);
									if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
									else{
										b.setBackground(ColocarBarcosIA.escudo);
										if(y+2 >= 0 && y+2 < 10){
											b = VentanaJuego.getGridButton(x, y+2);
											if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
											else{
												b.setBackground(ColocarBarcosIA.escudo);
												if(y+3 >= 0 && y+3 < 10){
													b = VentanaJuego.getGridButton(x, y+3);
													if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
													else{
														b.setBackground(ColocarBarcosIA.escudo);
													}
											}
									}	
								}}}//
										
										if(x-1 >= 0 && x-1 < 10){
											b = VentanaJuego.getGridButton(x-1, y);
											if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
											else{
												b.setBackground(ColocarBarcosIA.escudo);
												if(x-2 >= 0 && x-2 < 10){
													b = VentanaJuego.getGridButton(x-2, y);
													if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
													else{
														b.setBackground(ColocarBarcosIA.escudo);
														if(x-3 >= 0 && x-3 < 10){
															b = VentanaJuego.getGridButton(x-3, y);
															if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
															else{
																b.setBackground(ColocarBarcosIA.escudo);
															}
													}
											}	
										}}}//
												
												if(y-1 >= 0 && y-1 < 10){
													b = VentanaJuego.getGridButton(x, y-1);
													if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
													else{
														b.setBackground(ColocarBarcosIA.escudo);
														if(y-2 >= 0 && y-2 < 10){
															b = VentanaJuego.getGridButton(x, y-2);
															if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
															else{
																b.setBackground(ColocarBarcosIA.escudo);
																if(y-3 >= 0 && y-3 < 10){
																	b = VentanaJuego.getGridButton(x, y-3);
																	if(!b.getBackground().equals(ColocarBarcosIA.barco)){}
																	else{
																		b.setBackground(ColocarBarcosIA.escudo);
																	}
															}
													}	
												}}}
					
					TiroJugador.setTurnoJugador(false);
			    	TiroOrdenador.setTurnoOrdenador(true);
			    	
					//DECREMENTAR ARMA
				    LinkedList<Armamento> a = new LinkedList<Armamento>();
				    int cont = 0;
				    for(Armamento obj: VentanaNombreDeUsuario.jugador.getArmamento()){
				    	if(obj instanceof Escudo && cont == 0)
				    		cont = 1;
				    	else
				    		a.add(obj);
				    }
				    VentanaNombreDeUsuario.jugador.setArmamento(a);
				    VentanaJuego.getLblCantidad_2().setText("Cantidad: " + VentanaNombreDeUsuario.jugador.getNumEscudos());
				    if(VentanaNombreDeUsuario.jugador.getNumEscudos() == 0)
				    	VentanaJuego.setUsarEscudo(false);  
				    
				    TiroOrdenador.disparoIA();
													
				}
				
				else{
					JOptionPane.showMessageDialog(null, "La posicion que has elegido para colocar el escudo no es valida.",
							"Advertencia", 0);
					VentanaJuego.setUsarEscudo(true);
				}
				
											
			}//fin escudo
						
		}
		
	}	

}