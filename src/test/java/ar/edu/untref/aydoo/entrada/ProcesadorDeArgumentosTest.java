package ar.edu.untref.aydoo.entrada;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ar.edu.untref.aydoo.entrada.ArgumentoInvalidoException;
import ar.edu.untref.aydoo.entrada.Opcion;
import ar.edu.untref.aydoo.entrada.ProcesadorDeArgumentos;

/**
 * Created by Velonter on 5/22/2016.
 */
public class ProcesadorDeArgumentosTest {
	@Test
	public void noRecibeModoPorLoQueElModoEsDefault() {

		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		String args[] = {};
		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("--mode");

		Assert.assertEquals("default", resultado);
	}

	@Test
	public void recibeModoDefault() {
		String args[] = { "--mode=default" };
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("--mode");

		Assert.assertEquals("default", resultado);
	}

	@Test
	public void recibeModoNoOutput() {
		String args[] = { "--mode=no-output" };
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("--mode");

		Assert.assertEquals("no-output", resultado);
	}

	@Test
	public void recibeModoNoOutputLuegoDelNombreDelArchivo() {
		String args[] = { "mipresentacion.md", "--mode=no-output" };

		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);
		String resultado = interfaz.getContenido("--mode");

		Assert.assertEquals("no-output", resultado);
	}

	@Test
	public void recibeModoNoOutputAntesDelNombreDelArchivo() {
		String args[] = { "--mode=no-output", "mipresentacion.md" };
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("--mode");
		Assert.assertEquals("no-output", resultado);
	}

	@Test
	public void recibeNombreDeCarpetaDeSalidaEnArgumentoOutput() {
		String args[] = { "--output=presentacion1" };

		Opcion output = new Opcion();
		output.setNombreDelParametro("--output");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(output);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("--output");

		Assert.assertEquals("presentacion1", resultado);
	}

	@Test
	public void recibeSoloNombreDeArchivo() {
		String args[] = { "mipresentacion.md" };

		Opcion nombreDelArchivo = new Opcion();
		nombreDelArchivo.setNombreDelParametro("parametroVacio");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(nombreDelArchivo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);

		String resultado = interfaz.getContenido("parametroVacio");

		Assert.assertEquals("mipresentacion.md", resultado);
	}

	@Test
	public void recibeModeYNombreDeArchivoYPreguntoNombreDeArchivo() {
		String args[] = { "mipresentacion.md", "--mode=no-output" };

		Opcion nombreDelArchivo = new Opcion();
		nombreDelArchivo.setNombreDelParametro("parametroVacio");
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");
		Opcion output = new Opcion();
		output.setNombreDelParametro("--output");
		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(output);
		listaDeOpciones.add(modo);
		listaDeOpciones.add(nombreDelArchivo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);
		String resultado = interfaz.getContenido("parametroVacio");

		Assert.assertEquals("mipresentacion.md", resultado);
	}


	@Test(expected = ArgumentoInvalidoException.class)
	public void recibeUnModoInvalido() {
		String args[] = { "Presentacion.md", "--mode=gaby" };
		Opcion nombreDelArchivo = new Opcion();
		nombreDelArchivo.setNombreDelParametro("parametroVacio");
		Opcion modo = new Opcion();
		modo.setNombreDelParametro("--mode");
		String valores[] = { "default", "no-output" };
		modo.setValoresAdmitidos(valores);
		modo.setValorDefault("default");

		List<Opcion> listaDeOpciones = new LinkedList<>();
		listaDeOpciones.add(modo);
		listaDeOpciones.add(nombreDelArchivo);

		ProcesadorDeArgumentos interfaz = new ProcesadorDeArgumentos(args, listaDeOpciones);
		@SuppressWarnings("unused")
		String nombreDeArchivo = interfaz.getContenido("--mode");
	}

}
