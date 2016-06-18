package ar.edu.untref.aydoo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class FabricaDeSlideJsTest {

	@Test
	public void fabricaDeTitulo() throws FileNotFoundException, IOException {
		FabricaDeSlideJs fabrica = new FabricaDeSlideJs();
		String resultado = fabrica.generarSlideJs("--\n# unTitulo\n");

		Assert.assertEquals("<section>\n<h1>unTitulo</h1>\n</section>\n", resultado);
	}
	
	@Test
	public void fabricaDeSubTitulo() throws FileNotFoundException, IOException {
		FabricaDeSlideJs fabrica = new FabricaDeSlideJs();
		String resultado = fabrica.generarSlideJs("--\n## unSubTitulo\n");

		Assert.assertEquals("<section>\n<h2>unSubTitulo</h2>\n</section>\n", resultado);
	}

	@Test
	public void fabricaDeSlideConVariosElementos() throws FileNotFoundException, IOException {
		FabricaDeSlideJs fabrica = new FabricaDeSlideJs();
		String resultado = fabrica.generarSlideJs("---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n---\ni:imagen.png\n# unTitulo\n");

		Assert.assertEquals("<section>\n<h1>unTitulo</h1>\n</section>\n<section>\n<h1>unTitulo</h1>\n<h2>unSubTitulo</h2>\n</section>\n<section>\n<img src= imagen.png />\n<h1>unTitulo</h1>\n</section>\n", resultado);
	}

	
}
