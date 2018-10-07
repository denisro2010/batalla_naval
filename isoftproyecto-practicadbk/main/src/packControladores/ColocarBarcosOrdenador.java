package packControladores;

import java.util.Random;

import packModelos.barcos.TipoBarco;
import packModelos.tablero.FlotaJugador;

public class ColocarBarcosOrdenador extends ColocarBarcos{

	public ColocarBarcosOrdenador(Turnos pTurnos, FlotaJugador pTablero) {
		super(pTurnos, pTablero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean setPosBarco(int pX, int pY) {
		// TODO Auto-generated method stub
		return super.setPosBarco(pX, pY);
	}

	@Override
	public void colocarBarcoActual(TipoBarco pTipoBarco) {
		// TODO Auto-generated method stub
		super.colocarBarcoActual(pTipoBarco);
	}

	@Override
	public void inhabilitarBarcoColocado() {
		// TODO Auto-generated method stub
		super.inhabilitarBarcoColocado();
	}

	@Override
	public void girarBarco() {
		// TODO Auto-generated method stub
		super.girarBarco();
	}

}
