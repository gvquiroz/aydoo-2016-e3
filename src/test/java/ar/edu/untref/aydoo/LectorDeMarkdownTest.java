package ar.edu.untref.aydoo;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdownTest {
    
    @Test
    public void leerArchivo() throws FileNotFoundException, IOException{
    	String nombreDeArchivo = "template/mipresentacion1.md";
    	LectorDeMarkdown lector = new LectorDeMarkdown(nombreDeArchivo);
    	lector.leerArchivo(nombreDeArchivo);
    }
}
