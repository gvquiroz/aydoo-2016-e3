package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.entrada.GestorDeArchivos;

public class GestorDeArchivosTest {

	@Test
	public void testCopiarCarpeta() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File origen = new File("./target/test-classes/template");
		File destino = new File("./target/plantillaCopia");
		gestor.copiarDirectorio(origen, destino);
	}

	@Test
	public void testLeerArchivo() throws FileNotFoundException, IOException {
		File archivo = new File(System.getProperty("user.dir") + "/target/test-classes/mipresentacion1.md");
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.leerArchivo(archivo);
	}

	@Test
	public void testBuscarYReemplazarVolviendoAVersionOriginal() throws FileNotFoundException, IOException {
		File archivo = new File(System.getProperty("user.dir") + "/target/test-classes/template/index.html");
		GestorDeArchivos lector = new GestorDeArchivos();
		String nuevoTexto = "[este-es-el-texto-a-reemplazar]";

		lector.buscarYReemplazarEnArchivo(
				"<section><h1>slide1 :titulo 1</h1></section>\n<section><h2>slide2: titulo 2</h2></section>\n<section>\nslide 3\n<h1>titulo 1</h1>\n<h2>titulo 2</h2>\n</section>",
				nuevoTexto, archivo);
		String resultado = lector.leerArchivo(archivo);

		Assert.assertEquals(true, resultado.contains("[este-es-el-texto-a-reemplazar]"));
	}

	@Test
	public void testBuscarYReemplazar() throws FileNotFoundException, IOException {
		File archivo = new File(System.getProperty("user.dir") + "/target/test-classes/template/index.html");
		GestorDeArchivos lector = new GestorDeArchivos();
		String nuevoTexto = "<section><h1>slide1 :titulo 1</h1></section>\n<section><h2>slide2: titulo 2</h2></section>\n<section>\nslide 3\n<h1>titulo 1</h1>\n<h2>titulo 2</h2>\n</section>";

		lector.buscarYReemplazarEnArchivo("[este-es-el-texto-a-reemplazar]", nuevoTexto, archivo);
		String resultado = lector.leerArchivo(archivo);

		Assert.assertEquals(false, resultado.contains("[este-es-el-texto-a-reemplazar]"));

		/* como esta prueba quema datos se retorna al estado inicial */
		lector.buscarYReemplazarEnArchivo(nuevoTexto, "[este-es-el-texto-a-reemplazar]", archivo);
		resultado = lector.leerArchivo(archivo);
		Assert.assertEquals(true, resultado.contains("[este-es-el-texto-a-reemplazar]"));
	}

}
