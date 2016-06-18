package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Imagen;

public class ImagenTest {

    @Test
    public void muestraImagenEntrante(){

        Imagen unaImagen = new Imagen("i:fotoImputado.png\n");
        String imagenEntrada = unaImagen.getEntrada();

        Assert.assertEquals("i:fotoImputado.png\n", imagenEntrada);
    }

    @Test
    public void muestraImagenTransformadaSalida(){

        Imagen unaImagen = new Imagen("i:fotoImputado.png\n");
        String imagenSalida = unaImagen.getSalida();

        Assert.assertEquals("<img src= fotoImputado.png />", imagenSalida);
    }

}
