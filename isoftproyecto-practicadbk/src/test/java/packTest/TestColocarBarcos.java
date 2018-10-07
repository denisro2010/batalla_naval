package packTest;

import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import packControladores.ColocarBarcos;
import packModelos.barcos.Barco;
import packModelos.barcos.TipoBarco;
import packModelos.jugador.Humano;
import packModelos.jugador.Jugador;
import packModelos.tablero.Flota;
import packModelos.tablero.FlotaJugador;


public class TestColocarBarcos {

	private Jugador j;
	private FlotaJugador tablero;
	private ColocarBarcos cb;

	@Before
	public void setUp() {
		j = new Humano("Player");
		tablero = new FlotaJugador(j);
		cb = new ColocarBarcos(tablero);
	}

	//Pos correcta
	@Test
	public void posicionBuena() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		assertTrue(cb.comprobarPosicionBarco(5, 5));
	}

	//Fuera del tablero
	@Test
	public void fueraTablero() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		assertTrue(!cb.comprobarPosicionBarco(11, 11));
	}

	//Se sale del tablero
	@Test
	public void salirseDelTablero() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		assertTrue(!cb.comprobarPosicionBarco(8, 8));
	}

	// Comprobar tamaños barcos
	@Test
	public void comprobarTamanos() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		assertTrue(!cb.comprobarPosicionBarco(7, 7));
		assertTrue(cb.comprobarPosicionBarco(5, 5));
		
		cb.setTipoBarco(TipoBarco.DESTRUCTOR);
		assertTrue(!cb.comprobarPosicionBarco(9, 9));
		assertTrue(cb.comprobarPosicionBarco(5, 5));
		
		cb.setTipoBarco(TipoBarco.SUBMARINO);
		assertTrue(!cb.comprobarPosicionBarco(8, 8));
		assertTrue(cb.comprobarPosicionBarco(5, 5));
		
		cb.setTipoBarco(TipoBarco.FRAGATA);
		assertTrue(!cb.comprobarPosicionBarco(10, 10));
		assertTrue(cb.comprobarPosicionBarco(5, 5));
	}

	// Rotacion barco
	@Test
	public void rotacion() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		assertTrue(!cb.comprobarPosicionBarco(7, 3));
		cb.girarBarco();
		assertTrue(cb.comprobarPosicionBarco(6, 3));
	}

	// Return rotacion
	@Test
	public void returnRotacion() {
		cb.setTipoBarco(TipoBarco.PORTAAVIONES);
		cb.girarBarco();
		assertTrue(!cb.comprobarPosicionBarco(3, 7));
		cb.girarBarco();
		assertTrue(cb.comprobarPosicionBarco(3, 6));
	}
}

