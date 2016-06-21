package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.conversion.Conversor;
import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;
import ar.edu.untref.aydoo.dominio.Texto;

public class TextoTest {

	@Test
	public void muestraContenidoDelTexto() {

		Texto texto = new Texto();

		texto.setContenido("Buenos Dias\n");

		Assert.assertEquals("Buenos Dias\n", texto.getContenido());
	}
	
	@Test
	public void textoTranformacionHtml() {

		Texto texto = new Texto();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();
		
		texto.setContenido("Buenos Dias\n");

		Assert.assertEquals("Buenos Dias\n", texto.salidaHtml());
	}
	
	@Test
	public void muestraTituloEntrante() {

		Conversor conversor = new Conversor();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();
		String entradaMD = "Buenos Dias\n";
		String salidaHtml = conversor.convertirAHtml(entradaMD,miObserver);

		Assert.assertEquals("Buenos Dias\n", salidaHtml);
	}

}
