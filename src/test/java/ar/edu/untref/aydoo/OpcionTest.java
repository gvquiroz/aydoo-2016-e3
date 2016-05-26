package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Velonter on 5/25/2016.
 */
public class OpcionTest {
    @Test
    public void recibeUnValorDefault(){
        Opcion modo = new Opcion();
        modo.setNombreDelParametro("modo");
        modo.setValorDefault("default");

        Assert.assertEquals("default", modo.getContenidoDelParametro());
    }
    @Test (expected = ArgumentoInvalidoException.class)
    public void seteaValoresPermitidosYRecibeValoresErroneos(){
        Opcion modo = new Opcion();
        modo.setNombreDelParametro("--mode");
        String valores[] = {"default","no-output"};
        modo.setValoresAdmitidos(valores);
        modo.setValorDefault("default");
        modo.setContenidoDelParametro("Casa");
    }
}
