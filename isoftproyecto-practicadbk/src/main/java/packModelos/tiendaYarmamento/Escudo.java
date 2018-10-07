package packModelos.tiendaYarmamento;

public class Escudo extends Armamento{

   private Dinero precio = new Dinero(0);
	
	
    public Escudo(){
    	this.precio.setCantidad(200);
    }
	
	public Dinero getPrecio() {
		return precio;
	}

	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return super.getCantidad();
	}

	public String toString(){
		String s= "Escudo";
		return s;
	}
	
	public void setPrecio(Dinero pPrecio){
	      precio = pPrecio;
	}
}
