package ar.edu.untref.aydoo;

import java.util.Arrays;

/**
 * Created by Velonter on 5/25/2016.
 */
public class Opcion {
    private String nombreDelParametro;
    private String contenidoDelParametro;
    private boolean admiteCualquierValor = true;
    private String valoresAdmitidos[];

    public String getNombreDelParametro() {
        return nombreDelParametro;
    }

    public void setNombreDelParametro(String nombreDelParametro) {
        this.nombreDelParametro = nombreDelParametro;
    }

    public String getContenidoDelParametro() {
        return contenidoDelParametro;
    }

    public void setContenidoDelParametro(String contenidoDelParametro) {
        if(!admiteCualquierValor){
            if (!Arrays.asList(this.valoresAdmitidos).contains(contenidoDelParametro)){
                throw new ArgumentoInvalidoException();
            }
        }
        this.contenidoDelParametro = contenidoDelParametro;
    }

    private void setAdmiteCualquierValor(boolean admite){
        this.admiteCualquierValor = admite;
    }

    public void setValoresAdmitidos(String[] valoresAdmitidos) {
        this.setAdmiteCualquierValor(false);
        this.valoresAdmitidos = valoresAdmitidos;
    }

    public void setValorDefault(String valorDefault){
        this.setContenidoDelParametro(valorDefault);
    }
}
