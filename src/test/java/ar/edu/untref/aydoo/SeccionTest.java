package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

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

		Assert.assertEquals("<section></section>", resultado);
	}

	@Test
	public void seccionConTitulo() {
		Seccion unaSeccion = new Seccion("");
		Titulo titulo = new Titulo("# UnTitulo");

		unaSeccion.agregarElemento(titulo);

		Assert.assertEquals("<section><h1>UnTitulo</h1></section>", unaSeccion.getSalida());
	}

	@Test
	public void seccionConTituloYSubtitulo() {
		Seccion unaSeccion = new Seccion("");
		Titulo titulo = new Titulo("# UnTitulo");
		SubTitulo subTitulo = new SubTitulo("## UnSubTitulo");

		unaSeccion.agregarElemento(titulo);
		unaSeccion.agregarElemento(subTitulo);

		Assert.assertEquals("<section><h1>UnTitulo</h1><h2>UnSubTitulo</h2></section>", unaSeccion.getSalida());
	}
}