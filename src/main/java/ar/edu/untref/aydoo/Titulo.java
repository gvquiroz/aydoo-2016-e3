package ar.edu.untref.aydoo;

public class Titulo extends Elemento {

    public Titulo(String titulo) {

        this.setContenido(titulo);

    }

    public String getNuevoContenido(){

        //<h1>un titulo</h1>

        String titulo = this.getContenido();
        titulo = titulo.substring(1);
        String nuevoTitulo;
        nuevoTitulo = "<h1>"+titulo+"</h1>";

        return nuevoTitulo;

    }

}
