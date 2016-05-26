package ar.edu.untref.aydoo;

import java.util.regex.Pattern;

/**
 * Created by Velonter on 5/25/2016.
 */
public class ValidadorDeNombreDeArchivo {
    public ValidadorDeNombreDeArchivo (String nombreDeArchivo){
        if (nombreDeArchivo.toLowerCase().contains("ñ") ||
                nombreDeArchivo.contains(" ") ||
                nombreDeArchivo.contains("/") ||
                Pattern.matches(".*[áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ].*", nombreDeArchivo)) {
            throw new NombreDeArchivoIncorrectoException();
        }
    }
}
