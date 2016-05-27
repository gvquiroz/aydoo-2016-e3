package ar.edu.untref.aydoo;


public class Imagen extends Elemento {

    public Imagen(String imagen) {

        super(imagen);

    }

    public String getSalida(){

        //<img src=”imagen.png />

        String entrada = this.getEntrada();
        String imagenLimpia = entrada.substring(2, entrada.length()-1);
        String salida;
        salida = "<img src= "+imagenLimpia+" />";

        return salida;

    }
}