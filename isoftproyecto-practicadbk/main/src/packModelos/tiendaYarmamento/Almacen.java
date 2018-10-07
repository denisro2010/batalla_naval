package packModelos.tiendaYarmamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Almacen implements Observer{
	
	private static Almacen mAlmacen= new Almacen();
	private List<Armamento> armamento;
	
	private Almacen(){
		armamento= new ArrayList<Armamento>();
	}
	
	public List<Armamento> getArmamento(){
		return this.armamento;
	}

	public void update(Observable pO, Object pArg) {
		// TODO Auto-generated method stub
		
	}

	public static Almacen getmAlmacen() {
		return mAlmacen;
	}

	public static void setmAlmacen(Almacen pMAlmacen) {
		mAlmacen = pMAlmacen;
	}

}
