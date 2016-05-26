package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GestorDeArchivosTest {

	@Test
	public void testRenombrarArchivoTxtACvs() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File entrada = new File(System.getProperty("user.dir") + "/template/archivo.txt");
		File salida = new File(System.getProperty("user.dir") + "/template/archivo.cvs");

		gestor.renombrarArchivo(entrada, salida);

		Assert.assertEquals(true, salida.exists());
	}

	@Test
	public void testRenombrarArchivoCvsATxt() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File entrada = new File(System.getProperty("user.dir") + "/template/archivo.cvs");
		File salida = new File(System.getProperty("user.dir") + "/template/archivo.txt");

		gestor.renombrarArchivo(entrada, salida);

		Assert.assertEquals(true, salida.exists());
	}

	@Test
	public void testRenombrarCarpetaPlantillaAPlantilla1() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File entrada = new File("template");
		File salida = new File("template1");
		gestor.renombrarArchivo(entrada, salida);

		Assert.assertEquals(true, salida.exists());
		gestor.renombrarArchivo(salida, entrada);
		Assert.assertEquals(true, entrada.exists());
	}

	@Test
	public void testCopiarCarpeta() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File origen = new File("template");
		File destino = new File("./target/plantillaCopia");
		gestor.copiarDirectorio(origen, destino);

	}

	@Test
	public void testLeerArchivo() throws FileNotFoundException, IOException {
		File archivo = new File(System.getProperty("user.dir") + "/template/mipresentacion1.md");
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.leerArchivo(archivo);

	}

	@Test
	public void testBuscarYReemplazarVolviendoAVersionOriginal() throws FileNotFoundException, IOException {
		File archivo = new File(System.getProperty("user.dir") + "/template/index.html");
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
		File archivo = new File(System.getProperty("user.dir") + "/template/index.html");
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
