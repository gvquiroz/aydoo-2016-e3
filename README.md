# aydoo-2016-e3

## Trabajo Practico 1

## Decisiones de Diseño:

El programa se invoca desde la Clase Program que tiene un gestor de entrada con la responsabilidad de obtener los argumentos, el nombre el archivo y realizar las validaciones correspondientes.

Luego de procesar la entrada con los datos obtenidos se llama al GestorDeArchivos, el mismo se encarga de leer el archivo ingresado en formato MarkDown generando una cadena String con el contenido del mismo.

La clase Conversor transforma la cadena en formato MarkDown a una cadena en formato HTML.

Para ello se decidió generar una clase Elementos, la cual seria padre de todos los elementos admitidos (Seccion, Titulo, subtitulo, texto, etc.), y cada uno de los elementos sabe transformarse a html.

Para reemplazar el contenido del archivo de salida se decidió a través del GestorDeArchivos levantar el contenido en memoria, reemplazar por el string HTML y reemplazar el contenido del archivo de salida dentro de la nueva carpeta creada también por el GestionadorDeArchivo.

En el caso de no requerirse el archivo simplemente se imprime por consola la cadena HTML.




