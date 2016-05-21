package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubtituloTest {

    @Test
    public void muestraSubtituloEntrante(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen");
        String subTituloEntrada = unSubTitulo.getEntrada();

        Assert.assertEquals("## Hay 2 imputados por el crimen", subTituloEntrada);
    }

    @Test
    public void muestraSubtituloTransformadoSalida(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen");
        String subtituloSalida = unSubTitulo.getSalida();

        Assert.assertEquals("<h2>Hay 2 imputados por el crimen</h2>", subtituloSalida);
    }

}
