package packTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import packModelos.barcos.Barco;
import packModelos.barcos.EstadoBarco;
import packModelos.barcos.TipoBarco;

public class TestBarco {

		private Barco barco;
		private EstadoBarco estado;

		public void setUp() {
		}

		// Fragata
		@Test
		public void crearFragata() {
			barco = new Barco(TipoBarco.FRAGATA);
			assertEquals("Fragata", TipoBarco.FRAGATA, barco.getTipoBarco());
		}

		// Submarino
		@Test
		public void crearSubmarino() {
			barco = new Barco(TipoBarco.SUBMARINO);
			assertEquals("Submarino", TipoBarco.SUBMARINO, barco.getTipoBarco());
		}

		// Destructor
		@Test
		public void crearDestructor() {
			barco = new Barco(TipoBarco.DESTRUCTOR);
			assertEquals("Destructor", TipoBarco.DESTRUCTOR, barco.getTipoBarco());
		}

		// Portaavion
		@Test
		public void crearPortaavion() {
			barco = new Barco(TipoBarco.PORTAAVIONES);
			assertEquals("Portaaviones", TipoBarco.PORTAAVIONES, barco.getTipoBarco());
		}

		// Un golpe
		@Test
		public void unGolpe() {
			barco = new Barco(TipoBarco.SUBMARINO);
			estado = barco.golpeado();
			assertEquals("Golpeado", EstadoBarco.TOCADO, estado);
		}

		// Hundir
		@Test
		public void hundir() {
			barco = new Barco(TipoBarco.SUBMARINO);
			barco.golpeado();
			barco.golpeado();
			estado = barco.golpeado();
			assertEquals("Hundido", EstadoBarco.HUNDIDO, estado);
		}

		// Hundir y luego golpear
		@Test
		public void masQueHundido() {
			barco = new Barco(TipoBarco.SUBMARINO);
			barco.golpeado();
			barco.golpeado();
			barco.golpeado();
			estado = barco.golpeado();
			assertEquals("Hundido y luego golpeado", EstadoBarco.HUNDIDO, estado);
		}
	}

