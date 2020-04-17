package autopista;

import java.util.*;

/**
 * Clase Peaje
 * simula un peaje con cabinas. Controla la elección de la cabina a la que van a
 * parar las nuevas entradas de vehiculos
 * @author Fitxi
 * @version 1.0.0
 * @see Cabina
 * @see ArrayList
 * @see Orden
 * @see Collections
 * @see Comparator
 */
public class Peaje {

	private final int[][] tipoCobro = {
        {15,30}, // tiempos mínimos y máximos de cobro de los coches que llegan
        {15,30}, // a ser los primeros en cada una de las cabinas consideradas
        {15,45}, // Cada para se asigna a la cabina que le corresponde según
        {30,60}, // su número de orden
        {45,60}};
	public int numCabinas;
	private Collection<Cabina> misCabinas;
	/**
	 * las cabinas
	 */
	private Collection<Orden> miOrden;

	/**
	 * Constructor de Peaje
	 * Crea un nuevo peaje con el numero de cabinas que se le indica. Asigna a
	 * cada cabina los tiempo smáximos y mínimos de cobro
	 * @param estaciones
	 */
	public Peaje(int estaciones) {
		// TODO - implement Peaje.Peaje
		throw new UnsupportedOperationException();
	}

	/**
	 * método guardarCola
	 * Mete un nuevo coche en la cabina qie se le indica con el tiempo de lle-
	 * gada que también se le indica
	 * @param nCab número de cabina
	 * @param myReloj hora de llegada
	 */
	public void guardarCola(int nCab, Reloj myReloj) {
		// TODO - implement Peaje.guardarCola
		throw new UnsupportedOperationException();
	}

	/**
	 * método ordenar
	 * Ordena el ArrayList de ordenes en función del número de coches que esté
	 * esperando en la cabina a la que representa el orden (de menor a mayor)
	 * @param miOrden ArrayList a ordenar
	 */
	private void ordenar(java.util.ArrayList<Orden> miOrden) {
		// TODO - implement Peaje.ordenar
		throw new UnsupportedOperationException();
	}

	/**
	 * método eligeCabina
	 * Elije una cabina. 60% de probabilidad que sea la de menos coches, 30% la
	 * segunda de menos coches y 10% la tercera de menos coches
	 * @return el número de cabina que se ha elegido
	 */
	public int eligeCabina() {
		// TODO - implement Peaje.eligeCabina
		throw new UnsupportedOperationException();
	}

	/**
	 * método rondaCabinas
	 * Mira a ver si hay que servir alguna de las cabinas del peaje
	 * @param miOrloj tiempo actual
	 */
	public void rondaCabinas(Reloj miOrloj) {
		// TODO - implement Peaje.rondaCabinas
		throw new UnsupportedOperationException();
	}

	/**
	 * método estado
	 * Saca por pantalla los resultados de la simulación
	 * @param reloj tiempo del reloj
	 */
	public void estado(Reloj reloj) {
		// TODO - implement Peaje.estado
		throw new UnsupportedOperationException();
	}

}