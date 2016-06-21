package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.conversion.AnalizadorDeContenido;

public class ListaTest {

	@Test
	 public void analizadoConListaTest() {
	  String entradaMD = "--- \n*hola\n";
	  AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);
	  String resultado = analizador.analizarContenido();

	  Assert.assertEquals("<section>\n" +
	    "<ul>\n<li>hola</li>\n</ul>\n" +
	    "</section>\n", resultado);
	 }
	 @Test
	 public void analizadoConListaConDosItems() {
	  String entradaMD = "--- \n*hola\n*hola\n";
	  AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);
	  String resultado = analizador.analizarContenido();

	  Assert.assertEquals("<section>\n" +
	    "<ul>\n<li>hola</li>\n<li>hola</li>\n</ul>\n" +
	    "</section>\n", resultado);
	 }
	@Test
	public void analizadoConListaConTresItems() {
		String entradaMD = "--- \n*hola\n*hola\n*hola\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);
		String resultado = analizador.analizarContenido();

		Assert.assertEquals("<section>\n" +
				"<ul>\n<li>hola</li>\n<li>hola</li>\n<li>hola</li>\n</ul>\n" +
				"</section>\n", resultado);
	}

	 @Test
	 public void analizadoConListaConDosItemsYUnTituloEntreMedio() {
	  String entradaMD = "--- \n*hola\n# Titulo1\n*hola\n";
	  AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);
	  String resultado = analizador.analizarContenido();

	  Assert.assertEquals("<section>\n" +
	    "<ul>\n<li>hola</li>\n</ul>\n<h1>Titulo1</h1>\n<ul>\n<li>hola</li>\n</ul>\n" +
	    "</section>\n", resultado);
	 }
	@Test
	public void analizadoConListaConDosItemsYUnTituloEntreMedioYListaConDosElementos() {
		String entradaMD = "--- \n*hola\n# Titulo1\n*hola\n*holados\n";
		AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);
		String resultado = analizador.analizarContenido();

		Assert.assertEquals("<section>\n" +
				"<ul>\n<li>hola</li>\n</ul>\n<h1>Titulo1</h1>\n<ul>\n<li>hola</li>\n<li>holados</li>\n</ul>\n" +
				"</section>\n", resultado);
	}
}
