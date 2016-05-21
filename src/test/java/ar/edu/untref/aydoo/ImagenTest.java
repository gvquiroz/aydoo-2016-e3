package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class ImagenTest {

    @Test
    public void muestraImagenEntrante(){

        Imagen unaImagen = new Imagen("i:fotoImputado.png");
        String imagenEntrada = unaImagen.getEntrada();

        Assert.assertEquals("i:fotoImputado.png", imagenEntrada);
    }

    @Test
    public void muestraImagenTransformadaSalida(){

        Imagen unaImagen = new Imagen("i:fotoImputado.png");
        String imagenSalida = unaImagen.getSalida();

        Assert.assertEquals("<img src= fotoImputado.png />", imagenSalida);
    }

}
