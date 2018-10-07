package packModelos.tiendaYarmamento;

public class Armamento {
	
	private Dinero precio;
	private int cantidad;
	
	public Armamento(){
		this.cantidad = 4;
		precio.setCantidad(100);
	}
	
	public Dinero getPrecio() {
		return precio;
	}
	
	public void setPrecio(Dinero pPrecio) {
		precio = pPrecio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int pCantidad) {
		cantidad = pCantidad;
	}

}
