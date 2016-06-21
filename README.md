
# aydoo-2016-e3

## Trabajo Practico 1
### Decisiones de Diseño:

El programa se invoca desde la Clase Program que tiene un gestor de argumentos con la responsabilidad de obtener los argumentos (como el nombre el archivo, modo y output) realizando las validaciones correspondientes.

Nuestro enfoque al resolver este problema fue que el gestor de argumentos se encarga de validar los argumentos recibidos y procesarlos con un procesador de argumentos que recibe las opciones de entrada ingresadas por el cliente y una lista de opciones validas.

Opcion es una Clase que permite setear valores default, valores admitidos y el nombre del parametro por el cual sera parseado a la entrada. De esta forma permitimos flexibilidad a la hora de procesar argumentos simplemente agregando a la lista de opciones validas una nueva opcion si cambia el contrato.

Luego de procesar la entrada con los datos obtenidos se llama al GestorDeArchivos, el mismo se encarga de leer el archivo ingresado en formato MarkDown generando una cadena String con el contenido del mismo.

Para ello se decidió generar una clase Elementos, la cual seria padre de todos los elementos admitidos (Seccion, Titulo, subtitulo, texto, etc.).

Para reemplazar el contenido del archivo de salida se decidió a través del GestorDeArchivos levantar el contenido en memoria, reemplazar por el string HTML y reemplazar el contenido del archivo de salida dentro de la nueva carpeta creada también por el GestionadorDeArchivo.

En el caso de no requerirse el archivo simplemente se imprime por consola la cadena HTML.

Correcciones del TP para el dia 20 de Junio 
-
* utiliza un único paquete para todo

Fue decidido dividir en paquetes con 
'Conversion' Siendo esta capa la encargada de analizar el contenido y aplicarle la transformacion correspondiente
'Dominio' Siendo esta la que modela los distintos objetos del negocio (Como Elemento,Titulo, etc)
'Entrada'  Siendo esta la que se encarga de procesar las distintas entradas (La lectura del archivo de entrada, el procesamiento de los distintos parametros de entrada, etc)
'Vista' Siendo esta la encargada de la salida del resultado de la operacion.

* el jar resultante no tiene el nombre esperado

Cambiado el pom para generar el nombre de jar correspondiente.

* no se ejecuta según lo esperado pues espera una carpeta template cuando en realidad deberia esperar una carpeta plantilla

Cambiada la direccion en la cual va a buscar el template.

* La clase Program tiene demasiada lógica

Creada nueva clase FabricaDeSlideJs encargada de inicializar el analizador (COMPLETAR)
Y cambiada la responsabilidad de la salida segun el parametro recibido a ControladorDeSalida	

* El AnalizadorDeContenido no cierra como está, el switch es imposible

Decidimos ir por la elegante idea de que cada Elemento sepa su caracter de parseo en markdown, su representacion en HTML y se sepa Instanciar a si mismo. Para ello contamos con una FabricaDeElementos que recibe una linea del documento a parsear y en base a ella instancia y devuelve el elemento correspondiente.

A su vez tenemos un ObservadorDeElementos que interactua con algunos elementos en su instanciamiento con el fin de guardarse (Por ejemplo) una referencia a la ultima seccion creada.

AnalizadorDeContenido se encarga de enviarle a la FabricaDeElementos lineas leidas del archivo Markdown, este interactura con un ObservadorDeElementos para guardar los elementos creados por la FabricaDeElemenos en la ultima seccion creada. 

AnalizadorDeContenido guarda las secciones en un Conjunto para luego interarlas pidiendole a cada una la representacion en HTML de su contenido.


* El diagrama de secuencia no tiene loops
* El diagrama de clases tiene olor

Diagrama de clases refinado
Diagrama de secuencia creado nuevamente a un nivel de abstraccion que explique de que forma clara la forma en la cual se soluciona el problema provisto por el tp y al mismo tiempo que sea entendible.
(Se realizo un diagrama para la resolucion de los Argumentos enviados por parametro y otro para el analisis y la conversion de markdown a Html)