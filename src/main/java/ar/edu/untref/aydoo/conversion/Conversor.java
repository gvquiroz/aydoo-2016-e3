package ar.edu.untref.aydoo.conversion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Elemento;


public class Conversor {

    private List<Elemento> contenido;

    public Conversor(List<Elemento> contenidoAConvertir) {

        contenido = new LinkedList<Elemento>();
        contenido = contenidoAConvertir;
    }

    public String getConversion() {

        String conversion = "";

        for (Elemento elementoActual : contenido){

            conversion = conversion.concat(elementoActual.getSalida());
        }

        return conversion;
    }
}