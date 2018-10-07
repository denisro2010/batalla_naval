package packModelos.tablero;

import packModelos.barcos.Barco;
import packModelos.barcos.EstadoBarco;
import packModelos.barcos.TipoBarco;
import packModelos.jugador.Humano;
import packModelos.jugador.Jugador;
import packModelos.jugador.Ordenador;

public class FlotaOrdenador extends Flota{

	//Constructor
	public FlotaOrdenador() {
		super();
	}

	@Override
	public void setPosBarco(Barco pBarco, int pX, int pY, boolean pOrientacion) {
		// TODO Auto-generated method stub
		super.setPosBarco(pBarco, pX, pY, pOrientacion);
	}

	@Override
	public EstadoBarco disparo(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.disparo(pX, pY);
	}

	@Override
	public boolean sePuedeVer(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.sePuedeVer(pX, pY);
	}

	@Override
	public boolean tieneBarco(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.tieneBarco(pX, pY);
	}

	@Override
	public TipoBarco tipoDeBarco(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.tipoDeBarco(pX, pY);
	}

	@Override
	public boolean barcosQueQuedan() {
		// TODO Auto-generated method stub
		return super.barcosQueQuedan();
	}

	@Override
	public Jugador getJugador() {
		// TODO Auto-generated method stub
		return super.getJugador();
	}

	@Override
	public int getTamanoTablero() {
		// TODO Auto-generated method stub
		return super.getTamanoTablero();
	}

	@Override
	public boolean barcosRestantes() {
		// TODO Auto-generated method stub
		return super.barcosRestantes();
	}

	@Override
	public void setTurnoJugador(boolean pTurno) {
		// TODO Auto-generated method stub
		super.setTurnoJugador(pTurno);
	}

	@Override
	public boolean getTurnoJugador() {
		// TODO Auto-generated method stub
		return super.getTurnoJugador();
	}

	@Override
	public boolean coordenadaCorrecta(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.coordenadaCorrecta(pX, pY);
	}
	
}
