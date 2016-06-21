package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.conversion.Conversor;
import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;
import ar.edu.untref.aydoo.dominio.SubTitulo;

public class SubtituloTest {

	@Test
	public void contenidoDelSubtitulo() {

		SubTitulo unSubTitulo = new SubTitulo();
		unSubTitulo.setContenido("subtitulo");

		Assert.assertEquals("subtitulo", unSubTitulo.getContenido());
	}

	@Test
	public void muestraSubtituloEntrante() {

		SubTitulo unSubTitulo = new SubTitulo();
		unSubTitulo.setContenido("subtitulo");

		Assert.assertEquals("<h2>subtitulo</h2>\n", unSubTitulo.salidaHtml());
	}

	@Test
	public void subTituloSeTransfomaASiMismo() {
		Conversor conversor = new Conversor();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();

		String entradaMD = "## SubTitulo1";
		String salidaHtml = conversor.convertirAHtml(entradaMD, miObserver);

		Assert.assertEquals("<h2>SubTitulo1</h2>\n", salidaHtml);
	}

	@Test
	public void subTituloRecibeUnNOSubtitulo() {
		Conversor conversor = new Conversor();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();

		String entradaMD = "# SubTitulo1";
		String salidaHtml = conversor.convertirAHtml(entradaMD, miObserver);

		Assert.assertNotEquals("<h2>SubTitulo1</h2>", salidaHtml);
	}

}
