package ar.edu.untref.aydoo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class GestorDeArchivos {

	public void renombrarArchivo(String antes, String despues) throws java.io.IOException {
		File fichero = new File(antes);

		File fichero2 = new File(despues);

		boolean success = fichero.renameTo(fichero2);
		if (!success) {
			System.out.println("Error intentando cambiar el nombre de fichero");
		}
	}

	public void copiarDirectorio(File origen, File destino) throws IOException {
		FileUtils.copyDirectory(origen, destino);
	}
}