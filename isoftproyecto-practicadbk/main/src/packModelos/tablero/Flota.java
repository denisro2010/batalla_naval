package packModelos.tablero;

import packModelos.barcos.Barco;
import packModelos.barcos.EstadoBarco;
import packModelos.barcos.TipoBarco;
import packModelos.jugador.*;

public abstract class Flota {
	
	private static final int LONGITUD_T = 10;
	private int barcosRestantes = 0;
	private final Casilla[][] casillas;
	private final Jugador poseedor;
	private boolean suTurno;
	
	//Constructor
	public Flota(Jugador pPoseedor) {
		casillas = new Casilla[LONGITUD_T][LONGITUD_T];
		this.poseedor = pPoseedor;

		for (int i = 0; i < LONGITUD_T; i++) {
			for (int j = 0; j < LONGITUD_T; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}
	
	//Constructor por defecto, para la IA
	public Flota() {
		casillas = new Casilla[LONGITUD_T][LONGITUD_T];
		this.poseedor = new Ordenador();

		for (int i = 0; i < LONGITUD_T; i++) {
			for (int j = 0; j < LONGITUD_T; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}
	
	public void setPosBarco(Barco pBarco, int x, int y, boolean orientacion){
		//TODO
		boolean posicionValida= false;
		if(coordenadaCorrecta(x,y)==true){
			if(orientacion){
				for (int i=0; i<pBarco.getTipoBarco().Longitud() ;i++) {
					// Voy a reimplementar este metodo,no lo tengo claro
				}
			}else{
				for (int i=0; i<pBarco.getTipoBarco().Longitud() ;i++) {
					
				}
			}
		}
	}
	
	public void decrementarTamano(Barco pBarco) {
		//Si le dan al barco decrementa su longitud 
    }
	
	/**
	 * Registra el disparo en una posición x,y del tablero
	 **/
	public EstadoBarco disparo(int pX, int pY){
		EstadoBarco estado = EstadoBarco.NORMAL;

		if (casillas[pX][pY].contieneBarco() && !casillas[pX][pY].esVisible()) {
			Barco b = casillas[pX][pY].getBarco();
			estado = b.golpeado();

			if (EstadoBarco.HUNDIDO == estado) {
				barcosRestantes--;
			}
		}

		casillas[pX][pY].hacerVisible();

		return estado;
	}	
	
	public boolean sePuedeVer(int x, int y) {
		return casillas[x][y].esVisible();
	}
	
	public boolean tieneBarco(int x, int y) {
		return casillas[x][y].contieneBarco();
	}
	
	public TipoBarco tipoDeBarco(int x, int y) {
		return casillas[x][y].getBarco().getTipoBarco();
	}

	public boolean barcosQueQuedan() {
		return barcosRestantes > 0;
	}
	
	public Jugador getJugador(){
		return this.poseedor;
	}
	
	public int getTamanoTablero(){
		return LONGITUD_T;
	}
	
	public boolean barcosRestantes() {
		return barcosRestantes > 0;
	}
	
	public void setTurnoJugador(boolean turno) {
		suTurno = turno;
	}

	public boolean getTurnoJugador() {
		return suTurno;
	}
	
	//Comprueba si la coordenada esta dentro del tablero
	public boolean coordenadaCorrecta(int x, int y) {
		return x < LONGITUD_T && y < LONGITUD_T && x >= 0 && y >= 0;
	}

}
