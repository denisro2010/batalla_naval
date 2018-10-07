package packModelos;

import javax.swing.JButton;

public class Coordenadas {

	private int x;
	private int y;
	private JButton objetoGuardado;
	
	public Coordenadas(){
	}

	public JButton getObjetoGuardado() {
		return objetoGuardado;
	}

	public void setObjetoGuardado(JButton objetoGuardado) {
		this.objetoGuardado = objetoGuardado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
