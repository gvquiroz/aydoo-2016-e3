package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public class Imagen extends Elemento {
	@Override
	public String salidaHtml() {
		return "<img src= " + getContenido() + " />\n";
	}
	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver) {
		if(entradaMD.startsWith("i:")){
			miObserver.setUltimaLista(null);
			Imagen imagen = new Imagen();
			String contenido = entradaMD.replace("i:", "");
			imagen.setContenido(contenido);
			return imagen;
		}
		return null;
	}
}