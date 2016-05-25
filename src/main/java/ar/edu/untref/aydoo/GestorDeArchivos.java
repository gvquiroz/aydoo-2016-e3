package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

	public void buscarYReemplazarEnArchivo(String textoBuscado, String nuevoTexto, File archivo)
			throws FileNotFoundException, IOException {
		String resultado = this.leerArchivo(archivo);
		resultado = resultado.replace(textoBuscado, nuevoTexto);
		this.imprimirEnArchivo(archivo, resultado);
	}

	public String leerArchivo(File archivo) throws FileNotFoundException, IOException {
		String cadena = "";
		String resultado = "";
		FileReader file = new FileReader(archivo);
		BufferedReader b = new BufferedReader(file);
		while ((cadena = b.readLine()) != null) {
			resultado = resultado + "\n" + cadena;
		}
		b.close();
		return resultado;
	}

	private void imprimirEnArchivo(File archivo, String resultado) {

		try {
			FileWriter w = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);

			wr.write(resultado);
			wr.close();
			bw.close();
		} catch (IOException e) {
		}
		;
	}

}