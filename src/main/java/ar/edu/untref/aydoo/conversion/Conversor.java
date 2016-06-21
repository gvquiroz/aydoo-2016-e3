package ar.edu.untref.aydoo.conversion;

import ar.edu.untref.aydoo.dominio.Elemento;

public class Conversor {
	
	private FabricaDeElementos fabrica = new FabricaDeElementos();
	
	public String convertirAHtml(String entradaMD, ObservadorDeElemento miObserver){
		Elemento elemento = fabrica.crearConMD(entradaMD,miObserver);
		return elemento.salidaHtml();
	}
}
