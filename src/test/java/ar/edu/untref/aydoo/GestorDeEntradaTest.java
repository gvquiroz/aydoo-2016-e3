package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 5/22/2016.
 */
public class GestorDeEntradaTest {
    @Test
    public void noRecibeModoPorLoQueElModoEsDefault(){
        String args[] = {""};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals( "default",resultado);
    }
    @Test
    public void recibeModoDefault(){
        String args[] = {"--mode=default"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals( "default",resultado);
    }
    @Test
    public void recibeModoNoOutput(){
        String args[] = {"--mode=no-output"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals("no-output",resultado);
    }

    @Test
    public void recibeModoNoOutputLuegoDelNombreDelArchivo(){
        String args[] = {"mipresentacion.md" , "--mode=no-output"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals( "no-output",resultado);
    }
    @Test
    public void recibeModoNoOutputAntesDelNombreDelArchivo(){
        String args[] = {"--mode=no-output" , "mipresentacion.md"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getModo();

        Assert.assertEquals("no-output",resultado);
    }
    @Test
    public void recibeNombreDeCarpetaDeSalidaEnArgumentoOutput(){
        String args[] = {"--output=presentacion1"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getNombreDeCarpetaDeSalida();

        Assert.assertEquals("presentacion1",resultado);
    }
    @Test
    public void recibeSoloNombreDeArchivo(){
        String args[] = {"mipresentacion.md"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getNombreDeArchivo();

        Assert.assertEquals("mipresentacion.md",resultado);
    }
    @Test
    public void recibeModeYNombreDeArchivoYPreguntoNombreDeArchivo(){
        String args[] = {"mipresentacion.md" , "--mode=no-output"};
        GestorDeEntrada interfaz = new GestorDeEntrada(args);

        String resultado = interfaz.getNombreDeArchivo();

        Assert.assertEquals("mipresentacion.md",resultado);
    }
}
