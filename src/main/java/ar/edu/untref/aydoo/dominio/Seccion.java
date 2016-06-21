package ar.edu.untref.aydoo.dominio;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;

public class Seccion extends Elemento {

	private List<Elemento> elementos;

	public Seccion() {
		this.elementos = new LinkedList<Elemento>();
	}

	@Override
	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver) {
		if (entradaMD.startsWith("---")) {
			miObserver.setUltimaLista(null);
			Seccion seccion = new Seccion();
			String contenido = entradaMD.replace("---", "");
			seccion.setContenido(contenido);
			miObserver.setUltimaSeccion(seccion);
			return seccion;
		}
		return null;
	}

	@Override
	public String salidaHtml() {
		String resultado = "";
		for (Elemento elementoActual : elementos) {
			resultado += elementoActual.salidaHtml();
		}
		this.setContenido(resultado);
		return "<section>\n" + getContenido() + "</section>\n";
	}

	public void agregarElemento(Elemento unElemento) {
		if (unElemento != this && !this.elementos.contains(unElemento)) {
			this.elementos.add(unElemento);
		}
	}
}
