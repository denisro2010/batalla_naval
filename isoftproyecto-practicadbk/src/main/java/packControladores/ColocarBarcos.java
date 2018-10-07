package packControladores;
import java.util.*;

import packModelos.barcos.*;
import packModelos.tablero.*;

//
public class ColocarBarcos {
	
	protected FlotaJugador tablero;
	private TipoBarco tipoBarco;
	
	/**
	 * La orientaci�n actual del barco a ser colocado sobre el tablero
	 * true = eje x, 
	 * false = eje y
	 */
	private boolean orientacionActual;
	private List<Barco> barcosPorColocar = new LinkedList<Barco>();

	
	//Constructor
	public ColocarBarcos(FlotaJugador pTablero){
		this.tablero = pTablero;
		
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
	
	public boolean comprobarPosicionBarco(int pX, int pY){
		
		boolean sePuede = true;
		if (this.tipoBarco == null
				|| !this.tablero.coordenadaCorrecta(pX, pY)
                || (isOrientacionActual()== true && !this.tablero.coordenadaCorrecta(pX, pY + this.tipoBarco.Longitud() -1))
                || (isOrientacionActual() == false && !this.tablero.coordenadaCorrecta(pX + this.tipoBarco.Longitud() -1, pY))) {

            return false;
        }

		return sePuede;
		
	}
	
	public TipoBarco getTipoBarco() {
		return tipoBarco;
	}

	public void setTipoBarco(TipoBarco tipoBarco) {
		this.tipoBarco = tipoBarco;
	}

	public boolean isOrientacionActual() {
		return orientacionActual;
	}

	public void setOrientacionActual(boolean orientacionActual) {
		this.orientacionActual = orientacionActual;
	}
	
	public void girarBarco(){
		this.orientacionActual = !this.orientacionActual;
	}

}
