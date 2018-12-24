
package Paquete;

//Importacion de bibliotecas
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Creación de clases
public class CrearArchivo{
   private Formatter exit; // objeto usado para enviar texto al archivo
   // permite al usuario abrir el archivo
   public void abrirArchivo()
   {
      try
      {
         exit = new Formatter( "personas.txt" ); //Permite crear un archivo en la dirección establecida
      } // fin de try
      //Posibles errores 
      catch ( SecurityException securityException )
      {
         System.err.println(
            "No tiene acceso de escritura a este archivo." );
         System.exit( 1 );
      } // fin de catch
      catch ( FileNotFoundException filesNotFoundException )
      {
         System.err.println( "Error al crear el archivo." );
         System.exit( 1 );
      } // fin de catch
   } // fin del m�todo abrirArchivo

   // agrega registros al archivo
   public void agregarRegistros()
   {
      // objeto que se va a escribir en el archivo
      Persona persona = new Persona(); //Objeto persona

      Scanner entrada = new Scanner( System.in ); //Scanner para ingresar valores por teclado


      // System.out.printf( "%s\n%s", 
      //    "Escriba el numero de cuenta (> 0), primer nombre, apellido paterno y saldo.",
      //   "? " );
      boolean bandera = true; //Bandera para mantener un ciclo
      
      // while ( entrada.hasNext() ) // itera hasta encontrar el indicador de fin de archivo
      while ( bandera == true ) // itera hasta encontrar el indicador de fin de archivo
      {
         try // env�a valores al archivo
         {
            // obtiene los datos que se van a enviar
            System.out.println("Ingrese Nombre)");
            persona.setNombre( entrada.next() ); // lee el nombre
            System.out.println("Ingrese la edad");
            persona.setEdad( entrada.nextInt() ); // lee la edad          
            if ( persona.getEdad() > 0 ) //Hacemos una condición para que la información ingresada sea correcta, en caso de serlo se agrega al archivo
            {
               // escribe el nuevo registro
               exit.format( "%s %d \n", persona.getNombre(),  //Envia parametros al constructor para escribir el archivo
                  persona.getEdad());
            } // fin de if
            else
            {
               System.out.println(
                  "La edad debe ser mayor a 0." ); //En caso de no ser, no se almacena la información
            } // fin de else
            System.out.println("Desea ingresar más cuentas si (1), no(2)"); //Posibilidad de ingresar mas cuuentas
            int valor = entrada.nextInt();
            if(valor == 2){
                bandera = false;
            }
             
         } // fin de try
         catch ( FormatterClosedException formatterClosedException )
         {
            System.err.println( "Error al escribir en el archivo." );
            return;
         } // fin de catch
         catch ( NoSuchElementException elementException )
         {
            System.err.println( "Entrada invalida. Intente de nuevo." );
            entrada.nextLine(); // descarta la entrada para que el usuario intente de nuevo
         } // fin de catch

         
      } // fin de while
   } // fin del m�todo agregarRegistros

   // cierra el file
   public void cerrarArchivo()
   {
      if ( exit != null )
         exit.close();
   }
}