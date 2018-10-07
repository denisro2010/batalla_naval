package packModelos.barcos;

public class Barco {
	
	private static final int maxNumBarcos = 10;
	private static EstadoBarco estado;
	private static TipoBarco tipo;
	private static int numGolpes;
	
	public Barco(TipoBarco pTipo){
		this.tipo = pTipo; 
		this.estado = EstadoBarco.NORMAL;
	}

	public TipoBarco getTipoBarco(){
		return this.tipo;
	}
	
	//Faltan por poner los casos especiales (ESCUDO O MISIL) !!!!!!
	/**
	 * Registra los golpes recibidos por el barco
	 * @return Estado del barco
	 */
	public EstadoBarco golpeado() {
		numGolpes++;
		if (tipo.Longitud() <= numGolpes) {
			return EstadoBarco.HUNDIDO;
		}
		return EstadoBarco.TOCADO;
	}
}
