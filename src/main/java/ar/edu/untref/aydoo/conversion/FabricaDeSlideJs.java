package ar.edu.untref.aydoo.conversion;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FabricaDeSlideJs {

	@SuppressWarnings("unchecked")
	public String generarSlideJs(String cadenaMarkdown) throws FileNotFoundException, IOException {

		AnalizadorDeContenido analizadorDeContenido = new AnalizadorDeContenido(cadenaMarkdown);
		analizadorDeContenido.analizarContenido();

		Conversor conversorHTML = new Conversor(analizadorDeContenido.obtenerContenidoAnalizado());
		String cadenaHTML = conversorHTML.getConversion();

		return cadenaHTML;
	}



}
