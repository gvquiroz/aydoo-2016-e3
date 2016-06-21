package ar.edu.untref.aydoo.conversion;

import ar.edu.untref.aydoo.dominio.Lista;
import ar.edu.untref.aydoo.dominio.Seccion;

/**
 * Created by Velonter on 6/20/2016.
 */
public class ObservadorDeElemento {
	private Seccion ultimaSeccion = null;
	private Lista ultimaLista = null;

	public void setUltimaSeccion(Seccion seccion) {
		this.ultimaSeccion = seccion;
	}

	public Seccion getUltimaSeccion() {
		return this.ultimaSeccion;
	}

	public void setUltimaLista(Lista item) {
		this.ultimaLista = item;
	}

	public Lista getUltimaLista() {
		return this.ultimaLista;
	}

}
