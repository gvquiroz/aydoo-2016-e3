package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class GestorDeArchivosTest {

	@Test
	public void testRenombrarArchivoTxtACvs() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("archivo.txt", "archivo.cvs");
		File fichero = new File("archivo.cvs");

		Assert.assertEquals(true, fichero.exists());
	}

	@Test
	public void testRenombrarArchivoCvsATxt() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("archivo.cvs", "archivo.txt");

		File fichero = new File("archivo.txt");

		Assert.assertEquals(true, fichero.exists());
	}

	@Test
	public void testRenombrarCarpetaPlantillaAPlantilla1() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("template", "template1");

		File fichero = new File("template1");

		Assert.assertEquals(true, fichero.exists());
	}

	@Test
	public void testRenombrarCarpetaPlantilla1APlantilla2() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("template1", "template2");

		File fichero = new File("template2");

		Assert.assertEquals(true, fichero.exists());
	}

	@Test
	public void testRenombrarCarpetaPlantilla2APlantilla() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("template2", "template");

		File fichero = new File("template");

		Assert.assertEquals(true, fichero.exists());
	}

	@Test
	public void testCopiarCarpeta() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		File origen = new File("template");
		File destino = new File("./target/plantillaCopia");
		gestor.copiarDirectorio(origen, destino);

	}

}
