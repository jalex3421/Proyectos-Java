package autopista;

import java.util.*;

/**
 * Clase Cabina.
 * Simula el funcionamiento de una cabina de un peaje
 * @author Fitxi
 * @version 1.0.0 (enero/2015)
 * @see Vehiculo
 * @see Queue
 * @see Iterator
 * @see LinkedList
 * @see NoSuchElementException
 */
public class Cabina {

	/**
	 * cola de vehiculos
	 */
	private int nCoches;
	/**
	 * numero de coches en la cola
	 */
	private int maxCoches;
	/**
	 * numero máximo de coches en la cola
	 */
	private final int maxServ;
	/**
	 * tiempo maximo de espera del siguiente cocbro
	 */
	private final int minServ;
	/**
	 * tiempo minimo de espera del siguiente cobro
	 */
	private int servidos;
	/**
	 * numero de coches servidos
	 */
	private int totalEsperado;
	/**
	 * tiempo total esperado por los coches servidos
	 */
	private int proxServ;
	private Collection<Carrito> miColaVehiculos;

	public int getNCoches() {
		return this.nCoches;
	}

	public int getMaxCoches() {
		return this.maxCoches;
	}

	public int getServidos() {
		return this.servidos;
	}

	public int getTotalEsperado() {
		return this.totalEsperado;
	}

	public int getProxServ() {
		return this.proxServ;
	}

	/**
	 * Constructor de Cabina
	 * @param minServ Indica el tiempo mímino del servicio para la cabina
	 * @param maxServ Indica el tiempo máximo de espera por el servicio
	 */
	public Cabina(int minServ, int maxServ) {
		// TODO - implement Cabina.Cabina
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo proximoCobro
	 * Calcula el tiempo del proximo cobro en funcion de los tiempos de servicio
	 * de la cabina y el tiempo actual siguiendo una distribución equiprobable
	 * @param reloj el reloj con el tiempo actual
	 * @return instante de tiempo en que se cobrará al siguiente vehículo
	 */
	private int proximoCobro(Reloj reloj) {
		// TODO - implement Cabina.proximoCobro
		throw new UnsupportedOperationException();
	}

	/**
	 * Método contarCoche
	 * Si es necesario establecer un tiempo de cobro porque no había coches en
	 * la cabina, lo establece. Contabiliza el coche en la cola y si es superior
	 * al maximo de coches encolados hasta ahora, modifica dicho valor
	 * @param reloj el reloj con el tiempo actual
	 */
	private void contarCoche(Reloj reloj) {
		// TODO - implement Cabina.contarCoche
		throw new UnsupportedOperationException();
	}

	/**
	 * Método encolarCoche
	 * Simula la llegada de un nuevo coche a la cabina. Se contabiliza, se crea
	 * el vehiculo con su tiempo de entrada y se encola
	 * @param reloj el reloj con el tiempo actual
	 */
	public void encolarCoche(Reloj reloj) {
		// TODO - implement Cabina.encolarCoche
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo servirCabina
	 * Si ha llegado el momento de servir un vehículo, se le da servicio. Se
	 * contabiliza como servido, se elimina el vehiculo de la cola, se
	 * contabiliza el tiempo que ha estado esperando y, si es necesario, se
	 * programa un nuevo servicio
	 * @param reloj el reloj con el tiempo actual
	 */
	public void servirCabina(Reloj reloj) throws java.util.NoSuchElementException {
		// TODO - implement Cabina.servirCabina
		throw new UnsupportedOperationException();
	}

	/**
	 * Método getTotalEsperadoConCola
	 * @param reloj tiempo actual
	 * @return tiempo esperado en la cola considerando tanto servidos como aun no servidos
	 */
	public int getTotalEsperadoConCola(Reloj reloj) {
		// TODO - implement Cabina.getTotalEsperadoConCola
		throw new UnsupportedOperationException();
	}

}