package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucas on 23/05/16.
 */
public class ListaTest {

    @Test
    public void muestraListaEntrante1Item() {

        Lista unaLista = new Lista("*2 papas");
        String listaEntrada = unaLista.getEntrada();

        Assert.assertEquals("*2 papas", listaEntrada);
    }

    @Test
    public void muestraLista1ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>*2 papas</li>\n</ul>\n", listaSalida);
    }
}
