package ar.edu.untref.aydoo.conversion;

import java.util.ArrayList;

import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Lista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Texto;
import ar.edu.untref.aydoo.dominio.Titulo;

public class FabricaDeElementos {
	
	private final ArrayList<Elemento> elementos; 
	
	public FabricaDeElementos(){
		this.elementos = new ArrayList<Elemento>();
		this.elementos.add(new Seccion());
		this.elementos.add(new Titulo());
		this.elementos.add(new SubTitulo());
		this.elementos.add(new Imagen());
		this.elementos.add(new Lista());
		this.elementos.add(new Texto());
	}


	public Elemento crearConMD(String entradaMD, ObservadorDeElemento miObserver) {
		for(Elemento elemento : elementos ){
			Elemento elementoResultante = elemento.crearConMD(entradaMD, miObserver);
			if(elementoResultante != null){
				return elementoResultante;
			}
		}
		throw new RuntimeException("Elemento no existente");
	}
	
	public void agregarElementos(Elemento nuevoElemento){
		elementos.add(nuevoElemento);
	}
	
}
