package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdownTest {

    @SuppressWarnings("unused")
	@Test (expected = NombreDeArchivoIncorrectoException.class)
    public void miArchivoContieneUnaEnie() throws IOException {
        String nombreDeArchivo = "mañana.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

    @SuppressWarnings("unused")
	@Test (expected = NombreDeArchivoIncorrectoException.class)
    public void miArchivoContieneUnaEnieMayuscula() throws IOException {
        String nombreDeArchivo = "maÑana.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

    @SuppressWarnings("unused")
	@Test (expected = NombreDeArchivoIncorrectoException.class)
    public void nombreDeArchivoContieneEspaciosEnBlanco() throws IOException {
        String nombreDeArchivo = "mi presentacion";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);

    }
    @SuppressWarnings("unused")
	@Test (expected = NombreDeArchivoIncorrectoException.class)
    public void nombreDeArchivoContieneBarraDesplazada() throws IOException {
        String nombreDeArchivo = "archivo/barra.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

    @SuppressWarnings("unused")
	@Test (expected = NombreDeArchivoIncorrectoException.class)
    public void nombreDeArchivoContieneAcento() throws IOException {
        String nombreDeArchivo = "Camión.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }
    
    @Test
    public void leerArchivo() throws FileNotFoundException, IOException{
    	String nombreDeArchivo = "mipresentacion1.md";
    	LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    	lector.leerArchivo(nombreDeArchivo);
    }
}
