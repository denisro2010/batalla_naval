package packVista;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import packBatallaNaval.BatallaNaval;
import packModelos.Clasificacion;
import packModelos.Coordenadas;
import packModelos.jugador.Ordenador;
import packModelos.tiendaYarmamento.Armamento;

public class TiroOrdenador{
	Clasificacion cla;
	static boolean turnoOrdenador = false;
	static ArrayList<JButton> barcosGolpeadosJugador = new ArrayList<JButton>();
	static ArrayList<Armamento> armasIA = new ArrayList<Armamento>();
	static Ordenador ordenador = new Ordenador();
	static ArrayList<JButton> barcoDescubierto = new ArrayList<JButton>();

	public static boolean isTurnoOrdenador() {
		return turnoOrdenador;
	}

	public static void setTurnoOrdenador(boolean pTurnoOrdenador) {
		turnoOrdenador = pTurnoOrdenador;
	}

	public static void disparoIA(){
		int dineroIA = ordenador.getDinero().getCantidad();
		Random r = new Random();
		int azar=-1;
		
		if(VentanaJuego.isColocarBarcosJugador() == true && ColocarBarcosIA.isColocarBarcosIA() == true && isTurnoOrdenador() == true){ //Solo si los barcos se han colocado
			
			//VICTORIA ORDENADOR
			boolean victoria=true;
			
			for(JButton obj: VentanaJuego.listaBotonesJugador){
				if(obj.getBackground().equals(ColocarBarcosIA.barco))
					victoria=false;
			}
			if(victoria==true){
				JOptionPane.showMessageDialog(null, "¡El ordenador ha ganado!");
				TiroJugador.setTurnoJugador(false);
				setTurnoOrdenador(false);
				Clasificacion.setNombre(VentanaNombreDeUsuario.jugador.getNombre());
				Clasificacion.setVictoria("Derrota");
				Clasificacion.setPuntos(TiroJugador.getPuntuacion());
				Clasificacion.rellenarFichero();	
			}
			
			if(dineroIA < 100){ //Si el ordenador se queda sin dinero
				ordenador.getDinero().setCantidad(100);
				dispararBomba();
			}
			
			if(dineroIA < 500 && dineroIA >= 100)
				dispararBomba();
			else if(dineroIA >= 500 && dineroIA < 800){
				azar = r.nextInt(5);
				if(azar == 5 || azar == 4)
				dispararMisil();
				else
				dispararBomba();
			}
			else if(dineroIA >= 800){
				azar = r.nextInt(5);
			if(azar == 5)
				usarRadar();
			else if (azar == 4 || azar == 3)
				dispararMisil();
			else
				dispararBomba();
			}
			
		 }
					
	}
	
