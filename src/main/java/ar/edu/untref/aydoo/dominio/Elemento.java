package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public abstract class Elemento {
	
	private String contenido;
	
	public abstract String salidaHtml();

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public abstract Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver);

}
