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

    @Test(expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEnie() {
        String args[] = {"mipresñentacion.md", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        miGestor.getNombreDeArchivo();
    }

   @Test(expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEnieMayuscula() {
       String args[] = {"maÑana.md", "--mode=no-output"};
       GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
       miGestor.getNombreDeArchivo();
    }

    @Test(expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEspacioEnBlanco() {
        String args[] = {"ma ana.md", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        miGestor.getNombreDeArchivo();
    }

    @Test(expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConBarraDesplazada() {
        String args[] = {"ma/ana.md", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        miGestor.getNombreDeArchivo();
    }

    @Test(expected = NombreDeArchivoIncorrectoException.class)
    public void recibeNombreConAcento() {
        String args[] = {"Camión.md", "--mode=no-output"};
        GestorDeArgumentos miGestor = new GestorDeArgumentos(args);
        miGestor.getNombreDeArchivo();
    }
}
