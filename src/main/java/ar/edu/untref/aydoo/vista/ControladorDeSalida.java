package ar.edu.untref.aydoo.vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import ar.edu.untref.aydoo.entrada.GestorDeArchivos;

public class ControladorDeSalida {
	private GestorDeArchivos gestor;

	public ControladorDeSalida() {
		this.gestor = new GestorDeArchivos();
	}

	public void imprimir(String cadenaHtml, String contenidoDeModo, String nombreDeCarpeta)
			throws FileNotFoundException, IOException {
		if (contenidoDeModo.equals("default")) {
			generarSlideJsPorArchivo(nombreDeCarpeta, cadenaHtml);
		} else if (contenidoDeModo.equals("no-output")) {
			generarSlidePorConsola(cadenaHtml);
		}

	}

	private void generarSlideJsPorArchivo(String nombreDeCarpeta, String cadenaHTML)
			throws IOException, FileNotFoundException {
		String ubicacionJar = gestor.getUbicacionDelJar();
		File origen = new File(ubicacionJar + "/plantilla");
		File destino = new File(ubicacionJar + "/" + nombreDeCarpeta);
		gestor.copiarDirectorio(origen, destino);
		File archivoIndex = new File(ubicacionJar + "/" + nombreDeCarpeta + "/index.html");
		gestor.buscarYReemplazarEnArchivo("[este-es-el-texto-a-reemplazar]", cadenaHTML, archivoIndex);
	}

	private void generarSlidePorConsola(String cadenaHTML) {
		System.out.println(cadenaHTML);
	}

}
