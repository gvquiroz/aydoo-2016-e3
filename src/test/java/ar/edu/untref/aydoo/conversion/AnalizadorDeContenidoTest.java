package ar.edu.untref.aydoo.conversion;

import org.junit.Assert;
import org.junit.Test;

public class AnalizadorDeContenidoTest {

	@Test
	public void recibeTitulo() {

		String contenido = "---\n# unTitulo\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
		String cadenaHtml = analizador.analizarContenido();

		Assert.assertEquals("<section>\n<h1>unTitulo</h1>\n</section>\n", cadenaHtml);
	}

	@Test
	public void recibeSubtitulo() {

		String contenido = "--- \n## unSubTitulo\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
		String cadenaHtml = analizador.analizarContenido();

		Assert.assertEquals("<section>\n<h2>unSubTitulo</h2>\n</section>\n", cadenaHtml);
	}

	@Test
	public void recibeImagen() {
		String contenido = "--- \ni:imagen.png\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
		String cadenaHtml = analizador.analizarContenido();
		Assert.assertEquals("<section>\n<img src= imagen.png />\n</section>\n", cadenaHtml);
	}
	
	@Test
	public void recibeCasoBase() {
		String contenido = "---\n# slide1 :titulo 1\n---\n## slide2: titulo 2\n---\nslide 3\n# titulo 1\n## titulo 2\n\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
		String cadenaHtml = analizador.analizarContenido();
		String resultado = "<section>\n" +
				"<h1>slide1 :titulo 1</h1>\n" +
				"</section>\n" +
				"<section>\n" +
				"<h2>slide2: titulo 2</h2>\n" +
				"</section>\n" +
				"<section>\n" +
				"slide 3<h1>titulo 1</h1>\n" +
				"<h2>titulo 2</h2>\n" +
				"</section>\n";
		Assert.assertEquals(resultado, cadenaHtml);
	}

	@Test
	public void recibeTituloYSubTitulo() {

		String contenido = "---\n# unTitulo\n## unSubTitulo\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
		String cadenaHtml = analizador.analizarContenido();

		Assert.assertEquals("<section>\n<h1>unTitulo</h1>\n" +
				"<h2>unSubTitulo</h2>\n</section>\n", cadenaHtml);
	}


}