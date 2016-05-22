package ar.edu.untref.aydoo;

/**
 * Created by Velonter on 5/22/2016.
 */
public class GestorDeEntrada {

    private String nombreDeCarpetaDeSalida = "";
    // Por si no ingresa modo inicializa en default
    private String modo = "default";

    public GestorDeEntrada (String argumentos[]){
        for (String datos : argumentos) {

            if (datos.contains("--mode=")) {
                String[] descomposicionDeModo = datos.split("=");
                this.modo = descomposicionDeModo[1];
            }
            if (datos.contains("--output=")){
                String[] descomposicionDelOutput = datos.split("=");
                this.nombreDeCarpetaDeSalida = descomposicionDelOutput[1];
            }
        }
    }

    public String getModo() {
        return modo;
    }
    public String getNombreDeCarpetaDeSalida(){
        return this.nombreDeCarpetaDeSalida;
    }
}