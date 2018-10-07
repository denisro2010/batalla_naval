package packControladores;

import java.util.ArrayList;
import java.util.List;

import packModelos.jugador.Jugador;
import packModelos.tablero.FlotaJugador;


public class Turnos {

	private Jugador jugadorActual;
	private Jugador jugadorInactivo;
	
	private FlotaJugador tableroJugadorActual;
	private FlotaJugador tableroJugadorInactivo;
	// AQUI LA GUI !!! -> private..........
	
	//Secuencia de turnos
	private  List<Class> secuenciaTurnos; // es final
	private int contadorSecuencia = 0;
	
	private boolean haGanado;
	
	//Constructor
	public Turnos(Jugador pJugadorActual, Jugador pJugadorInactivo,
			      FlotaJugador pTableroActual, FlotaJugador pTableroInactivo){ //FALTA LA GUI !!!
	}
	
	
}
