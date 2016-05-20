package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubtituloTest {

    @Test
    public void muestraElContenidoDelSubtitulo(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen");
        String contenido = unSubTitulo.getContenido();

        Assert.assertEquals("## Hay 2 imputados por el crimen", contenido);
    }

    @Test
    public void muestraElNuevoContenidoDelSubtitulo(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen");
        String nuevoContenido = unSubTitulo.getNuevoContenido();

        Assert.assertEquals("<h2>Hay 2 imputados por el crimen</h2>", nuevoContenido);
    }

}
