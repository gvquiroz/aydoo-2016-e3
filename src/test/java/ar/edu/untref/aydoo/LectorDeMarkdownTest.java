package ar.edu.untref.aydoo;

import org.junit.Test;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdownTest {

    @Test (expected = ArchivoNoEncontradoException.class)
    public void noEncuentroMiArchivoMarkdown(){
        String nombreDeArchivo = "markdownTest.md";
        LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    }

}
