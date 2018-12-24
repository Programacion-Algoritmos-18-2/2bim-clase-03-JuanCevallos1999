
package Paquete;
//Clase Persona 
public class Persona {
    //Atributos de clase
    String nombre;
    int edad; 
       public Persona() //Constructor 1
   {
      this( "", 0 ); // llama al constructor con 2 argumentos
   }
    public Persona(String nom, int ed){ //Constructor 2
        nombre = nom;
        edad = ed;
    }
    //Metodos set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int e) {
        edad = e;
    }
}
