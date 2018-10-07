package packModelos.tiendaYarmamento;

public class Misil extends Armamento{
	
    private Dinero precio = new Dinero(0);
	
	
    public Misil(){
    	this.precio.setCantidad(300);
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
		String s= "Misil";
		return s;
	}

}
