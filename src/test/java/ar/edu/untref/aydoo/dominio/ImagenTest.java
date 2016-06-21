package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.conversion.Conversor;
import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;
import ar.edu.untref.aydoo.dominio.Imagen;

public class ImagenTest {

	@Test
	public void muestraContenidoDeImagen() {

		Imagen unaImagen = new Imagen();

		unaImagen.setContenido("fotoImputado.png");

		Assert.assertEquals("fotoImputado.png", unaImagen.getContenido());
	}

	@Test
	public void muestraImagenEntrante() {

		Imagen unaImagen = new Imagen();

		unaImagen.setContenido("fotoImputado.png");

		Assert.assertEquals("<img src= fotoImputado.png />\n", unaImagen.salidaHtml());
	}

	@Test
	public void convertirImagen() {
		Conversor conversor = new Conversor();
		ObservadorDeElemento miObserver = new ObservadorDeElemento();
		String entradaMD = "i:fotoImputado.png";
		String salidaHtml = conversor.convertirAHtml(entradaMD, miObserver);

		Assert.assertEquals("<img src= fotoImputado.png />\n", salidaHtml);
	}
}
