package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ListaTest {

    @Test
    public void muestraListaEntrante1Item() {

        Lista unaLista = new Lista("*2 papas\n");
        String listaEntrada = unaLista.getEntrada();

        Assert.assertEquals("*2 papas\n", listaEntrada);
    }

    @Test
    public void muestraListaEntrante2Items() {

        Lista unaLista = new Lista("*2 papas\n");
        unaLista.agregarItem("*5 tomates\n");
        String listaEntrada = unaLista.getEntrada();

        Assert.assertEquals("*2 papas\n*5 tomates\n", listaEntrada);
    }

    @Test
    public void muestraLista1ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas\n");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n</ul>\n", listaSalida);
    }



    @Test
    public void muestraLista2ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas\n");
        unaLista.agregarItem("*4 cebollas\n");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n<li>4 cebollas</li>\n</ul>\n", listaSalida);
    }

    @Test
    public void muestraLista3ItemTransformadaSalida(){

        Lista unaLista = new Lista("*2 papas\n");
        unaLista.agregarItem("*4 cebollas\n");
        unaLista.agregarItem("*2 choclos\n");
        String listaSalida = unaLista.getSalida();

        Assert.assertEquals("<ul>\n<li>2 papas</li>\n<li>4 cebollas</li>\n<li>2 choclos</li>\n</ul>\n", listaSalida);
    }
}
