package packModelos.barcos;

public enum TipoBarco {
	PORTAAVIONES(4), SUBMARINO(3), DESTRUCTOR(2), FRAGATA(1);
	
	private int longitud;
	
	private TipoBarco(int pLongitud){
		this.longitud = pLongitud;
	}
	
	public int Longitud(){
		return this.longitud;
	}
	
}
