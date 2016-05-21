package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class SecionTest {
	
    @Test
    public void muestraSeccionEntrante(){

        Seccion unaSeccion = new Seccion("--- alguna cosa");
        String seccionEntrada = unaSeccion.getEntrada();

        Assert.assertEquals("--- alguna cosa", seccionEntrada);
    }


}
