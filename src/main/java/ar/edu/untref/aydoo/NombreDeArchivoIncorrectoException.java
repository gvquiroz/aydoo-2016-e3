package ar.edu.untref.aydoo;

/**
 * Created by Velonter on 5/20/2016.
 */
public class NombreDeArchivoIncorrectoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private final static String mensaje = "El nombre del archivo ingresado no es valido.";

	public NombreDeArchivoIncorrectoException() {
		super(mensaje);
	}
	
}
