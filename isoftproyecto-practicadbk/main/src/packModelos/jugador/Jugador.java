package packModelos.jugador;

import java.util.LinkedList;
import java.util.Observable;
import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Dinero;

public abstract class Jugador {
	
	private String nombre;
	private LinkedList<Armamento> armamento;
	private Dinero dinero;
	private int puntuacion;
	
	//Constructor
	public Jugador(String pNombre){
		this.nombre = pNombre;
		dinero.setCantidad(0);
		this.puntuacion = 0;
		this.armamento = null;
	}
	
	//Constructor por defecto, lo hice para el ORDENADOR
	public Jugador(){
		this.nombre = "Ordenador";
		dinero.setCantidad(0);
		this.puntuacion = 0;
		this.armamento = null;
	}
	public void realizarDisparo(){
		
	}
	public void recibirDisparo(){
		
	}
	public void comprar(){
		
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


}
