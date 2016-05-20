package ar.edu.untref.aydoo;

import java.io.File;
import java.util.regex.Pattern;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdown {

    private File archivoDeEntrada;

    public LectorDeMarkdown(String nombreDeArchivo) {
        this.chequeoDeNombreDeArchivoDeEntrada(nombreDeArchivo);
        this.archivoDeEntrada = new File(nombreDeArchivo);
    }

    public void chequeoDeNombreDeArchivoDeEntrada(String nombreDeArchivo) {

        if (nombreDeArchivo.toLowerCase().contains("ñ")){
            throw new NombreDeArchivoIncorrectoException();
        }

        if (nombreDeArchivo.contains(" ")){
            throw new NombreDeArchivoIncorrectoException();
        }
        if (nombreDeArchivo.contains("/")){
            throw new NombreDeArchivoIncorrectoException();
        }
        // Ver si se puede cambiar por una mejor implementacion
        if (Pattern.matches(".*[áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ].*", nombreDeArchivo)){
            throw new NombreDeArchivoIncorrectoException();
        }

    }
}
