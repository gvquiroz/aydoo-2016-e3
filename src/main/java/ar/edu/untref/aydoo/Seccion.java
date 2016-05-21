package ar.edu.untref.aydoo;

public class Seccion extends Elemento{

	public Seccion(String contenidoSeccion) {
		this.setEntrada(contenidoSeccion);
	}
	
    public String getSalida(){

        String contenidoSeccion = this.getEntrada();
        contenidoSeccion = contenidoSeccion.substring(4);
        String salida;
        salida = "<section>" + contenidoSeccion + "</section>";

        return salida;

    }

}
