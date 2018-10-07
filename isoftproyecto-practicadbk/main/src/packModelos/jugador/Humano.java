package packModelos.jugador;

import java.util.LinkedList;

import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Dinero;

public class Humano extends Jugador{
	

	//Constructor
	public Humano(String pNombre) {
		super(pNombre);
	}

	@Override
	public void comprar() {
		// TODO Auto-generated method stub
		super.comprar();
	}
	@Override
	public void realizarDisparo() {
		// TODO Auto-generated method stub
		super.realizarDisparo();
	}

	@Override
	public void recibirDisparo() {
		// TODO Auto-generated method stub
		super.recibirDisparo();
	}
	@Override
	public LinkedList<Armamento> getArmamento() {
		// TODO Auto-generated method stub
		return super.getArmamento();
	}

	@Override
	public Dinero getDinero() {
		// TODO Auto-generated method stub
		return super.getDinero();
	}

	@Override
	public int getPuntuacion() {
		// TODO Auto-generated method stub
		return super.getPuntuacion();
	}

	@Override
	public String getNombre() {
		return super.getNombre();
	}

	@Override
	public void setNombre(String pNombre) {
		super.setNombre(pNombre);
	}

}
