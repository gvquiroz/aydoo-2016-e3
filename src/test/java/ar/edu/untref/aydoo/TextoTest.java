package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

public class TextoTest {

	@Test
	public void muestraTituloEntrante() {

		Texto texto = new Texto("Buenos Dias");
		String textoEntrada = texto.getEntrada();

		Assert.assertEquals("Buenos Dias", textoEntrada);
	}

	@Test
	public void muestralTextoTransformadoSalida() {

		Texto unTitulo = new Texto("Buenos Dias");
		String textoSalida = unTitulo.getSalida();

		Assert.assertEquals("Buenos Dias", textoSalida);
	}
}
