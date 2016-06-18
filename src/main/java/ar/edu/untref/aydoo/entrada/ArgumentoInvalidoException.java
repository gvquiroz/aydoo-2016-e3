package ar.edu.untref.aydoo.entrada;

/**
 * Created by Velonter on 5/23/2016.
 */
public class ArgumentoInvalidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final static String mensaje = "Los parametros ingresados no son validos.";

	public ArgumentoInvalidoException() {
		super(mensaje);
	}
}
