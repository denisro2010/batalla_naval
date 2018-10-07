package packModelos.barcos;

public class Barco {
	
	private EstadoBarco estado;
	private TipoBarco tipo;
	private int numGolpes;
	
	public Barco(TipoBarco pTipo){
		tipo = pTipo; 
		estado = EstadoBarco.NORMAL;
	}

	public TipoBarco getTipoBarco(){
		return this.tipo;
	}
	
	public EstadoBarco getEstadoBarco(){
		return this.estado;
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
