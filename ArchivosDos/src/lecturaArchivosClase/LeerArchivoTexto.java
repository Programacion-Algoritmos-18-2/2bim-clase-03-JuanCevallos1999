package lecturaArchivosClase;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

public class LeerArchivoTexto
{
   private Scanner entrada;

   // permite al usuario abrir el archivo
   public void abrirArchivo()
   {
      try
      {
         entrada = new Scanner( new File( "clientes3.txt" ) );
      } // fin de try
      catch ( FileNotFoundException fileNotFoundException )
      {
         System.err.println( "Error al abrir el archivo." );
         System.exit( 1 );
      } // fin de catch
   } // fin del m�todo abrirArchivo

   // lee registro del archivo
   public void leerRegistros()
   {
      // objeto que se va a escribir en la pantalla
      RegistroCuenta registro = new RegistroCuenta();

      System.out.printf( "%-9s%-15s%-18s%10s\n", "Cuenta",  //Encabezado
         "Primer nombre", "Apellido paterno", "Saldo" );

      try // lee registros del archivo, usando el objeto Scanner
      {
         while ( entrada.hasNext() ) //Recorre hasta el ultimo
         {
            registro.establecerCuenta( entrada.nextInt() ); // lee el n�mero de cuenta
            registro.establecerPrimerNombre( entrada.next() ); // lee el primer nombre
            registro.establecerApellidoPaterno( entrada.next() ); // lee el apellido paterno
            registro.establecerSaldo( entrada.nextDouble() ); // lee el saldo

            // muestra el contenido del registro
            System.out.printf( "%-9d%-15s%-18s%10.2f\n",
               registro.obtenerCuenta(), registro.obtenerPrimerNombre(),
               registro.obtenerApellidoPaterno(), registro.obtenerSaldo() );
         } // fin de while
      } // fin de try
      catch ( NoSuchElementException elementException )
      {
         System.err.println( "El archivo no esta bien formado." );
         entrada.close();
         System.exit( 1 );
      } // fin de catch
      catch ( IllegalStateException stateException )
      {
         System.err.println( "Error al leer del archivo." );
         System.exit( 1 );
      } // fin de catch
   } // fin del m�todo leerRegistros

   // lee registro del archivo
   public void leerRegistros2()
   {
      
      try // lee registros del archivo, usando el objeto Scanner
      {
         while ( entrada.hasNext() ) //Itera hasta el final de la lista
         {
            String linea = entrada.nextLine();
             System.out.println(linea);
             ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";"))); //Hace un split a las lineas
             System.out.println(linea_partes);
            
            
         } // fin de while
      } // fin de try
      catch ( NoSuchElementException elementException )
      {
         System.err.println( "El archivo no esta bien formado." );
         entrada.close();
         System.exit( 1 );
      } // fin de catch
      catch ( IllegalStateException stateException )
      {
         System.err.println( "Error al leer del archivo." );
         System.exit( 1 );
      } // fin de catch
   } // fin del m�todo leerRegistros
   // cierra el archivo y termina la aplicaci�n
   public void cerrarArchivo()
   {
      if ( entrada != null )
         entrada.close(); // cierra el archivo
   } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

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