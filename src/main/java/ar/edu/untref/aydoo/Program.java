package ar.edu.untref.aydoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Opcion nombreDelArchivo = new Opcion();
		nombreDelArchivo.setNombreDelParametro("sin nombre");
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);
		listaDeOpciones.add(nombreDelArchivo);

		ProcesadorDeArgumentos miProcesador = new ProcesadorDeArgumentos(args, listaDeOpciones);
		String modoContenido = miProcesador.getContenido("--mode");

		String nombreDeArchivo = miProcesador.getContenido("sin nombre");
		ValidadorDeNombreDeArchivo validadorDeNombre = new ValidadorDeNombreDeArchivo(nombreDeArchivo);

		GestorDeArchivos gestor = new GestorDeArchivos();
		File archivo = new File(System.getProperty("user.dir") + "/template/" + nombreDeArchivo);
		String cadenaMarkdown = gestor.leerArchivo(archivo);

		AnalizadorDeContenido analizadorDeContenido = new AnalizadorDeContenido(cadenaMarkdown);
		analizadorDeContenido.analizarContenido();

		Conversor conversorHTML = new Conversor(analizadorDeContenido.obtenerContenidoAnalizado());
		String cadenaHTML = conversorHTML.getConversion();

		File origen = new File("template");

		String nombreDeCarpeta = nombreDeArchivo;
		if (nombreDeArchivo.contains(".md")) {
			nombreDeCarpeta = nombreDeArchivo.split(".md")[0];
		}
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
