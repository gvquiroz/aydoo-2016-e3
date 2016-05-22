package ar.edu.untref.aydoo;

import org.junit.Test;

/**
 * Created by Velonter on 5/22/2016.
 */
public class GestorDeEntradaTest {
    @Test
    public void recibeModoDefault(){
        String args[] = { " --mode=default" };

        GestorDeEntrada interfaz = new GestorDeEntrada(args);
        interfaz.getModo();
    }
}
