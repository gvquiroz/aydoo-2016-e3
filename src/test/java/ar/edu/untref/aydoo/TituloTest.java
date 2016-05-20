package ar.edu.untref.aydoo;


import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

    @Test
    public void muestraElContenidoDelTitulo(){

        Titulo unTitulo = new Titulo("# Buenos Dias");
        String contenido = unTitulo.getContenido();

        Assert.assertEquals("# Buenos Dias", contenido);
    }

    @Test
    public void muestraElNuevoContenidoDelTitulo(){

        Titulo unTitulo = new Titulo("# Buenos Dias");
        String nuevoContenido = unTitulo.getNuevoContenido();

        Assert.assertEquals("<h1>Buenos Dias</h1>", nuevoContenido);
    }

}
