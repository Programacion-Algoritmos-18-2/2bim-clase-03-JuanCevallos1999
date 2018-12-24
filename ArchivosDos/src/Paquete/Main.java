
package Paquete;

public class Main{
   public static void main( String args[] )
   {
      CrearArchivo aplicacion = new CrearArchivo();  //Objeto de tipo CrearArchivo
      aplicacion.abrirArchivo(); //Apertura del file
      aplicacion.agregarRegistros(); //Agregar información al file
      aplicacion.cerrarArchivo(); //Cerrar el file
   } // fin de main
}