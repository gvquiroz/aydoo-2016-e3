package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenidoTest {

    private List<Elemento> elementosContenido = new LinkedList<Elemento>();

    @Test
    public void recibeTitulo(){

        String contenido = "# unTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeSubtitulo(){

        String contenido = "## unSubTitulo\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeImagen(){

        String contenido = "i:imagen.png\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeLista(){

        String contenido = "*unItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeListaConVariosItems(){

        String contenido = "*unItem\n*otroItem\n*tercerItem\n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeVariosElementosVerificaTitulo(){

        String contenido = "# unTitulo\n## unSubTitulo\ni:imagen.png\n*unItem\n" +
                "*otroItem\n" +
                "*tercerItem\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();
        String titulo = "# unTitulo\n";

        Assert.assertEquals(titulo, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeVariosElementosVerificaSubtitulo(){

        String contenido = "# unTitulo\n## unSubTitulo\ni:imagen.png\n*unItem\n" +
                "*otroItem\n" +
                "*tercerItem\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();
        String subTitulo = "## unSubTitulo\n";

        Assert.assertEquals(subTitulo, elementosContenido.get(1).getEntrada());

    }

    @Test
    public void recibeVariosElementosVerificaElUltimo(){

        String contenido = "# unTitulo\n## unSubTitulo\ni:imagen.png\n*unItem\n" +
                "*otroItem\n";

        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();
        String lista = "*unItem\n*otroItem\n";

        Assert.assertEquals(lista, elementosContenido.get(3).getEntrada());

    }
}