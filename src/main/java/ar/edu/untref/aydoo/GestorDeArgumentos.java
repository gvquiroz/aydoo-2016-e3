package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Velonter on 5/27/2016.
 */
public class GestorDeArgumentos {


    private ProcesadorDeArgumentos miProcesador;

    public GestorDeArgumentos(String[] args) {
        Opcion nombreDelArchivo = new Opcion();
        nombreDelArchivo.setNombreDelParametro("parametroVacio");
        Opcion modo = new Opcion();
        modo.setNombreDelParametro("--mode");
        String valores[] = {"default", "no-output"};
        modo.setValoresAdmitidos(valores);
        modo.setValorDefault("default");
        Opcion output = new Opcion();
        output.setNombreDelParametro("--output");
        List<Opcion> listaDeOpciones = new LinkedList<>();
        listaDeOpciones.add(output);
        listaDeOpciones.add(modo);
        listaDeOpciones.add(nombreDelArchivo);
        this.miProcesador = new ProcesadorDeArgumentos(args, listaDeOpciones);
    }

    public String getNombreDeArchivo() {
        String nombreDelArchivo = this.miProcesador.getContenido("parametroVacio");
        if (    nombreDelArchivo.toLowerCase().contains("ñ") ||
                nombreDelArchivo.contains(" ") ||
                nombreDelArchivo.contains("/") ||
                Pattern.matches(".*[áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜ].*", nombreDelArchivo)) {
            throw new NombreDeArchivoIncorrectoException();
        }
        return nombreDelArchivo;
    }

    public String getModo() {
        return this.miProcesador.getContenido("--mode");
    }

    public String getContenidoDeOutput() {
        return this.miProcesador.getContenido("--output");
    }

    public String getNombreDeCarpeta() {

        String nombreDeCarpeta = this.getNombreDeArchivo();

        if (this.getContenidoDeOutput() != null) {
            nombreDeCarpeta = this.getContenidoDeOutput();
        }

        if (nombreDeCarpeta.contains(".md")) {
            nombreDeCarpeta = nombreDeCarpeta.split(".md")[0];
        }
        return nombreDeCarpeta;
    }

}
