package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public class Texto extends Elemento {

	@Override
	public String salidaHtml() {
		return getContenido();
	}

	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver) {
		miObserver.setUltimaLista(null);
		Texto texto = new Texto();
		texto.setContenido(entradaMD);
		return texto;
	}

}
