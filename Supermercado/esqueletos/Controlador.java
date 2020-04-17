package autopista;

/**
 * Clase Controlador: Gestiona la llegada y marcha de coches del peaje, así como
 * la localización de información para la salida
 * @author Fitxi
 * @version 1.0.0 (enero/2015)
 * @see Trafico
 * @see Peaje
 * @see Scanner
 * @see Reloj
 */
public class Controlador {

	public final int estaciones = 5;
	private Trafico miTrafico;
	private Peaje miPeaje;

	/**
	 * Constructor del controlador
	 * @param r el reloj para que se calcule el tiempo de primera llegada
	 */
	public Controlador(Reloj r) {
		// TODO - implement Controlador.Controlador
		throw new UnsupportedOperationException();
	}

	/**
	 * Método LlegaCoche
	 * Comprueba si es el momento de que llegue un nuevo coche y, en tal caso
	 * simula su llegada y lo incluye en la cabina que corresponda. Tras ello
	 * programa la siguiente llegada
	 * @param r reloj para concultar el tiempo actual
	 */
	public void LlegaCoche(Reloj r) {
		// TODO - implement Controlador.LlegaCoche
		throw new UnsupportedOperationException();
	}

	/**
	 * Método estadoPeaje
	 * Le indica al peaje que saque por pantalla los resultados de la simulacion
	 * @param r tiempo actual
	 */
	public void estadoPeaje(Reloj r) {
		// TODO - implement Controlador.estadoPeaje
		throw new UnsupportedOperationException();
	}

	/**
	 * Metodo marchaCoche
	 * Le dice al peaje que haga una ronda de comprobación entre sus cabinas
	 * @param r tiempo actual
	 */
	public void marchaCoche(Reloj r) {
		// TODO - implement Controlador.marchaCoche
		throw new UnsupportedOperationException();
	}

}