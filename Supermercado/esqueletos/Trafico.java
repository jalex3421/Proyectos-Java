package autopista;

/**
 * Clase Trafico
 * Se encarga de crear llegadas de coche de modo que sigan una distribución
 * exponencial con una media determinada
 * @author Fitxi
 * @version 1.0.0
 * @see Math
 */
public class Trafico {

	private final int tMedio;
	/**
	 * media de la distribución de llegadas
	 */
	private int tLlegada;

	/**
	 * Constructor del Trafico
	 * @param tiempo tiempo medio de llegada
	 */
	public Trafico(int tiempo) {
		// TODO - implement Trafico.Trafico
		throw new UnsupportedOperationException();
	}

	/**
	 * método getProximaLlegada
	 * @return tiempo de proxima llegada
	 */
	public int getProximaLlegada() {
		// TODO - implement Trafico.getProximaLlegada
		throw new UnsupportedOperationException();
	}

	/**
	 * método proximaLlegada
	 * Calcula el timepo de proxima llegada teniendo en cuenta la distribucion
	 * considerada y el tiempo actual
	 * @param r reloj con el tiempo actual
	 */
	public void proximaLlegada(Reloj r) {
		// TODO - implement Trafico.proximaLlegada
		throw new UnsupportedOperationException();
	}

}