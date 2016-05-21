package ar.edu.untref.aydoo;

public class SubTitulo extends Elemento{

    public SubTitulo(String subTitulo) {

        this.setEntrada(subTitulo);

    }

    public String getSalida(){

        //<h2>un subtitulo</h2>

        String subTitulo = this.getEntrada();
        subTitulo = subTitulo.substring(3);
        String salida;
        salida = "<h2>"+subTitulo+"</h2>";

        return salida;

    }

}
