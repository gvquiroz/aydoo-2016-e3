package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Lista extends Elemento{

    public Lista(String item) {

        this.setEntrada(item);

    }

    public String getSalida() {

        String lista = this.getEntrada();
        lista = lista.substring(0);
        String salida;
        salida = "<li>"+lista+"</li>"+"\n";

        salida = "<ul>" + "\n" + salida + "</ul>\n";
        return salida;
    }
}
