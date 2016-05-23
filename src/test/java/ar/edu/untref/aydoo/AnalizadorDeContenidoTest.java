package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenidoTest {

    private List<Elemento> elementosContenido = new LinkedList<Elemento>();

    @Test
    public void recibeTitulo(){

        String contenido = "# unTitulo/n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

    @Test
    public void recibeSubtitulo(){

        String contenido = "## unSubTitulo/n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

}
