package ar.edu.untref.aydoo;

import org.junit.Test;

/**
 * Created by Velonter on 5/25/2016.
 */
public class ValidadorDeNombreTest {

	@Test(expected = NombreDeArchivoIncorrectoException.class)
	public void pasoUnNombreConEnie() {
		@SuppressWarnings("unused")
		ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("mipresñentacion.md");
	}

	@Test(expected = NombreDeArchivoIncorrectoException.class)
	public void pasoUnNombreConEnieMayuscula() {
		@SuppressWarnings("unused")
		ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("maÑana.md");
	}

	@Test(expected = NombreDeArchivoIncorrectoException.class)
	public void pasoUnNombreConEspacioEnBlanco() {
		@SuppressWarnings("unused")
		ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("ma ana.md");
	}

	@Test(expected = NombreDeArchivoIncorrectoException.class)
	public void pasoUnNombreConBarraDesplazada() {
		@SuppressWarnings("unused")
		ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("ma/ana.md");
	}

	@Test(expected = NombreDeArchivoIncorrectoException.class)
	public void recibeNombreConAcento() {
		@SuppressWarnings("unused")
		ValidadorDeNombreDeArchivo miValidador = new ValidadorDeNombreDeArchivo("Camión.md");
	}
}
