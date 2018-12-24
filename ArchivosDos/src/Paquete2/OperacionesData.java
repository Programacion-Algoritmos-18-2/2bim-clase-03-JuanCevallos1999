
package Paquete2;
//Importamos las librerias necesarias 
import java.util.ArrayList;
//Creación de clase
public class OperacionesData {
        //Atributos de la clase ArrayList de tipo estadio
        ArrayList<Estadio> informacion;
    //Agregamos la información que recibirá la lista llena anteriormente / Metodo set
    public void agregarInformacion(ArrayList<Estadio> info){
        informacion = info;
    }
    //Metodo get
    public ArrayList<Estadio> obtenerInformacion(){
        return informacion;
    }
    //Metodo para calcular el promedio de capacidades del estadio
    public double PromedioCapacidad(){
        double sumatoria=0,promedio=0; //Variables locales 
        int acum=0; //Acumulador 
          for (int i=0; i< informacion.size(); i++){ //Iteramos el el numero de veces que es el tamaño de la lista
             sumatoria += obtenerInformacion().get(i).getCapacidad();
             acum++;
         }
         promedio = sumatoria/acum; 
         return promedio; //Devolvemos el promedio calculado
    }
}
