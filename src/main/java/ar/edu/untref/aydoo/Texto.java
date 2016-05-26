package ar.edu.untref.aydoo;

public class Texto extends Elemento {

	public Texto(String texto) {
		this.setEntrada(texto);
	}

	public String getSalida(){
		String textoLimpio = getEntrada().substring(0, getEntrada().length()-1);

		return textoLimpio;
	}
	
}
