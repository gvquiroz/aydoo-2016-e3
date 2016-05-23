package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenido {

    private List<Elemento> elementos;
    private List<String> contenidoPorLineas;

    public AnalizadorDeContenido(String contenido){

        this.contenidoPorLineas = new LinkedList<String>();

        this.separarLineasContenido(contenido);

        this.elementos = new LinkedList<Elemento>();

    }

    public void analizarContenido(){

        for (String contenidoActual : this.contenidoPorLineas){

            String comienzo = contenidoActual.substring(0,1);
            switch(comienzo){

                case "#":
                    if (contenidoActual.startsWith("# ")){
                        Titulo unTitulo = new Titulo (contenidoActual);
                        this.elementos.add(unTitulo);
                    }
                    else if(contenidoActual.startsWith("##")){
                        SubTitulo unSubTitulo = new SubTitulo (contenidoActual);
                        this.elementos.add(unSubTitulo);
                    }
                    break;

                case "i":
                    Imagen unaImagen = new Imagen (contenidoActual);
                    this.elementos.add(unaImagen);
                    break;
                
            }
        }


    }

    private void separarLineasContenido(String contenido){

        for(int i = 0; i < contenido.length(); i++){

            int j = contenido.indexOf("/n", i) + 2;
            this.contenidoPorLineas.add(contenido.substring(i, j));
            i = j + 1;
        }

    }

    public List obtenerContenidoAnalizado(){

        return this.elementos;
    }
}
