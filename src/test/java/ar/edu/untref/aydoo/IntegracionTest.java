package ar.edu.untref.aydoo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 6/7/2016.
 */
public class IntegracionTest {

    @SuppressWarnings("unused")
	@Test
    public void testDeIntegracionUsandoComoEjemploImprimirEnPantallaArchivoFormateado() throws IOException {

        String args[] = { "mipresentacion.md", "--mode=no-output" };
        GestorDeArgumentos gestorDeEntrada = new GestorDeArgumentos(args);
        String modoContenido = gestorDeEntrada.getModo();
        String nombreDeArchivo = gestorDeEntrada.getNombreDeArchivo();
        String nombreDeCarpeta = gestorDeEntrada.getNombreDeCarpeta();

        File jar = new File(System.getProperty("java.class.path"));
        File direccionJar = jar.getAbsoluteFile().getParentFile();
        String ubicacionJar = direccionJar.toString();

        File archivo = new File(System.getProperty("user.dir") + "/target/test-classes/mipresentacion1.md");
        GestorDeArchivos gestor = new GestorDeArchivos();

        String cadenaMarkdown = gestor.leerArchivo(archivo);

        AnalizadorDeContenido analizadorDeContenido = new AnalizadorDeContenido(cadenaMarkdown);
        analizadorDeContenido.analizarContenido();

        @SuppressWarnings("unchecked")
		Conversor conversorHTML = new Conversor(analizadorDeContenido.obtenerContenidoAnalizado());
        String cadenaHTML = conversorHTML.getConversion();

        //Para agarrar el output del system.out.print
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        /*
        Esta condicion siempre deberia ir al no-output, es dejada a proposito para testear integridad por ser parte
        del program
         */

        if (modoContenido.equals("default")) {
            File archivoIndex = new File(ubicacionJar + "/"+ nombreDeCarpeta +"/index.html");
            gestor.buscarYReemplazarEnArchivo("[este-es-el-texto-a-reemplazar]", cadenaHTML, archivoIndex);
        } else if (modoContenido.equals("no-output")) {
            System.out.print(cadenaHTML);
        }

        String resultado = outContent.toString();
        String expectedOutput  = cadenaHTML;

        Assert.assertTrue(resultado.equals(expectedOutput));

        System.setOut(null);
    }

}
