package ar.edu.untref.aydoo;


public abstract class Elemento {

    private String contenido;
    private String nuevoContenido;

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public String getContenido(){
        return this.contenido;
    }

    public String getNuevoContenido(){
        return this.nuevoContenido;
    }

}
