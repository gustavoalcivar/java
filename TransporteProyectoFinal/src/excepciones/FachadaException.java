package excepciones;

/**
 * Esta clase representa a las excepciones lanzadas por las clases Fachada y
 * envuelve a las excepciones lanzadas por las clases que encapsulan la
 * persistencia.
 */
public class FachadaException extends Exception {

    /**
     * Construye una excepción con un mensaje de error nulo.
     */
    public FachadaException() {
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro.
     * @param msj Mensaje de error.
     */
    public FachadaException(String msj) {
        super(msj);
    }

    /**
     * Construye una excepción con el mensaje de error del parámetro y la causa
     * original del error.
     * @param msj Mensaje de error.
     * @param causa Causa original del error.
     */
    public FachadaException(String msj, Throwable causa) {
        super(msj, causa);
    }

    /**
     * Construye una excepción la causa original del error.
     * @param causa Causa original del error.
     */
    public FachadaException(Throwable causa) {
        super(causa);
    }
}
