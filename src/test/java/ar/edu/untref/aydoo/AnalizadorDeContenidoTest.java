package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenidoTest {

    private List<Elemento> elementosContenido = new LinkedList<Elemento>();

    @Test
    public void recibeTitulo(){

        String contenido = "---\n# unTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "# unTitulo\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeSubtitulo(){

        String contenido = "---\n## unSubTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "## unSubTitulo\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeImagen(){

        String contenido = "---\ni:imagen.png\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "i:imagen.png\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeLista(){

        String contenido = "---\n*unItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "*unItem\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeListaConVariosItems(){

        String contenido = "---\n*unItem\n*otroItem\n*tercerItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "*unItem\n*otroItem\n*tercerItem\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeSeccionesUnaConTituloYOtraConTituloYSubtituloVerificaPrimeraSeccion(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaPrimeraSeccion = "# unTitulo\n";

        Assert.assertEquals(entradaPrimeraSeccion, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeSeccionesUnaConTituloYOtraConTituloYSubtituloVerificaSegundaSeccion(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaSegundaSeccion = "# unTitulo\n## unSubTitulo\n";

        Assert.assertEquals(entradaSegundaSeccion, elementosContenido.get(1).getEntrada());

    }

    @Test
    public void recibeVariasSeccionesConVariosElementos(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n---\ni:imagen.png\n# unTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaTerceraSeccion = "i:imagen.png\n# unTitulo\n";

        Assert.assertEquals(entradaTerceraSeccion, elementosContenido.get(2).getEntrada());

    }
}