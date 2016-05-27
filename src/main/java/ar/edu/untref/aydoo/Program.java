package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		GestorDeArgumentos gestorDeEntrada = new GestorDeArgumentos(args);
		String modoContenido = gestorDeEntrada.getContenidoDeModo();
		String nombreDeArchivo = gestorDeEntrada.getNombreDeArchivo();
		String contenidoDelParametroOutput = gestorDeEntrada.getContenidoDeOutput();
		String nombreDeCarpeta = gestorDeEntrada.getNombreDeCarpeta();

		GestorDeArchivos gestor = new GestorDeArchivos();
		File archivo = new File(System.getProperty("user.dir") + "/template/" + nombreDeArchivo);
		String cadenaMarkdown = gestor.leerArchivo(archivo);

		AnalizadorDeContenido analizadorDeContenido = new AnalizadorDeContenido(cadenaMarkdown);
		analizadorDeContenido.analizarContenido();

		Conversor conversorHTML = new Conversor(analizadorDeContenido.obtenerContenidoAnalizado());
		String cadenaHTML = conversorHTML.getConversion();

		File origen = new File("template");

		File destino = new File("./target/" + nombreDeCarpeta);
		gestor.copiarDirectorio(origen, destino);
		
		if (modoContenido.equals("default")) {
			File archivoIndex = new File(System.getProperty("user.dir") + "/target/"+ nombreDeCarpeta +"/index.html");
			gestor.buscarYReemplazarEnArchivo("[este-es-el-texto-a-reemplazar]", cadenaHTML, archivoIndex);
		} else if (modoContenido.equals("no-output")) {
			System.out.println(cadenaHTML);
		}
	}
}
