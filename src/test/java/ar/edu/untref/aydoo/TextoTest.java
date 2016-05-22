package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoTest {

    @Test
    public void muestraTituloEntrante(){

        Texto texto = new Texto("Buenos Dias");
        String textoEntrada = texto.getEntrada();

        Assert.assertEquals("Buenos Dias", textoEntrada);
    }

}
