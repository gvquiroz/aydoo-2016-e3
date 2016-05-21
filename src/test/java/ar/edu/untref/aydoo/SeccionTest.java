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
	public void muestraSeccionTransformadoSalida() {

		Seccion unaSeccion = new Seccion("--- alguna cosa");
		String seccionEntrada = unaSeccion.getSalida();

		Assert.assertEquals("<section>alguna cosa</section>", seccionEntrada);
	}
}
