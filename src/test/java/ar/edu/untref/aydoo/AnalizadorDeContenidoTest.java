package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class AnalizadorDeContenidoTest {

    @Test
    public void recibeUnTitulo(){

        List<Elemento> elementosContenido = new LinkedList<Elemento>();

        String contenido = "# unTitulo/n";
        AnalizadorDeContenido analizador = new AnalizadorDeContenido(contenido);
        analizador.analizarContenido();
        elementosContenido = analizador.obtenerContenidoAnalizado();

        Assert.assertEquals(contenido, elementosContenido.get(0).getEntrada());

    }

}
