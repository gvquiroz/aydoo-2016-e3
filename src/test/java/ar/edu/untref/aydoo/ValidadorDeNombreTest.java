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
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEnieMayuscula(){
        ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("maÑana.md");
    }
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConEspacioEnBlanco(){
        ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("ma ana.md");
    }
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void pasoUnNombreConBarraDesplazada(){
        ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("ma/ana.md");
    }
}
