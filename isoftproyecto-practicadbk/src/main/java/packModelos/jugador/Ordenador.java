package packModelos.jugador;

import java.util.LinkedList;

import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Dinero;

public class Ordenador extends Jugador {

	
	//Constructor
	public Ordenador() {
		super();
	}
	
	@Override
	public void setArmamento(LinkedList<Armamento> armamento) {
		// TODO Auto-generated method stub
		super.setArmamento(armamento);
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
}
