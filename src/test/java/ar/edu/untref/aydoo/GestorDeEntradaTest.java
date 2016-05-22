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
}
