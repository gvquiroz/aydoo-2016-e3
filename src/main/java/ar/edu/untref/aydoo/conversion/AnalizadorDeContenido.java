package ar.edu.untref.aydoo.conversion;

import java.util.LinkedList;
import java.util.List;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Lista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Texto;
import ar.edu.untref.aydoo.dominio.Titulo;

public class AnalizadorDeContenido {

	private List<Elemento> elementos;
	private List<String> contenidoPorLineas;

	public AnalizadorDeContenido(String contenido) {

		this.contenidoPorLineas = new LinkedList<String>();

		this.separarLineasContenido(contenido);

		this.elementos = new LinkedList<Elemento>();

	}

	public void analizarContenido() {

		String comienzoDeLinea;
		String comienzoLineaAnterior = null;
		String comienzoLineaSiguiente;

		Seccion unaSeccion = null;
		Lista unaLista = null;

		for (int i = 0; i < this.contenidoPorLineas.size(); i++) {

			comienzoDeLinea = this.contenidoPorLineas.get(i).substring(0, 1);

			if (i + 1 < this.contenidoPorLineas.size()) {
				comienzoLineaSiguiente = this.contenidoPorLineas.get(i + 1).substring(0, 1);
			} else {
				comienzoLineaSiguiente = "";
			}

			if (comienzoDeLinea.equals("-")) {
				unaSeccion = new Seccion("");

			} else {

				switch (comienzoDeLinea) {

				case "#":
					if (this.contenidoPorLineas.get(i).startsWith("# ")) {
						Titulo unTitulo = new Titulo(this.contenidoPorLineas.get(i));
						unaSeccion.agregarElemento(unTitulo);
					} else if (this.contenidoPorLineas.get(i).startsWith("##")) {
						SubTitulo unSubTitulo = new SubTitulo(this.contenidoPorLineas.get(i));
						unaSeccion.agregarElemento(unSubTitulo);
					}
					break;

				case "i":
					Imagen unaImagen = new Imagen(this.contenidoPorLineas.get(i));
					unaSeccion.agregarElemento(unaImagen);
					break;

				case "*":
					if (!comienzoDeLinea.equals(comienzoLineaAnterior)) {
						unaLista = new Lista(this.contenidoPorLineas.get(i));
					} else {
						unaLista.agregarItem(this.contenidoPorLineas.get(i));
					}
					if ((!comienzoLineaSiguiente.equals(comienzoDeLinea))) {
						unaSeccion.agregarElemento(unaLista);
					}
					break;
				default:
					Texto unTexto = new Texto(this.contenidoPorLineas.get(i));
					unaSeccion.agregarElemento(unTexto);
					break;

				}
				comienzoLineaAnterior = comienzoDeLinea;

				if ((comienzoLineaSiguiente.equals("-")) || (i + 1 == this.contenidoPorLineas.size())) {
					this.elementos.add(unaSeccion);
				}
			}
		}
	}

	private void separarLineasContenido(String contenido) {

		for (int i = 0; i < contenido.length(); i++) {

			int j = contenido.indexOf("\n", i) + 1;
			this.contenidoPorLineas.add(contenido.substring(i, j));
			i = j - 1;
		}

	}

	@SuppressWarnings("rawtypes")
	public List obtenerContenidoAnalizado() {

		return this.elementos;
	}
}
