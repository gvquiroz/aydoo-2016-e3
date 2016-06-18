package ar.edu.untref.aydoo.entrada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class GestorDeArchivos {

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
			if (resultado.equals("")) {
				resultado = cadena;
			}
			resultado = resultado + "\n" + cadena;
		}
		b.close();
		return resultado;
	}

	public void copiarDirectorio(File origen, File destino) throws IOException {
		if (origen.isDirectory()) {
			if (!destino.exists()) {
				destino.mkdir();
			}

			String[] children = origen.list();
			for (int i = 0; i < children.length; i++) {
				copiarDirectorio(new File(origen, children[i]), new File(destino, children[i]));
			}
		} else {
			copiar(origen, destino);
		}
	}
	
	public String getUbicacionDelJar(){
		File jar = new File(System.getProperty("java.class.path"));
		File direccionJar = jar.getAbsoluteFile().getParentFile();
		String ubicacionJar = direccionJar.toString();
		return ubicacionJar;
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

	private void copiar(File origen, File destino) throws IOException {
		InputStream in = new FileInputStream(origen);
		OutputStream out = new FileOutputStream(destino);

		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

}