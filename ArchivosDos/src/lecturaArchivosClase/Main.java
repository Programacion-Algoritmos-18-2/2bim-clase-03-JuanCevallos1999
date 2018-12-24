
package lecturaArchivosClase;

public class Main {
    public static void main(String[] args) {
        LeerArchivoTexto1 aplicacion = new LeerArchivoTexto1();   //Creamos un objeto de tipo LeerArchivoTexto1
        aplicacion.abrirArchivo();   //Llamamos el metodo abrir archivo de la clase
        aplicacion.leerRegistros(); //Llamamos el método leer Registros
    }   
}
