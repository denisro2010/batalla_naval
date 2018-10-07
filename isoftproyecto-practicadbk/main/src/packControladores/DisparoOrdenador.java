package packControladores;

import packModelos.barcos.EstadoBarco;
import packModelos.tablero.FlotaJugador;

public class DisparoOrdenador extends Disparo{

	public DisparoOrdenador(Turnos pTurno, FlotaJugador pTableroEnemigo) {
		super(pTurno, pTableroEnemigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EstadoBarco disparar(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.disparar(pX, pY);
	}

	@Override
	public boolean casillaDisponible(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.casillaDisponible(pX, pY);
	}

	@Override
	public FlotaJugador getTableroEnemigo() {
		// TODO Auto-generated method stub
		return super.getTableroEnemigo();
	}

	@Override
	public void acabarTurno() {
		// TODO Auto-generated method stub
		super.acabarTurno();
	}

}
