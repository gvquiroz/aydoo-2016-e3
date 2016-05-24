package ar.edu.untref.aydoo;

import java.util.regex.Pattern;

/**
 * Created by Velonter on 5/22/2016.
 */
public class GestorDeEntrada {

    private String nombreDeArchivo;
    private String nombreDeCarpetaDeSalida = "default";
    // Por si no ingresa modo inicializa en default
    private String modo = "default";

    public GestorDeEntrada (String argumentos[]){
        for (String datos : argumentos) {
            if (datos.contains("--mode=")) {
                String[] descomposicionDeModo = datos.split("=");
                this.modo = descomposicionDeModo[1];
                this.validadorDeModo(this.modo);
            } else if (datos.contains("--output=")){
                String[] descomposicionDelOutput = datos.split("=");
                this.nombreDeCarpetaDeSalida = descomposicionDelOutput[1];
            } else {
                this.nombreDeArchivo = datos;
                this.validadorDeNombreDeEntrada(this.nombreDeArchivo);
                this.generarNombreDeCarpeta();
            }
        }
    }

    public String getModo() {
        return modo;
    }
    public String getNombreDeCarpetaDeSalida(){
        return this.nombreDeCarpetaDeSalida;
    }

    public String getNombreDeArchivo(){
        return this.nombreDeArchivo;
    }


    private void validadorDeNombreDeEntrada(String nombreDeArchivo) {
        if (nombreDeArchivo.toLowerCase().contains("ñ") ||
                nombreDeArchivo.contains(" ") ||
                nombreDeArchivo.contains("/") ||
                Pattern.matches(".*[áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ].*", nombreDeArchivo)) {
            throw new NombreDeArchivoIncorrectoException();
        }
    }
    private void validadorDeModo(String mode){
        if (!(mode.equals("default") || mode.equals("no-output"))){
            throw new ArgumentoInvalidoException();
        }
    }
    private void generarNombreDeCarpeta(){
        if (this.nombreDeCarpetaDeSalida.equals("default")){
            this.nombreDeCarpetaDeSalida = this.nombreDeArchivo;
            if (this.nombreDeCarpetaDeSalida.contains(".")){
                String[] descomposicionDelNombreDeLaCarpeta = this.nombreDeCarpetaDeSalida.split("\\.md");
                this.nombreDeCarpetaDeSalida = descomposicionDelNombreDeLaCarpeta[0];
            }
        }
    }
}
