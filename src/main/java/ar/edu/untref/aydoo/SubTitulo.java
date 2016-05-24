package ar.edu.untref.aydoo;

public class SubTitulo extends Elemento{

    public SubTitulo(String subTitulo) {

        this.setEntrada(subTitulo);

    }

    public String getSalida(){

        //<h2>un subtitulo</h2>

        String entrada = this.getEntrada();
        int barraN = entrada.indexOf("\n");
        String subTituloLimpio = entrada.substring(3,barraN);
        String salida;
        salida = "<h2>"+subTituloLimpio+"</h2>";

        return salida;

    }
}
