package packModelos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;


public class Clasificacion extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1568566439187785989L;
	private static String nombre;
	private static String victoria;
	private static int puntos;
	//Las cargamos en memoria las puntuaciones
	
	private	String[] nombresColumnas = new String[] { "Nombre", "Victoria / Derrota", "Puntos"};
	private	Object[][] datos = new Object[][] {
		{ getNombre(), getVictoria(), new Integer(getPuntos())} };
		
	public Clasificacion(){
		//NombresColumnas
		nombresColumnas = new String[] { "Nombre", "Victoria / Derrota", "Puntos"};
		//LosDatos
		leerDatosFichero();
		datos = new Object[][] {
			{ getNombre(), getVictoria(), new Integer(getPuntos())} };
	}
	@Override
	public String getColumnName(int pColumn) {
		// TODO Auto-generated method stub
		return nombresColumnas[pColumn];
	}
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return nombresColumnas.length;
	}

	public Object getValueAt(int pRowIndex, int pColumnIndex) {
		// TODO Auto-generated method stub
		return datos[pRowIndex][pColumnIndex];
	}
	public static void rellenarFichero(){

		//Abrir el fichero en modo de escritura
		try (PrintWriter fichero=new PrintWriter("Puntuacion") ){
			//Gurdamos el fichero actualizado con la nota media
				fichero.println(getNombre());
				fichero.println(getPuntos());
				fichero.println(getVictoria());
		} catch (FileNotFoundException e) {
			//Salta un error, por si no se encuentra el Fichero
			System.err.println("No se ha podido guardar la clasificacion");
		}
	}
	
	public static void leerDatosFichero(){
		//Abrimos el fichero en modo lectura
		try(Scanner fichero =new Scanner(new File("Puntuacion"))){
			setNombre(fichero.nextLine());
			setPuntos(fichero.nextInt());
			setVictoria(fichero.next());
			
		}catch(FileNotFoundException e){
			//Salta un error, por si no se encuentra el Fichero
			System.err.println("Error al encontrar el fichero");
		}
	}
	
	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String pNombre) {
		nombre = pNombre;
	}

	public static String getVictoria() {
		return victoria;
	}

	public static void setVictoria(String pVictoria) {
		victoria = pVictoria;
	}

	public static int getPuntos() {
		return puntos;
	}

	public static void setPuntos(int i) {
		puntos = i;
	}
	
	public Class<?> getColumnClass(int pColumnIndex){
		switch(pColumnIndex){
		case 0:
			return String.class;
		case 1:
			return String.class;
		default :
			return Integer.class;
		}
		
	}
	
	
	
}
