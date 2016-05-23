package ar.edu.untref.aydoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by Velonter on 5/20/2016.
 */
public class LectorDeMarkdown {

	private File archivoDeEntrada;

	public LectorDeMarkdown(String nombreDeArchivo) {
		this.archivoDeEntrada = new File(nombreDeArchivo);
	}


	public String leerArchivo(String archivo) throws FileNotFoundException, IOException {
		String cadena = "";
		String resultado = "";
		FileReader file = new FileReader(archivo);
		BufferedReader b = new BufferedReader(file);
		while ((cadena = b.readLine()) != null) {
			// System.out.println(cadena);
			resultado = resultado + "\n" + cadena;
		}
		b.close();
		System.out.println(resultado);
		return resultado;
	}
}
