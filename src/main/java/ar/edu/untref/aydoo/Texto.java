package ar.edu.untref.aydoo;

public class Texto extends Elemento {

	public Texto(String texto) {
		this.setEntrada(texto);
	}

	public String getSalida(){
		return getEntrada();
	}
	
}
