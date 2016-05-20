package ar.edu.untref.aydoo;

public class SubTitulo extends Elemento{

    public SubTitulo(String subTitulo) {

        this.setContenido(subTitulo);

    }

    public String getNuevoContenido(){

        //<h2>un subtitulo</h2>

        String subTitulo = this.getContenido();
        subTitulo = subTitulo.substring(3);
        String nuevoSubTitulo;
        nuevoSubTitulo = "<h2>"+subTitulo+"</h2>";

        return nuevoSubTitulo;

    }

}
