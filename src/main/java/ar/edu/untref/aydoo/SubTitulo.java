package ar.edu.untref.aydoo;

public class SubTitulo extends Elemento{

    public SubTitulo(String subTitulo) {

        this.setEntrada(subTitulo);

    }

    public String getSalida(){

        //<h2>un subtitulo</h2>

        String entrada = this.getEntrada();
        String subTituloLimpio = entrada.substring(3,entrada.length()-1);
        String salida;
        salida = "<h2>"+subTituloLimpio+"</h2>";

        return salida;

    }
}
