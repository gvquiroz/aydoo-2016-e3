package ar.edu.untref.aydoo;


public abstract class Elemento {

    private String entrada;
    private String salida;

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
