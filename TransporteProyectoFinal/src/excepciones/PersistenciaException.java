package excepciones;

/**
 * Esta clase representa a las excepciones lanzadas por las clases
 * que encapsulan la persistencia.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por omisión. Construye una excepción con un mensaje de error
     * nulo.
     */
    public PersistenciaException() {
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro.
     * @param msj Mensaje de error.
     */
    public PersistenciaException(String msj) {
        super(msj);
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro y la causa
     * original del error.
     * @param msj Mensaje de error.
     * @param causa Causa original del error.
     */
    public PersistenciaException(String msj, Throwable causa) {
        super(msj, causa);
    }

    /**
     * Construye una excepción la causa original del error.
     * @param causa Causa original del error.
     */
    public PersistenciaException(Throwable causa) {
        super(causa);
    }
}