	private static void usarRadar() {
		int x = 0;
		int y = 0;
		JButton b;
		Random click = new Random();
		int mouseClick = click.nextInt(100);
		b = VentanaJuego.listaBotonesJugador.get(mouseClick);
		
		for (Coordenadas objeto : VentanaJuego.listaCoord) {
			if (b.equals(objeto.getObjetoGuardado())) {
				x = objeto.getX();
				y = objeto.getY();
			}
	    }
		
		if(b.getBackground().equals(ColocarBarcosIA.barco)){
			 b.setBackground(ColocarBarcosIA.barco);
			 barcoDescubierto.add(b);
		}
		else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
			b.setBackground(ColocarBarcosIA.barcoHundido);
		else if(b.getBackground().equals(ColocarBarcosIA.dado))
			b.setBackground(ColocarBarcosIA.dado);
		else
			b.setBackground(ColocarBarcosIA.agua);
		
		for(int i = x; i < x+2; i++){
			    if(i >= 0 && i < 10)
				b = ColocarBarcosIA.getGridButton(i, y);
			    if(b.getBackground().equals(ColocarBarcosIA.barco)){
					 b.setBackground(ColocarBarcosIA.barco);
					 barcoDescubierto.add(b);
				}
				else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
					b.setBackground(ColocarBarcosIA.barcoHundido);
				else if(b.getBackground().equals(ColocarBarcosIA.dado))
					b.setBackground(ColocarBarcosIA.dado);
				else
					b.setBackground(ColocarBarcosIA.agua);		
		}
			    
		for(int j = y; j < y+2; j++){
		    if(j >= 0 && j < 10)
		    	b = ColocarBarcosIA.getGridButton(x, j);
		    if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
			else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
				b.setBackground(ColocarBarcosIA.barcoHundido);
			else if(b.getBackground().equals(ColocarBarcosIA.dado))
				b.setBackground(ColocarBarcosIA.dado);
			else
				b.setBackground(ColocarBarcosIA.agua);
	    }
		
		for(int i = x-1; i < x; i++){
			if(i >= 0 && i < 10)
		    	b = ColocarBarcosIA.getGridButton(i, y);
			if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
			else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
				b.setBackground(ColocarBarcosIA.barcoHundido);
			else if(b.getBackground().equals(ColocarBarcosIA.dado))
				b.setBackground(ColocarBarcosIA.dado);
			else
				b.setBackground(ColocarBarcosIA.agua);
	    }
		
	for(int j = y-1; j < y; j++){
		if(j >= 0 && j < 10)
	    	b = ColocarBarcosIA.getGridButton(x, j);
		if(b.getBackground().equals(ColocarBarcosIA.barco)){
			 b.setBackground(ColocarBarcosIA.barco);
			 barcoDescubierto.add(b);
		}
		else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
			b.setBackground(ColocarBarcosIA.barcoHundido);
		else if(b.getBackground().equals(ColocarBarcosIA.dado))
			b.setBackground(ColocarBarcosIA.dado);
		else
			b.setBackground(ColocarBarcosIA.agua);
    }
	
		if(x+1 >= 0 && y+1 < 10 && y+1 >= 0 && x+1 < 10){
	    	b = ColocarBarcosIA.getGridButton(x+1, y+1);
	    	if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
		else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
			b.setBackground(ColocarBarcosIA.barcoHundido);
		else if(b.getBackground().equals(ColocarBarcosIA.dado))
			b.setBackground(ColocarBarcosIA.dado);
		else
			b.setBackground(ColocarBarcosIA.agua);
		}
		
		if(x-1 >= 0 && y-1 < 10 && y-1 >= 0 && x-1 < 10){
			if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
			else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
				b.setBackground(ColocarBarcosIA.barcoHundido);
			else if(b.getBackground().equals(ColocarBarcosIA.dado))
				b.setBackground(ColocarBarcosIA.dado);
			else
				b.setBackground(ColocarBarcosIA.agua);
		}
		
		if(x+1 >= 0 && y-1 < 10 && y+1 >= 0 && x+1 < 10){
			if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
			else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
				b.setBackground(ColocarBarcosIA.barcoHundido);
			else if(b.getBackground().equals(ColocarBarcosIA.dado))
				b.setBackground(ColocarBarcosIA.dado);
			else
				b.setBackground(ColocarBarcosIA.agua);
		}
		
		if(x-1 >= 0 && y+1 < 10 && y+1 >= 0 && x-1 < 10){
			if(b.getBackground().equals(ColocarBarcosIA.barco)){
				 b.setBackground(ColocarBarcosIA.barco);
				 barcoDescubierto.add(b);
			}
			else if(b.getBackground().equals(ColocarBarcosIA.barcoHundido))
				b.setBackground(ColocarBarcosIA.barcoHundido);
			else if(b.getBackground().equals(ColocarBarcosIA.dado))
				b.setBackground(ColocarBarcosIA.dado);
			else
				b.setBackground(ColocarBarcosIA.agua);
		}
    	dispararBomba();
	}

