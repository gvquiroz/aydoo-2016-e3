package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

public class Seccion extends Elemento {

	private List<Elemento> elementos;

	public Seccion(String contenidoSeccion) {
		this.setEntrada(contenidoSeccion);
		this.elementos = new LinkedList<Elemento>();
	}

	public String getSalida() {
		String resultado = "";

		for (Elemento elementoActual : elementos) {
			resultado = resultado + elementoActual.getSalida();
		}

		return "<section>" + resultado + "</section>";
	}

	public void agregarElemento(Elemento unElemento) {
		this.elementos.add(unElemento);
	}

}
