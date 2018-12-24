
package Paquete2;
//Importación de librerias necesarias
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

//Creación de clase
public class LeerArchivoTexto {
//Atributos de clase.
    private Scanner entrada;
    OperacionesData operacion = new OperacionesData(); //Creamos un objeto de tipo operacionData para poder trabajar con la clase OperacionData

    // permite al usuario abrir el archivo
    public void abrirArchivo() { //Metodo para abrir archivo txt 
        try {  
            entrada = new Scanner(new File("estadios.txt"));  //Se utiliza entrada de tipo Scanner para ingresar información que se encuentra en la ruta especificada
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo
    // lee registro del archivo
    public ArrayList<Estadio> leerRegistros() { //El metodo devuelve un ArrayList de tipo Estadio 
        ArrayList<Estadio> lista = new ArrayList<>(); //Creación del arrayList
        
        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine(); //Nos posicionamos desde la segunda linea para no tomar en cuenta el encabezado
            while (entrada.hasNext()) { //Mientras exista una linea siguiente se crea un ciclo para poder iterar con todas las lineas del archivo
                Estadio estadio = new Estadio();  //Creación de objeto tipo Estadio
                String linea = entrada.nextLine();  //Almacenamos en "linea" las lineas del archivo almacenado en entrada
                ArrayList<String> linea_partes = new ArrayList<String>(Arrays.asList(linea.split(";"))); //Hacemos un split para transformar las lineas en listas
                estadio.setNombre(linea_partes.get(0)); //Enviamos las partes de las lineas al objeto estadio que creamos 
                estadio.setTipo(linea_partes.get(1));
                estadio.setCapacidad(Double.parseDouble(linea_partes.get(2))); //Transformamos a tipo double la cadena de la lista
                lista.add(estadio); //Agregamos el objeto a la lista, esta linea es importante sino el objeto solo se sobreescribira
            } // fin de while
            //operacion.agregarInformacion(lista);

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista; //Devolvemos la lista que contiene los objetos Estadios.
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n
//Metodo para cerrar el archivo
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
}
