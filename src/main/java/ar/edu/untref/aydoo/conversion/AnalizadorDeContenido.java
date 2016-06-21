package ar.edu.untref.aydoo.conversion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Seccion;

public class AnalizadorDeContenido {
	private List<String> contenidoPorLineas;
	private List<Seccion> conjuntoDeSecciones = new LinkedList<>();

	public AnalizadorDeContenido(String contenido) {
		this.contenidoPorLineas = new LinkedList<String>();
		this.separarLineasContenido(contenido);
	}

	public String analizarContenido() {
		FabricaDeElementos fabrica = new FabricaDeElementos();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();
		Seccion ultimaSeccion = null;
		for (String lineaActual : contenidoPorLineas) {
			Elemento elemento = fabrica.crearConMD(lineaActual, miObserver);
			ultimaSeccion = miObserver.getUltimaSeccion();
			ultimaSeccion.agregarElemento(elemento);
			if (!conjuntoDeSecciones.contains(ultimaSeccion)) {
				this.conjuntoDeSecciones.add(ultimaSeccion);
			}
		}
		String resultado = "";
		for (Seccion seccionActual : this.conjuntoDeSecciones) {
			resultado += seccionActual.salidaHtml();
		}
		return resultado;
	}

	public void separarLineasContenido(String contenido) {
		String[] lines = contenido.split("\\s*\\r?\\n\\s*");
		for (String line : lines) {
			this.contenidoPorLineas.add(line);
		}
	}
}
