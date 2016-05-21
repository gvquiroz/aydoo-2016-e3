package ar.edu.untref.aydoo;


public class Imagen extends Elemento {

    public Imagen(String imagen) {

        this.setEntrada(imagen);

    }

    public String getSalida(){

        //<img src=”imagen.png />

        String imagen = this.getEntrada();
        imagen = imagen.substring(2);
        String salida;
        salida = "<img src= "+imagen+" />";

        return salida;

    }
}
