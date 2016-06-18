package ar.edu.untref.aydoo.dominio;


import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Titulo;

public class TituloTest {

    @Test
    public void muestraTituloEntrante(){

        Titulo unTitulo = new Titulo("# Buenos Dias\n");
        String tituloEntrada = unTitulo.getEntrada();

        Assert.assertEquals("# Buenos Dias\n", tituloEntrada);
    }

    @Test
    public void muestralTituloTransformadoSalida(){

        Titulo unTitulo = new Titulo("# Buenos Dias\n");
        String tituloSalida = unTitulo.getSalida();

        Assert.assertEquals("<h1>Buenos Dias</h1>", tituloSalida);
    }

}