package ar.edu.untref.aydoo;

import org.junit.Assert;
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

    @Test
    public void miGestorRecibeNombreDeArchivoYArgumentoOutputPorLoQueElNombreDeCarpetEsOtro() {
        String args[] = {"mipresentacion.md", "--output=a"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        String resultado = miGestor.getNombreDeCarpeta();
        Assert.assertEquals("a",resultado);
    }
    @Test
    public void a() {
        String args[] = {"a", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        String resultado = miGestor.getNombreDeArchivo();
        Assert.assertEquals("a",resultado);
    }
}
