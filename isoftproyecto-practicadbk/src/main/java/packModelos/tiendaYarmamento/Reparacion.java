package packModelos.tiendaYarmamento;

public class Reparacion extends Armamento{

	private Dinero precio = new Dinero(0);
	
	public Reparacion(){
		precio.setCantidad(1000);
	}
	
	@Override
	public Dinero getPrecio() {
		// TODO Auto-generated method stub
		return precio;
	}


	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return super.getCantidad();
	}
	
	public void setPrecio(Dinero pPrecio){
	      precio = pPrecio;
	}
	
	public String toString(){
		String s= "Reparacion";
		return s;
	}


}
