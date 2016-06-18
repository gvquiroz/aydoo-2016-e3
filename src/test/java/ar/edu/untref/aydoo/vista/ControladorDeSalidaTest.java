package ar.edu.untref.aydoo.vista;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.vista.ControladorDeSalida;


public class ControladorDeSalidaTest {

	@Test
	public void controladorDeSalidaDeTituloPorConsola() throws FileNotFoundException, IOException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ControladorDeSalida salida = new ControladorDeSalida();
		
		salida.imprimir("<h1>titulo</h1>", "no-output", "plantilla");
		
		Assert.assertEquals("<h1>titulo</h1>", outContent.toString().substring(0, 15));
	}
	
	@Test
	public void controladorDeSalidaDeSubTituloPorConsola() throws FileNotFoundException, IOException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ControladorDeSalida salida = new ControladorDeSalida();
		
		salida.imprimir("<h1>subTitulo</h1>", "no-output", "plantilla");
		
		Assert.assertEquals("<h1>subTitulo</h1>", outContent.toString().substring(0, 18));
	}
	
	@Test
	public void controladorDeSalidaDeTextoSimplePorConsola() throws FileNotFoundException, IOException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		ControladorDeSalida salida = new ControladorDeSalida();
		
		salida.imprimir("texto", "no-output", "plantilla");
		
		Assert.assertEquals("texto", outContent.toString().substring(0, 5));
	}

}
