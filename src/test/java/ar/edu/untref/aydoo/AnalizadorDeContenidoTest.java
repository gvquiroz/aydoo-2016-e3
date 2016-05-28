package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenidoTest {

    private List<Elemento> elementosContenido = new LinkedList<Elemento>();

    @SuppressWarnings("unchecked")
	@Test
    public void recibeTitulo(){

        String contenido = "---\n# unTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "# unTitulo\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeSubtitulo(){

        String contenido = "---\n## unSubTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "## unSubTitulo\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeImagen(){

        String contenido = "---\ni:imagen.png\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "i:imagen.png\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeTexto(){

        String contenido = "---\nEsto es un texto\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "Esto es un texto\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeLista(){

        String contenido = "---\n*unItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "*unItem\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeListaConVariosItems(){

        String contenido = "---\n*unItem\n*otroItem\n*tercerItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entrada = "*unItem\n*otroItem\n*tercerItem\n";

        Assert.assertEquals(entrada, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeDosSeccionesUnaConTituloYOtraConTituloYSubtituloVerificaPrimeraSeccion(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaPrimeraSeccion = "# unTitulo\n";

        Assert.assertEquals(entradaPrimeraSeccion, elementosContenido.get(0).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeDosSeccionesUnaConTituloYOtraConTituloYSubtituloVerificaSegundaSeccion(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaSegundaSeccion = "# unTitulo\n## unSubTitulo\n";

        Assert.assertEquals(entradaSegundaSeccion, elementosContenido.get(1).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeTresSeccionesConVariosElementos(){

        String contenido = "---\n# unTitulo\n---\n# unTitulo\n## unSubTitulo\n---\ni:imagen.png\n# unTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaTerceraSeccion = "i:imagen.png\n# unTitulo\n";

        Assert.assertEquals(entradaTerceraSeccion, elementosContenido.get(2).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeDosSeccionesYVerificaTexto(){

        String contenido = "---\n#UnTitulo\n---\nEsto es un texto\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaSegundaSeccion = "Esto es un texto\n";

        Assert.assertEquals(entradaSegundaSeccion, elementosContenido.get(1).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeDosSeccionesYVerificaTextoLargo(){

        String contenido = "---\n#UnTitulo\n---\nEsto es un texto\nEnVarias\nLineas\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaSegundaSeccion = "Esto es un texto\nEnVarias\nLineas\n";

        Assert.assertEquals(entradaSegundaSeccion, elementosContenido.get(1).getEntrada());

    }

    @SuppressWarnings("unchecked")
	@Test
    public void recibeTresSeccionesYVerificaTextoLargoEnSegundaSeccion(){

        String contenido = "---\n#UnTitulo\n---\nEsto es un texto\nEnVarias\nLineas\n---\ni:imagen.png\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        String entradaSegundaSeccion = "Esto es un texto\nEnVarias\nLineas\n";

        Assert.assertEquals(entradaSegundaSeccion, elementosContenido.get(1).getEntrada());

    }

}