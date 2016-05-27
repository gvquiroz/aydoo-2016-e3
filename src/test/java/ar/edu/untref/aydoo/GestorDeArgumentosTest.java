package ar.edu.untref.aydoo;

import org.junit.Test;

/**
 * Created by Velonter on 5/27/2016.
 */
public class GestorDeArgumentosTest {
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void miGestorRecibeUnNombreInvalidoYTiraException() {
        String args[] = {"mi presentacion.md", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        miGestor.getNombreDeArchivo();
    }
}
