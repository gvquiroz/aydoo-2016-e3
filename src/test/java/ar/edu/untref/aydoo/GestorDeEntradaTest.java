package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 5/22/2016.
 */
public class GestorDeEntradaTest {
    @Test
    public void noRecibeModoPorLoQueElModoEsDefault(){
        String args[] = {""};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals(resultado, "default");
    }
    @Test
    public void recibeModoDefault(){
        String args[] = {"--mode=default"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals(resultado, "default");
    }
    @Test
    public void recibeModoNoOutput(){
        String args[] = {"--mode=no-output"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals(resultado, "no-output");
    }

    @Test
    public void recibeModoNoOutputLuegoDelNombreDelArchivo(){
        String args[] = {"mipresentacion.md --mode=no-output"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals(resultado, "no-output");
    }
}