	public static void dispararBomba(){
		JButton b;
		
			Random click = new Random();
			int mouseClick = click.nextInt(100);
			b = VentanaJuego.listaBotonesJugador.get(mouseClick);
			
		    if(b.getBackground().equals(ColocarBarcosIA.barco)){
		    	b.setBackground(ColocarBarcosIA.dado);
		    	setTurnoOrdenador(false);
		    	TiroJugador.setTurnoJugador(true);
		    	barcosGolpeadosJugador.add(b);
		    	JButton but = VentanaJuego.listaBotonesIA.get(0);
		    	but.getSize();
		    	ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+200);
		    }
		    else if(b.getBackground().equals(ColocarBarcosIA.agua)){
		    	b.setBackground(Color.BLUE);
		    	setTurnoOrdenador(false);
		    	TiroJugador.setTurnoJugador(true);
		    	JButton but = VentanaJuego.listaBotonesIA.get(0);
		    	but.getSize();
		    	ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+100);

		    }
		    else if(b.getBackground().equals(ColocarBarcosIA.escudo)){
		    	b.setBackground(Color.ORANGE);
		    	setTurnoOrdenador(false);
		    	TiroJugador.setTurnoJugador(true);
		    	JButton but = VentanaJuego.listaBotonesIA.get(0);
		    	but.getSize();
		    	//barcosGolpeadosJugador.add(b);
		    	ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+100);
		    }
		    else if(b.getBackground().equals(Color.ORANGE)){
		    	b.setBackground(ColocarBarcosIA.dado);
		    	setTurnoOrdenador(false);
		    	TiroJugador.setTurnoJugador(true);
		    	JButton but = VentanaJuego.listaBotonesIA.get(0);
		    	but.getSize();
		    	barcosGolpeadosJugador.add(b);
		    	ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+200);
		    }
		    else {
		    	dispararBomba();
		    } 
	}
	
	public static void dispararMisil(){
		int x = 0;
		int y = 0;
		JButton b;
		Random click = new Random();
		int mouseClick = click.nextInt(100);
		b = VentanaJuego.listaBotonesJugador.get(mouseClick);
		
		
		if(!b.getBackground().equals(ColocarBarcosIA.agua) && !b.getBackground().equals(Color.BLUE) && !b.getBackground().equals(Color.RED)){
			
			for (Coordenadas objeto : VentanaJuego.listaCoord) {
				if (b.equals(objeto.getObjetoGuardado())) {
					x = objeto.getX();
					y = objeto.getY();
				}
		    }
			b.setBackground(ColocarBarcosIA.barcoHundido);
			barcosGolpeadosJugador.add(b);
			
			if(x+1 < 10 && x+1 >= 0)
				b = VentanaJuego.getGridButton(x+1, y);
			if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
			else{
				b.setBackground(ColocarBarcosIA.barcoHundido);
				barcosGolpeadosJugador.add(b);
				if(x+2 < 10 && x+2 >= 0)
					b = VentanaJuego.getGridButton(x+2, y);
				if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
				else{
					b.setBackground(ColocarBarcosIA.barcoHundido);
					barcosGolpeadosJugador.add(b);
					if(x+3 < 10 && x+3 >= 0)
						b = VentanaJuego.getGridButton(x+3, y);
					if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
					else
						b.setBackground(ColocarBarcosIA.barcoHundido);
				}
			}
			if(y+1 < 10 && y+1 >= 0)
				b = VentanaJuego.getGridButton(x, y+1);
			if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
			else{
				b.setBackground(ColocarBarcosIA.barcoHundido);
				barcosGolpeadosJugador.add(b);
				if(y+2 < 10 && y+2 >= 0)
					b = VentanaJuego.getGridButton(x, y+2);
				if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
				else{
					b.setBackground(ColocarBarcosIA.barcoHundido);
					barcosGolpeadosJugador.add(b);
					if(y+3 < 10 && y+3 >= 0)
						b = VentanaJuego.getGridButton(x, y+3);
					if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
					else
						b.setBackground(ColocarBarcosIA.barcoHundido);
				}
			}
			
			if(x-1 < 10 && x-1 >= 0)
				b = VentanaJuego.getGridButton(x-1, y);
			if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
			else{
				b.setBackground(ColocarBarcosIA.barcoHundido);
				barcosGolpeadosJugador.add(b);
				if(x-2 < 10 && x-2 >= 0)
					b = VentanaJuego.getGridButton(x-2, y);
				if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
				else{
					b.setBackground(ColocarBarcosIA.barcoHundido);
					barcosGolpeadosJugador.add(b);
					if(x-3 < 10 && x-3 >= 0)
						b = VentanaJuego.getGridButton(x-3, y);
					if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
					else
						b.setBackground(ColocarBarcosIA.barcoHundido);
				}
			}
			
			if(y-1 < 10 && y-1 >= 0)
				b = VentanaJuego.getGridButton(x, y-1);
			if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
			else{
				b.setBackground(ColocarBarcosIA.barcoHundido);
				barcosGolpeadosJugador.add(b);
				if(y-2 < 10 && y-2 >= 0)
					b = VentanaJuego.getGridButton(x, y-2);
				if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
				else{
					b.setBackground(ColocarBarcosIA.barcoHundido);
					barcosGolpeadosJugador.add(b);
					if(y-3 < 10 && y-3 >= 0)
						b = VentanaJuego.getGridButton(x, y-3);
					if(b.getBackground().equals(ColocarBarcosIA.agua) || b.getBackground().equals(Color.BLUE)){}
					else
						b.setBackground(ColocarBarcosIA.barcoHundido);
				}
			}
			ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+200);
		}
		else if(b.getBackground().equals(ColocarBarcosIA.agua)){
			b.setBackground(Color.BLUE);
			ordenador.getDinero().setCantidad(ordenador.getDinero().getCantidad()+100);
		}
		else if(b.getBackground().equals(Color.BLUE)){
			dispararMisil();
		}
		else if(b.getBackground().equals(Color.RED)){
			dispararMisil();
		}
			
		TiroJugador.setTurnoJugador(true);
		setTurnoOrdenador(false);
    	JButton but = VentanaJuego.listaBotonesIA.get(0);
    	but.getSize();
		
	}
	
	public static int contBarcosTocados(){
		int cont = 0;
		
		for(JButton obj: barcosGolpeadosJugador){
			if(obj != null)
			cont++;
		}
		return cont;
	}

}
