package packControladores;
import java.util.*;

import packModelos.*;
import packModelos.barcos.Barco;
import packModelos.barcos.TipoBarco;
import packModelos.tablero.FlotaJugador;
//
public class ColocarBarcos {
	
	protected FlotaJugador tablero;
	private TipoBarco tipoBarco;
	
	/**
	 * La orientaci�n actual del barco a ser colocado sobre el tablero
	 * true = eje x, 
	 * false = eje y
	 */
	private boolean orientacionActual = false;
	private List<Barco> barcosPorColocar = new LinkedList<Barco>();
	
	/**
	 * Aqu� ir�a la interfaz encargada de elegir los barcos.
	 */
	//private ... selector;
	
	/**
	 * El controlador de turnos para controlar la colocaci�n de los barcos
	 */
	private Turnos turnos;
	
	//Constructor
	public ColocarBarcos(Turnos pTurnos, FlotaJugador pTablero){
		this.tablero = pTablero;
		this.turnos = pTurnos;
		
		//Añade a la lista los barcos que tiene que colocar
		barcosPorColocar.add(new Barco(TipoBarco.PORTAAVIONES));
		barcosPorColocar.add(new Barco(TipoBarco.SUBMARINO));
		barcosPorColocar.add(new Barco(TipoBarco.SUBMARINO));
		barcosPorColocar.add(new Barco(TipoBarco.DESTRUCTOR));
		barcosPorColocar.add(new Barco(TipoBarco.DESTRUCTOR));
		barcosPorColocar.add(new Barco(TipoBarco.DESTRUCTOR));
		barcosPorColocar.add(new Barco(TipoBarco.FRAGATA));
		barcosPorColocar.add(new Barco(TipoBarco.FRAGATA));
		barcosPorColocar.add(new Barco(TipoBarco.FRAGATA));
		barcosPorColocar.add(new Barco(TipoBarco.FRAGATA));
		
	}
	
	public boolean setPosBarco(int pX, int pY){
		boolean sePuedeColocar = true;
		//Si está fuera de los límites del tablero, no se puede colocar
		if(!this.tablero.coordenadaCorrecta(pX, pY)
			|| (this.orientacionActual && !this.tablero.coordenadaCorrecta(pX + this.tipoBarco.Longitud() -1, pY))
			|| (this.orientacionActual && !this.tablero.coordenadaCorrecta(pX, pY + this.tipoBarco.Longitud() -1))
			|| this.tipoBarco == null){
			
			sePuedeColocar = false;
		}
		else{
			if(this.orientacionActual){
				for(int i=0; i<this.tipoBarco.Longitud(); i++){
					sePuedeColocar = !this.tablero.tieneBarco(pX + i, pY);
				}
			}
			else{
				for(int j=0; j<this.tipoBarco.Longitud(); j++){
					sePuedeColocar = !this.tablero.tieneBarco(pX, pY + j);
				}
			}
		
			//Coloca los barcos
			if(sePuedeColocar){
				this.tablero.setPosBarco(new Barco(this.tipoBarco), pX, pY, orientacionActual);
			}
		}
		return sePuedeColocar;
	}
	
	public void colocarBarcoActual(TipoBarco pTipoBarco){
		//TODO
	}
	
	/**
	 * Quita la opci�n de poder volver a colocar los barcos que ya han sido colocados
	 */
	public void inhabilitarBarcoColocado(){
		//TODO
	}
	
	public void girarBarco(){
		this.orientacionActual = !this.orientacionActual;
	}

}
