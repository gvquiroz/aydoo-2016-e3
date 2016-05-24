package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {

    @Test
    public void muestraListaEntrante1Item() {

        Lista unaLista = new Lista("*2 papas");
        String listaEntrada = unaLista.getEntrada();

        Assert.assertEquals("*2 papas", listaEntrada);
    }

    @Test
    public void muestraListaEntrante2Items() {

        Lista unaLista = new Lista("*2 papas");
        unaLista.agregarItem("*5 tomates");
        String listaEntrada = unaLista.getEntrada();

        Assert.assertEquals("*2 papas*5 tomates", listaEntrada);
    }

    @Test
    public void muestraLista1ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n</ul>\n", listaSalida);
    }



    @Test
    public void muestraLista2ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas");
        unaLista.agregarItem("*4 cebollas");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n<li>4 cebollas</li>\n</ul>\n", listaSalida);
    }

    @Test
    public void muestraLista3ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas");
        unaLista.agregarItem("*4 cebollas");
        unaLista.agregarItem("2 choclos");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n<li>4 cebollas</li>\n<li>2 choclos</li>\n</ul>\n", listaSalida);
    }
}
