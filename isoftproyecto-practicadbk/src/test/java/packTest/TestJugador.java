package packTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import packModelos.jugador.Humano;
import packModelos.jugador.Jugador;
import packModelos.jugador.Ordenador;

	public class TestJugador {

		private Jugador j;

		public void setUp() {
		}

		// Nombre vacio
		@Test
		public void nombreVacio() {
			j= new Humano("");
			assertEquals("Nombre vacio", "", j.getNombre());
		}

		// Nombre sin espacios
		@Test
		public void defaultNombre() {
			j = new Humano("Mikel");
			assertEquals("Nombre sin espacios", "Mikel", j.getNombre());
		}

		// Con espacios
		@Test
		public void defaultNombreEspacios() {
			j = new Humano("Mikel Abcdef");
			assertEquals("Con espacios", "Mikel Abcdef", j.getNombre());
		}

		// Espacios
		@Test
		public void nombreEspacios() {
			j = new Humano("   ");
			assertEquals("Espacios", "   ", j.getNombre());
		}

		//Nombre Largo
		@Test
		public void nombreLargo() {
			j = new Humano(
					"dfvbsdgjfsdgfdssfhsdgfhdfghdfghudfgdfuIEfhweui;djsfhsdhjg");
			assertEquals("Nombre Largo",
					"dfvbsdgjfsdgfdssfhsdgfhdfghdfghudfgdfuIEfhweui;djsfhsdhjg",
					j.getNombre());
		}
		
		//Nombre Ordenador
		@Test
		public void nombreIA() {
			j = new Ordenador();
			assertEquals("Nombre Ordenador", "Ordenador", j.getNombre());
		}
	}
