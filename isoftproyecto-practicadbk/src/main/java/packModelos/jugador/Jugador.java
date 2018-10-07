package packModelos.jugador;

import java.util.LinkedList;
import packModelos.barcos.Barco;
import packModelos.tiendaYarmamento.*;


public abstract class Jugador {
	

	private String nombre;
	private LinkedList<Armamento> armamento = new LinkedList<Armamento>();
	private Dinero dinero = new Dinero(0);
	private int puntuacion;
	private Barco barco;
	
	
	//Constructor
	public Jugador(String pNombre){
		this.nombre = pNombre;
		dinero.setCantidad(10*70);
		this.puntuacion = 0;
		this.armamento = new LinkedList<Armamento>();
	}
	
	public void setArmamento(LinkedList<Armamento> armamento) {
		this.armamento = armamento;
	}

	//Constructor por defecto, lo hice para el ORDENADOR
	public Jugador(){
		this.nombre = "Ordenador";
		dinero.setCantidad(700);
		this.puntuacion = 0;
		this.armamento = null;
	}
	
	public LinkedList<Armamento> getArmamento() {
		return armamento;
	}

	public Dinero getDinero() {
		return dinero;
	}


	public int getPuntuacion() {
		return puntuacion;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String pNombre) {
		nombre = pNombre;
	}
	
	public int getNumBombas(){
		int bombas = 0;
		
		for(Armamento obj: armamento){
			if(obj instanceof Bomba){
				bombas++;
			}
		}
		return bombas;
	}
	
	public int getNumMisiles(){
		int misiles = 0;
		
		for(Armamento obj: armamento){
			if(obj instanceof Misil){
				misiles++;
			}
		}
		return misiles;
	}
	
	public int getNumRadares(){
		int radares = 0;
		
		for(Armamento obj: armamento){
			if(obj instanceof Radar){
				radares++;
			}
		}
		return radares;
	}
	
	public int getNumEscudos(){
		int escudos = 0;
		
		for(Armamento obj: armamento){
			if(obj instanceof Escudo){
				escudos++;
			}
		}
		return escudos;
	}
	
	public int getNumReparaciones(){
		int reparaciones = 0;
		
		for(Armamento obj: armamento){
			if(obj instanceof Reparacion){
				reparaciones++;
			}
		}
		return reparaciones;
	}
	
	public Barco getBarco() {
		return barco;
	}

	public void setBarco(Barco pBarco) {
		barco = pBarco;
	}

	

}
