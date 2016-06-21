package ar.edu.untref.aydoo.dominio;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

/**
 * Created by Velonter on 6/20/2016.
 */
public class Lista extends Elemento {

	private List<String> listaDeContenido = new LinkedList<>();

	/*
	 * Le consulta al Observador si ya hay una lista siendo utilizada como
	 * elemento anterior, si es asi solo agrega contenido, si no crea una clase
	 * Item con su contenido correspondiente
	 */

	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver) {
		if (entradaMD.startsWith("*")) {
			if (miObserver.getUltimaLista() == null) {
				miObserver.setUltimaLista(new Lista());
				String contenido = entradaMD.replace("*", "");
				miObserver.getUltimaLista().agregarContenidoDeItem(contenido);
			} else {
				String contenido = entradaMD.replace("*", "");
				miObserver.getUltimaLista().agregarContenidoDeItem(contenido);
			}
			return miObserver.getUltimaLista();
		}
		return null;
	}

	@Override
	public String salidaHtml() {
		String resultado = "";
		resultado += "<ul>\n";
		for (String contenidoDeItem : this.listaDeContenido) {
			resultado += "<li>" + contenidoDeItem + "</li>\n";
		}
		resultado += "</ul>\n";
		this.setContenido(resultado);
		return getContenido();
	}

	public void agregarContenidoDeItem(String nuevoContenido) {
		this.listaDeContenido.add(nuevoContenido);
	}
}