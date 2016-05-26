package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Velonter on 5/25/2016.
 */
public class ProcesadorDeArgumentos {

    private Map<String, String> opciones = new HashMap<String, String>();

    public ProcesadorDeArgumentos(String[] argumentos, List<Opcion> opcionesAdmitidas) {
        // Setea la lista de opciones admitidas al diccionario de opciones
        for (Opcion miOpcion: opcionesAdmitidas){
            this.opciones.put(miOpcion.getNombreDelParametro(), miOpcion.getContenidoDelParametro());

        }

        // Parsea los argumentos y guarda sus valores, Si no hay correlacion entre un argumento recibido
        // y uno esperado tira exception

        for (String datos : argumentos) {
            if (datos.contains("=")) {
                String nombreDelParametro = datos.split("=")[0];

                if(!this.opciones.containsKey(nombreDelParametro)){
                    throw new ArgumentoInvalidoException();
                }

                String contenidoDelParametro = datos.split("=")[1];
                this.opciones.put(nombreDelParametro,contenidoDelParametro);
            } else {
                this.opciones.put("sin nombre", datos);
            }
        }
    }

    public String getContenido(String nombreDelArgumento) {
        return this.opciones.get(nombreDelArgumento);
    }

}
