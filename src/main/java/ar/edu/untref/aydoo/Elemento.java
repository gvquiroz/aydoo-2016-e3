package ar.edu.untref.aydoo;


public abstract class Elemento {

    private String entrada;
    private String salida;

    public Elemento (String contenido){
        setEntrada(contenido);
    }

    public void setEntrada(String entrada){
        this.entrada = entrada;
    }

    public String getEntrada(){
        return this.entrada;
    }

    public String getSalida(){
        return this.salida;
    }

}
