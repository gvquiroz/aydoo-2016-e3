package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SubtituloTest {

    @Test
    public void muestraSubtituloEntrante(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen\n");
        String subTituloEntrada = unSubTitulo.getEntrada();

        Assert.assertEquals("## Hay 2 imputados por el crimen\n", subTituloEntrada);
    }

    @Test
    public void muestraSubtituloTransformadoSalida(){

        SubTitulo unSubTitulo = new SubTitulo("## Hay 2 imputados por el crimen\n");
        String subtituloSalida = unSubTitulo.getSalida();

        Assert.assertEquals("<h2>Hay 2 imputados por el crimen</h2>", subtituloSalida);
    }

}
