
package Paquete2;
//Creacion de clase
public class Estadio {
    //Atributos de la clase 
    String nombre,tipo;  
    double capacidad;
       public Estadio() 
   {
      this( ""," ",0); // llama al constructor con tres argumentos para inicializarlo vacio
   }
   //Constructor de la clase que recibe 3 parametros
    public Estadio(String n, String t, int c) {
        setNombre(n);
        setTipo(t);
        setCapacidad(c);
   
    }
//Metodos set y get
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String ti) {
        tipo = ti;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double cap) {
        capacidad = cap;
    }
//Metodo toString para presentar los atributos de la clase.
    @Override
    public String toString() {
        return String.format("Estadio\n Nombre: %s \t Tipo: %s \t Capacidad: %d",getNombre(),getTipo(), getCapacidad());
                
    }   
}
