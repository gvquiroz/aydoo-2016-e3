package ar.edu.untref.aydoo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Velonter on 5/25/2016.
 */
public class ProcesadorDeArgumentos {

    private Map<String, Opcion> opciones = new HashMap<String, Opcion>();

    public ProcesadorDeArgumentos(String[] argumentos, List<Opcion> opcionesAdmitidas) {
        // Setea la lista de opciones admitidas al diccionario de opciones
        for (Opcion miOpcion: opcionesAdmitidas){
            this.opciones.put(miOpcion.getNombreDelParametro(), miOpcion);
        }

        // Parsea los argumentos y guarda sus valores

        for (String datos : argumentos) {
            if (datos.contains("=")) {
                String nombreDelParametro = datos.split("=")[0];
                //Chequea si hay correlacion entre el argumento enviado y las opciones admitidas
                if(!this.opciones.containsKey(nombreDelParametro)){
                    throw new ArgumentoInvalidoException();
                }

                String contenidoDelParametro = datos.split("=")[1];
                this.opciones.get(nombreDelParametro).setContenidoDelParametro(contenidoDelParametro);
            } else {
                if(this.opciones.containsKey("sin nombre")){
                    this.opciones.get("sin nombre").setContenidoDelParametro(datos);
                }
            }
        }
    }

    public String getContenido(String nombreDelArgumento) {
        return this.opciones.get(nombreDelArgumento).getContenidoDelParametro();
    }

}
