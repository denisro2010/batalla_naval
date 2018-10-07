package packModelos.tiendaYarmamento;

public class Dinero {
    
	private int cantidad;
	
	//Constructor
	public Dinero(int pCant){
		this.cantidad = pCant;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}

	public void setCantidad(int pCantidad) {
		cantidad = pCantidad;
	}
}
