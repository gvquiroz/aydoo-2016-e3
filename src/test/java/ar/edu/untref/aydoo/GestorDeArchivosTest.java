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
		gestor.renombrarArchivo("plantilla", "plantilla1");
		
		File fichero = new File("plantilla1");
		
		Assert.assertEquals(true, fichero.exists());
	}
	
	@Test
	public void testRenombrarCarpetaPlantilla1APlantilla2() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("plantilla1", "plantilla2");
		
		File fichero = new File("plantilla2");
		
		Assert.assertEquals(true, fichero.exists());
	}
	
	@Test
	public void testRenombrarCarpetaPlantilla2APlantilla() throws IOException {
		GestorDeArchivos gestor = new GestorDeArchivos();
		gestor.renombrarArchivo("plantilla2", "plantilla");
		
		File fichero = new File("plantilla");
		
		Assert.assertEquals(true, fichero.exists());
	}

}
