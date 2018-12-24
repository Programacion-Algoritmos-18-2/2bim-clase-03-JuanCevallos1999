package creacionArchivosClases;

// Fig. 14.7: CrearArchivoTexto.java
// Uso de la clase Formatter para escribir datos en un archivo de texto.

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

// import com.deitel.jhtp7.cap14.RegistroCuenta;

public class CrearArchivoTexto
{
   private Formatter salida; // objeto usado para enviar texto al archivo

   // permite al usuario abrir el archivo
   public void abrirArchivo()
   {
      try
      {
         salida = new Formatter( "clientes3.txt" );
      } // fin de try
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
      RegistroCuenta registro = new RegistroCuenta();

      Scanner entrada = new Scanner( System.in );

      System.out.printf( "%s\n%s\n%s\n%s\n\n",
         "Para terminar la entrada, escriba el indicador de fin de archivo ",
         "cuando se le pida que escriba los datos de entrada.",
         "En UNIX/Linux/Mac OS X escriba <ctrl> d y oprima Intro",
         "En Windows escriba <ctrl> z y oprima Intro" );

      // System.out.printf( "%s\n%s", 
      //    "Escriba el numero de cuenta (> 0), primer nombre, apellido paterno y saldo.",
      //   "? " );
      boolean bandera = true;
      
      // while ( entrada.hasNext() ) // itera hasta encontrar el indicador de fin de archivo
      while ( bandera == true ) // itera hasta encontrar el indicador de fin de archivo
      {
         try // env�a valores al archivo
         {
            // obtiene los datos que se van a enviar
            System.out.println("Ingrese el número de la cuenta (debe ser entero)");
            registro.establecerCuenta( entrada.nextInt() ); // lee el n�mero de cuenta
            System.out.println("Ingrese el nombre del cliente");
            registro.establecerPrimerNombre( entrada.next() ); // lee el primer nombre
            System.out.println("Ingrese el apellidos del cliente");
            registro.establecerApellidoPaterno( entrada.next() ); // lee el apellido paterno
            System.out.println("Ingrese el saldo del cliente (cantidad con decimales)");
            registro.establecerSaldo( entrada.nextDouble() ); // lee el saldo

            if ( registro.obtenerCuenta() > 0 )
            {
               // escribe el nuevo registro
               salida.format( "%d %s %s %.2f\n", registro.obtenerCuenta(), 
                  registro.obtenerPrimerNombre(), registro.obtenerApellidoPaterno(),
                  registro.obtenerSaldo() );
            } // fin de if
            else
            {
               System.out.println(
                  "El numero de cuenta debe ser mayor que 0." );
            } // fin de else
            System.out.println("Desea ingresar más cuentas si (1), no(2)");
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
      if ( salida != null )
         salida.close();
   } // fin del m�todo cerrarArchivo
} // fin de la clase CrearArchivoTexto

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/