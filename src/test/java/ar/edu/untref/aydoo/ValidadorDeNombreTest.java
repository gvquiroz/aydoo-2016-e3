package ar.edu.untref.aydoo;

import org.junit.Test;

/**
 * Created by Velonter on 5/25/2016.
 */
public class ValidadorDeNombreTest {
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEnie(){
        ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("mipresñentacion.md");
    }
}
