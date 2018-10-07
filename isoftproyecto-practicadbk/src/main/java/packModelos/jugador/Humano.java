package packModelos.jugador;

import java.util.LinkedList;

import packModelos.tiendaYarmamento.Armamento;
import packModelos.tiendaYarmamento.Dinero;

public class Humano extends Jugador{

	private String victoria;
	
	//Constructor
	 public Humano(String pNombre){
		 super(pNombre);
	 }
	 
	 @Override
		public void setArmamento(LinkedList<Armamento> armamento) {
			// TODO Auto-generated method stub
			super.setArmamento(armamento);
		}
	 
	 public String getVictoria(){
		return victoria;
		 
	 }
	 public void setVictoria(String v1){
		 this.victoria=v1;
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
	
	@Override
    public String toString() {
	     return super.toString();
}

}
