package packControladores;
import packControladores.Turnos;
import packModelos.barcos.EstadoBarco;
import packModelos.barcos.TipoBarco;
import packModelos.tablero.FlotaJugador;


public class Disparo {

	private  FlotaJugador tableroEnemigo; //final
	private  Turnos turno; //final, pero todavia da error
	private final String mensajeHundido = " ha hundido tu ";
    private final String mensajeTocado = " le ha dado!";
	private String mensajeTocado2;
	
	
	//Constructor
	public Disparo(Turnos pTurno, FlotaJugador pTableroEnemigo) {
		this.turno = turno; //Da error porque no se ha inicializado
		this.tableroEnemigo = tableroEnemigo;
		this.mensajeTocado2 = null;
	}
	
	public EstadoBarco disparar(int pX, int pY){
		//No se como seguir no se me ocurre. Koldo
		EstadoBarco estado = this.tableroEnemigo.disparo(pX, pY);
		if(estado == EstadoBarco.HUNDIDO){
			//TipoBarco tb = this.tableroEnemigo.tipoDeBarco(pX, pY);
		}
		if(estado == EstadoBarco.TOCADO){
			
		}
		return null;
	}
	
	/**
	 * Devuelve true si una casilla puede ser seleccionada para disparar en ella
	 **/
	public boolean casillaDisponible(int pX, int pY){
		//TODO
		return false;
	}
	
	public FlotaJugador getTableroEnemigo(){
		//TODO
		return this.tableroEnemigo;
	}
	
	public void acabarTurno(){
		//TODO
	}
	
}
