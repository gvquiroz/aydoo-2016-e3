package ar.edu.untref.aydoo.dominio;

import org.junit.Assert;
import org.junit.Test;

public class SeccionTest {

	@Test
	public void muestraSeccionEntrante() {

		Seccion unaSeccion = new Seccion();

		unaSeccion.setContenido("alguna cosa");

		Assert.assertEquals("alguna cosa", unaSeccion.getContenido());
	}

	@Test
	public void muestraSeccionVacia() {

		Seccion unaSeccion = new Seccion();
		String resultado = unaSeccion.salidaHtml();

		Assert.assertEquals("<section>\n</section>\n", resultado);
	}


}
