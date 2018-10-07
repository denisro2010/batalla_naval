package packModelos.tablero;

import packModelos.barcos.Barco;

public class Casilla {

	private Barco barco;
	private boolean visible;
	
	public Casilla() {
		this.barco = null;
		this.visible = false;
	}
	
	public boolean esVisible() {
		return this.visible;
	}

	public void hacerVisible() {
		this.visible = true;
	}

	public boolean contieneBarco() {
		return null != this.barco;
	}

	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco b) {
		this.barco = b;
	}
}
