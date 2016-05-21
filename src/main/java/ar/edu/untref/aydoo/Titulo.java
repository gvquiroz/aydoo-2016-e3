package ar.edu.untref.aydoo;

public class Titulo extends Elemento {

    public Titulo(String titulo) {

        this.setEntrada(titulo);

    }

    public String getSalida(){

        //<h1>un titulo</h1>

        String titulo = this.getEntrada();
        titulo = titulo.substring(2);
        String salida;
        salida = "<h1>"+titulo+"</h1>";

        return salida;

    }

}
