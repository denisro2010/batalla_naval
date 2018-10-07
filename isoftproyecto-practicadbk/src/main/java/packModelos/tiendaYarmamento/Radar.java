package packModelos.tiendaYarmamento;

public class Radar extends Armamento{
	
      private Dinero precio = new Dinero(0);
	
	
    public Radar(){
    	this.precio.setCantidad(500);
    }

	public Dinero getPrecio() {
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
		String s= "Radar";
		return s;
	}

}
