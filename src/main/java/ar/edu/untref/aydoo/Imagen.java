package ar.edu.untref.aydoo;


public class Imagen extends Elemento {

    public Imagen(String imagen) {

        this.setEntrada(imagen);

    }

    public String getSalida(){

        //<img src=”imagen.png />

        String entrada = this.getEntrada();
        int barraN = entrada.indexOf("\n");
        String imagenLimpia = entrada.substring(2, barraN);
        String salida;
        salida = "<img src= "+imagenLimpia+" />";

        return salida;

    }
}