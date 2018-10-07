package packTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import packModelos.barcos.Barco;
import packModelos.barcos.EstadoBarco;
import packModelos.barcos.TipoBarco;
import packModelos.jugador.Humano;
import packModelos.tablero.Flota;
import packModelos.tablero.FlotaJugador;

public class TestFlota {
	
	private Flota flota;
	private Humano jugador;

	@Before
	public void setUp() {
		jugador = new Humano("Player");
	}

	// Constructor
	@Test
	public void defaultConstructor() {
		flota = new FlotaJugador(jugador);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				assertTrue("Viewable?", !flota.sePuedeVer(x, y));
				assertTrue("Ship?", !flota.sePuedeVer(x, y));
			}
		}
	}

	// Set barco
	@Test
	public void setBarco() {
		flota = new FlotaJugador(jugador);
		Barco b = new Barco(TipoBarco.SUBMARINO);
		flota.setPosBarco(b, 5, 5, true);
		assertTrue(flota.tieneBarco(5, 5));
		assertTrue(flota.tieneBarco(6, 5));
		assertTrue(flota.tieneBarco(7, 5));
	}

	// Disparar barco
	@Test
	public void dispararBarco() {
		flota = new FlotaJugador(jugador);
		Barco b = new Barco(TipoBarco.SUBMARINO);
		flota.setPosBarco(b, 5, 5, true);
		b.getEstadoBarco();
		assertEquals(EstadoBarco.TOCADO, flota.disparo(5, 5));
		b.getEstadoBarco();
		assertEquals(EstadoBarco.TOCADO, flota.disparo(6, 5));
		b.getEstadoBarco();
		assertEquals(EstadoBarco.HUNDIDO, flota.disparo(7, 5));
		b.getEstadoBarco();
		assertEquals(EstadoBarco.NORMAL, flota.disparo(8, 5));
	}

	//Encontrar TipoBarco
	@Test
	public void encontrarTipoBarco() {
		flota = new FlotaJugador(jugador);
		Barco b = new Barco(TipoBarco.SUBMARINO);
		Barco b2 = new Barco(TipoBarco.PORTAAVIONES);
		flota.setPosBarco(b, 5, 5, true);
		flota.setPosBarco(b2, 4, 5, false);
		assertEquals(TipoBarco.SUBMARINO, flota.tipoDeBarco(6, 5));
		assertEquals(TipoBarco.PORTAAVIONES,
				flota.tipoDeBarco(4, 6));
	}

	// Barcos restantes
	@Test
	public void barcosRestantes() {
		flota = new FlotaJugador(jugador);
		assertTrue("Sin barcos", !flota.barcosRestantes());
		Barco b = new Barco(TipoBarco.SUBMARINO);
		flota.setPosBarco(b, 5, 5, true);
		assertTrue("Barcos despues de colocar", flota.barcosRestantes());
		flota.disparo(5, 5);
		flota.disparo(6, 5);
		flota.disparo(7, 5);
		assertTrue("Barcos despues de hundir", !flota.barcosRestantes());
	}

	// Coord correcta
	@Test
	public void coordCorrecta() {
		flota = new FlotaJugador(jugador);
		assertTrue("Esquina inferior", flota.coordenadaCorrecta(0, 0));
		assertTrue("Esquina superior", flota.coordenadaCorrecta(9, 9));
		assertTrue("Mitad", flota.coordenadaCorrecta(5, 5));
		assertTrue("Fuera por abajo", !flota.coordenadaCorrecta(0, -1));
		assertTrue("Fuera por arriba", !flota.coordenadaCorrecta(0, 11));
	}

	// Tamaño tablero
	@Test
	public void tamanoTablero() {
		flota = new FlotaJugador(jugador);
		assertEquals("Comprobar tamaño tablero", 10, flota.getTamanoTablero());
	}

	// Comprobar jugador
	@Test
	public void comprobarJugador() {
		flota = new FlotaJugador(jugador);
		assertEquals("Jugador", jugador, flota.getJugador());
	}

	// Estado jugador
	@Test
	public void estadoJugador() {
		flota = new FlotaJugador(jugador);
		flota.setTurnoJugador(true);
		assertTrue("Turno activo", flota.getTurnoJugador());
		flota.setTurnoJugador(false);
		assertTrue("Turno activo", !flota.getTurnoJugador());
	}
}
