package packModelos;

import java.util.ArrayList;
import java.util.List;

import packModelos.jugador.Jugador;

public class Clasificacion {
	
	private  List<Jugador> clasificaciones;
	
	public Clasificacion(){
		clasificaciones= new ArrayList<Jugador>();
	}
	public void anadirJugadorALaClasificacion(Jugador pJugador){
		/*
		 * Si la partida esta finalizada, añade el jugador a la lista de clasificaciones
		 * 
		 */
	}
	public void ordenadarLista(){
		/*
		 * Metodo para ordenar la lista de las clasificaciones, donde el primero sale el que mas puntos tiene
		 */
	}
	public List<Jugador> getClasificaciones() {
		return clasificaciones;
	}

	public void setClasificaciones(List<Jugador> pClasificaciones) {
		clasificaciones = pClasificaciones;
	}
	
}
