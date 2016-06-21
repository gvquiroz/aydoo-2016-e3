package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public class Titulo extends Elemento {


	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver){
		if(entradaMD.startsWith("# ")){
			miObserver.setUltimaLista(null);
			Titulo titulo = new Titulo();
			String contenido = entradaMD.replace("# ", "");
			titulo.setContenido(contenido);
			return titulo;
		}
		return null;
	}

	@Override
	public String salidaHtml() {
		return "<h1>" + getContenido() + "</h1>\n";
	}

}
