package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		GestorDeArgumentos gestorDeEntrada = new GestorDeArgumentos(args);
		String modoContenido = gestorDeEntrada.getContenidoDeModo();
		String nombreDeArchivo = gestorDeEntrada.getNombreDeArchivo();
		String nombreDeCarpeta = gestorDeEntrada.getNombreDeCarpeta();
		File jar = new File(System.getProperty("java.class.path"));
		File direccionJar = jar.getAbsoluteFile().getParentFile();
		String ubicacionJar = direccionJar.toString();

		GestorDeArchivos gestor = new GestorDeArchivos();
		File archivo = new File(ubicacionJar + "/" + nombreDeArchivo);
		String cadenaMarkdown = gestor.leerArchivo(archivo);

		AnalizadorDeContenido analizadorDeContenido = new AnalizadorDeContenido(cadenaMarkdown);
		analizadorDeContenido.analizarContenido();

		@SuppressWarnings("unchecked")
		Conversor conversorHTML = new Conversor(analizadorDeContenido.obtenerContenidoAnalizado());
		String cadenaHTML = conversorHTML.getConversion();

		File origen = new File(ubicacionJar + "/plantilla");

		File destino = new File(ubicacionJar + "/" + nombreDeCarpeta);
		gestor.copiarDirectorio(origen, destino);
		
		if (modoContenido.equals("default")) {
			File archivoIndex = new File(ubicacionJar + "/"+ nombreDeCarpeta +"/index.html");
			gestor.buscarYReemplazarEnArchivo("[este-es-el-texto-a-reemplazar]", cadenaHTML, archivoIndex);
		} else if (modoContenido.equals("no-output")) {
			System.out.println(cadenaHTML);
		}
	}
}
