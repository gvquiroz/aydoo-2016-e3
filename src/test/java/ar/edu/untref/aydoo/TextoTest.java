package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Texto;

public class TextoTest {

	@Test
	public void muestraTituloEntrante() {

		Texto texto = new Texto("Buenos Dias\n");
		String textoEntrada = texto.getEntrada();

		Assert.assertEquals("Buenos Dias\n", textoEntrada);
	}

	@Test
	public void muestralTextoTransformadoSalida() {

		Texto unTitulo = new Texto("Buenos Dias\n");
		String textoSalida = unTitulo.getSalida();

		Assert.assertEquals("Buenos Dias", textoSalida);
	}
}
