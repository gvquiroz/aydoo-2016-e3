package ar.edu.untref.aydoo.dominio;

public class Lista extends Elemento{

    public Lista(String contenido) {
        super(contenido);
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
        String itemLimpio;

        for(int i = 1; i < listaDeItems.length; i++){

            itemLimpio = listaDeItems[i].substring(0, listaDeItems[i].length()-1);
            lista = lista.concat("<li>" + itemLimpio + "</li>" + "\n");
        }

        String salida;
        salida = "<ul>" + "\n" + lista + "</ul>";
        return salida;
    }

    public void agregarItem(String unItem) {

        super.setEntrada(this.getEntrada().concat(unItem));
    }
}