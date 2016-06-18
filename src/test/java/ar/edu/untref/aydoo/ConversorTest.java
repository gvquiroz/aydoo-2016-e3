package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.conversion.Conversor;
import ar.edu.untref.aydoo.dominio.Elemento;
import ar.edu.untref.aydoo.dominio.Imagen;
import ar.edu.untref.aydoo.dominio.Lista;
import ar.edu.untref.aydoo.dominio.Seccion;
import ar.edu.untref.aydoo.dominio.SubTitulo;
import ar.edu.untref.aydoo.dominio.Texto;
import ar.edu.untref.aydoo.dominio.Titulo;

import java.util.LinkedList;
import java.util.List;


public class ConversorTest {

    private List<Elemento> contenido = new LinkedList<Elemento>();

    private Seccion primeraSeccion = new Seccion("");
    private Seccion segundaSeccion = new Seccion("");
    private Seccion terceraSeccion = new Seccion("");

    @Test
    public void dosSeccionesSoloTitulo(){

        Titulo primerTitulo = new Titulo("# El titulo\n");
        Titulo unTitulo = new Titulo("# Solo un titulo\n");

        primeraSeccion.agregarElemento(primerTitulo);
        primeraSeccion.agregarElemento(unTitulo);

        segundaSeccion.agregarElemento(unTitulo);

        contenido.add(primeraSeccion);
        contenido.add(segundaSeccion);

        Conversor conversorHTML = new Conversor(contenido);

        String conversion = "<section>\n<h1>El titulo</h1>\n" +
                "<h1>Solo un titulo</h1>\n</section>\n" +
                "<section>\n<h1>Solo un titulo</h1>\n</section>\n";

        Assert.assertEquals(conversion,conversorHTML.getConversion());
    }

    @Test
    public void dosSeccionesSoloSubtitulo(){

        SubTitulo primerSubtitulo = new SubTitulo("## Primer subtitulo\n");
        SubTitulo unSubtitulo = new SubTitulo("## El subtitulo\n");

        primeraSeccion.agregarElemento(primerSubtitulo);
        primeraSeccion.agregarElemento(unSubtitulo);

        segundaSeccion.agregarElemento(unSubtitulo);

        contenido.add(primeraSeccion);
        contenido.add(segundaSeccion);

        Conversor conversorHTML = new Conversor(contenido);

        String conversion = "<section>\n<h2>Primer subtitulo</h2>\n" +
                "<h2>El subtitulo</h2>\n</section>\n" +
                "<section>\n<h2>El subtitulo</h2>\n</section>\n";

        Assert.assertEquals(conversion,conversorHTML.getConversion());
    }

    @Test
    public void dosSeccionesSoloImagen(){

        Imagen primeraImagen = new Imagen("i:fotoPortada.png\n");
        Imagen unaImagen = new Imagen("i:fotoPerfil.png\n");

        primeraSeccion.agregarElemento(primeraImagen);

        segundaSeccion.agregarElemento(primeraImagen);
        segundaSeccion.agregarElemento(unaImagen);

        contenido.add(primeraSeccion);
        contenido.add(segundaSeccion);

        Conversor conversorHTML = new Conversor(contenido);

        String conversion = "<section>\n<img src= fotoPortada.png />\n</section>\n" +
                "<section>\n<img src= fotoPortada.png />\n" +
                "<img src= fotoPerfil.png />\n</section>\n";

        Assert.assertEquals(conversion,conversorHTML.getConversion());
    }

    @Test
    public void dosSeccionesSoloLista(){

        Lista listaCarniceria = new Lista("*1 kg de Asado\n");
        listaCarniceria.agregarItem("*2 kg de Vacio\n");
        Lista listaVerduleria = new Lista("*1 kg de tomate\n");

        primeraSeccion.agregarElemento(listaCarniceria);
        primeraSeccion.agregarElemento(listaVerduleria);

        segundaSeccion.agregarElemento(listaVerduleria);

        contenido.add(primeraSeccion);
        contenido.add(segundaSeccion);

        Conversor conversorHTML = new Conversor(contenido);

        String conversion = "<section>\n<ul>\n<li>1 kg de Asado</li>\n" +
                "<li>2 kg de Vacio</li>\n</ul>\n" +
                "<ul>\n<li>1 kg de tomate</li>\n</ul>\n" +
                "</section>\n" +
                "<section>\n<ul>\n<li>1 kg de tomate</li>\n</ul>\n" +
                "</section>\n";

        Assert.assertEquals(conversion,conversorHTML.getConversion());
    }

    @Test
    public void tresSeccionesEjemploIntegrador(){

        Titulo primerTitulo = new Titulo("# El titulo\n");
        SubTitulo unSubtitulo = new SubTitulo("## El subtitulo\n");
        primeraSeccion.agregarElemento(primerTitulo);
        primeraSeccion.agregarElemento(unSubtitulo);

        Titulo unTitulo = new Titulo("# Solo un titulo\n");
        segundaSeccion.agregarElemento(unTitulo);

        Texto soloTexto = new Texto("solo texto sin nada mas\n");
        terceraSeccion.agregarElemento(soloTexto);

        contenido.add(primeraSeccion);
        contenido.add(segundaSeccion);
        contenido.add(terceraSeccion);

        Conversor conversorHTML = new Conversor(contenido);

        String conversion = "<section>\n<h1>El titulo</h1>\n" +
                "<h2>El subtitulo</h2>\n" +
                "</section>\n<section>\n<h1>Solo un titulo</h1>\n</section>\n" +
                "<section>\nsolo texto sin nada mas\n</section>\n";

        Assert.assertEquals(conversion,conversorHTML.getConversion());
    }
}
