package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

    @Test
    public void muestraTituloEntrante(){

        Titulo unTitulo = new Titulo("# Buenos Dias");
        String tituloEntrada = unTitulo.getEntrada();

        Assert.assertEquals("# Buenos Dias", tituloEntrada);
    }

    @Test
    public void muestralTituloTransformadoSalida(){

        Titulo unTitulo = new Titulo("# Buenos Dias");
        String tituloSalida = unTitulo.getSalida();

        Assert.assertEquals("<h1>Buenos Dias</h1>", tituloSalida);
    }

}