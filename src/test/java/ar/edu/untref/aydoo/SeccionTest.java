package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Texto;
import ar.edu.untref.aydoo.dominio.Titulo;

public class SeccionTest {

	@Test
	public void muestraSeccionEntrante() {

		Seccion unaSeccion = new Seccion("--- alguna cosa");
		String seccionEntrada = unaSeccion.getEntrada();

		Assert.assertEquals("--- alguna cosa", seccionEntrada);
	}

	@Test
	public void muestraSeccionVacia() {

		Seccion unaSeccion = new Seccion("");
		String resultado = unaSeccion.getSalida();

		Assert.assertEquals("<section>\n</section>\n", resultado);
	}

	@Test
	public void seccionConTextoPlano() {
		Seccion unaSeccion = new Seccion("");
		Texto texto = new Texto("texto libre\n");

		unaSeccion.agregarElemento(texto);

		Assert.assertEquals("<section>\ntexto libre\n</section>\n", unaSeccion.getSalida());
	}
	
	@Test
	public void seccionConTitulo() {
		Seccion unaSeccion = new Seccion("");
		Titulo titulo = new Titulo("# UnTitulo\n");

		unaSeccion.agregarElemento(titulo);

		Assert.assertEquals("<section>\n<h1>UnTitulo</h1>\n</section>\n", unaSeccion.getSalida());
	}

	@Test
	public void seccionConSubtituloSolo() {
		Seccion unaSeccion = new Seccion("");
		SubTitulo subTitulo = new SubTitulo("## UnSubTitulo\n");

		unaSeccion.agregarElemento(subTitulo);

		Assert.assertEquals("<section>\n<h2>UnSubTitulo</h2>\n</section>\n", unaSeccion.getSalida());
	}
	
	@Test
	public void seccionConTituloYSubtitulo() {
		Seccion unaSeccion = new Seccion("");
		Titulo titulo = new Titulo("# UnTitulo\n");
		SubTitulo subTitulo = new SubTitulo("## UnSubTitulo\n");

		unaSeccion.agregarElemento(titulo);
		unaSeccion.agregarElemento(subTitulo);

		Assert.assertEquals("<section>\n<h1>UnTitulo</h1>\n<h2>UnSubTitulo</h2>\n</section>\n", unaSeccion.getSalida());
	}
}
