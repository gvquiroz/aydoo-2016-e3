package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Lista extends Elemento{

    public Lista(String item) {

        this.setEntrada(item);

    }

    public String getSalida() {

        /*<ul>
        <li>un item de una lista</li>
        <li>otro item de una lista</li>
        </ul>
        */
        String entrada = this.getEntrada();
        String [] listaDeItems = entrada.split("\\*");
        String lista = "";

        for(int i = 1; i < listaDeItems.length; i++){

            lista = lista.concat("<li>" + listaDeItems[i] + "</li>" + "\n");
        }

        String salida;
        salida = "<ul>" + "\n" + lista + "</ul>\n";
        return salida;
    }

    public void agregarItem(String unItem) {

        this.setEntrada(this.getEntrada().concat(unItem));
    }
}
