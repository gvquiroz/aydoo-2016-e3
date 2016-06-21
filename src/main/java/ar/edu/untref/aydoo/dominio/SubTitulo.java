package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public class SubTitulo extends Elemento{
	
	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver){
		if(entradaMD.startsWith("## ")){
			miObserver.setUltimaLista(null);
			SubTitulo subTitulo = new SubTitulo();
			String contenido = entradaMD.replace("## ", "");
			subTitulo.setContenido(contenido);
			return subTitulo;
		}
		return null;
	}

	@Override
	public String salidaHtml() {
		return "<h2>" + getContenido() + "</h2>\n";
	}

}
