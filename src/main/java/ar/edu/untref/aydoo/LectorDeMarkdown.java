package ar.edu.untref.aydoo;

import java.io.File;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdown {

    private File archivoDeEntrada;

    public LectorDeMarkdown(String nombreDeArchivo) {
        this.archivoDeEntrada = new File(nombreDeArchivo);
        if (!this.archivoDeEntrada.exists()){
            throw new ArchivoNoEncontradoException();
        }
    }
}
