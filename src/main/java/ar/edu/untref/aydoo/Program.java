package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		GestorDeArgumentos argumentosProcesados = new GestorDeArgumentos(args);
		GestorDeArchivos lectorMD = new GestorDeArchivos();
		
		File archivoMD = new File(lectorMD.getUbicacionDelJar() + "/" + argumentosProcesados.getNombreDeArchivo());
		String cadenaMD = lectorMD.leerArchivo(archivoMD);
		
		FabricaDeSlideJs slideJs = new FabricaDeSlideJs();
		String cadenaHtml= slideJs.generarSlideJs(cadenaMD);
		
		ControladorDeSalida salida = new ControladorDeSalida();
		salida.imprimir(cadenaHtml, argumentosProcesados.getModo(), argumentosProcesados.getNombreDeCarpeta());
	}
}
