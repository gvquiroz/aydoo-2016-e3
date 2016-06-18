package ar.edu.untref.aydoo.dominio;

public class Titulo extends Elemento {

    public Titulo(String titulo) {

        super(titulo);

    }

    public String getSalida(){

        //<h1>un titulo</h1>

        String entrada = this.getEntrada();
        String tituloLimpio = entrada.substring(2, entrada.length()-1);
        String salida;
        salida = "<h1>"+tituloLimpio+"</h1>";

        return salida;

    }

}
