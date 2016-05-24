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

        String comienzoLineaAnterior = null;

        for (String contenidoActual : this.contenidoPorLineas){

            String comienzoDeLinea = contenidoActual.substring(0,1);

            switch(comienzoDeLinea){

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

                case "*":
                    if(!comienzoDeLinea.equals(comienzoLineaAnterior) ){
                        Lista unaLista = new Lista (contenidoActual);
                        this.elementos.add(unaLista);
                    }
                    else {
                        Lista unaLista;
                        unaLista = (Lista) this.elementos.get(this.elementos.size()-1);
                        unaLista.agregarItem(contenidoActual);
                        this.elementos.add(this.elementos.size()-1, unaLista);
                    }
                    break;

            }

            comienzoLineaAnterior = comienzoDeLinea;
        }


    }

    private void separarLineasContenido(String contenido){

        for(int i = 0; i < contenido.length(); i++){

            int j = contenido.indexOf("\n", i) + 1;
            this.contenidoPorLineas.add(contenido.substring(i, j));
            i = j - 1;
        }

    }

    public List obtenerContenidoAnalizado(){

        return this.elementos;
    }
}
