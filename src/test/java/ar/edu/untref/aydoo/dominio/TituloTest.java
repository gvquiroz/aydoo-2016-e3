package ar.edu.untref.aydoo.dominio;

import ar.edu.untref.aydoo.conversion.AnalizadorDeContenido;
import ar.edu.untref.aydoo.conversion.Conversor;
import ar.edu.untref.aydoo.conversion.ObservadorDeElemento;
import org.junit.Assert;
import org.junit.Test;

public class TituloTest {

    @Test
    public void convertirTitulo() {

        String entradaMD = "--- \n# Titulo1";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);

        String resultado = analizador.analizarContenido();

        Assert.assertEquals("<section>\n<h1>Titulo1</h1>\n</section>\n", resultado);

    }

    @Test
    public void convertirAlgoDistintoAUnTitulo() {
        Conversor conversor = new Conversor();
        ObservadorDeElemento miObserver = new ObservadorDeElemento();
        String entradaMD = "## NoEsUnTitulo";
        String salidaHtml = conversor.convertirAHtml(entradaMD, miObserver);

        Assert.assertNotEquals("<h1>NoEsUnTitulo</h1>", salidaHtml);
    }

    @Test
    public void pruebaConDosTitulosAnidados() {

        String entradaMD = "--- \n# Titulo1\n# Titulo1";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(entradaMD);

        String resultado = analizador.analizarContenido();

        Assert.assertEquals("<section>\n<h1>Titulo1</h1>\n<h1>Titulo1</h1>\n</section>\n", resultado);

    }

}