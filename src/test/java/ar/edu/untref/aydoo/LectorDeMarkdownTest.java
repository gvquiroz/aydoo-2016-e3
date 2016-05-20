package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdownTest {

    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void miArchivoContieneUnaEnie() throws IOException {
        String nombreDeArchivo = "mañana.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void miArchivoContieneUnaEnieMayuscula() throws IOException {
        String nombreDeArchivo = "maÑana.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void nombreDeArchivoContieneEspaciosEnBlanco() throws IOException {
        String nombreDeArchivo = "mi presentacion";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);

    }
    @Test (expected = NombreDeArchivoIncorrectoException.class)
    public void nombreDeArchivoContieneBarraDesplazada() throws IOException {
        String nombreDeArchivo = "archivo/barra.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }
}
