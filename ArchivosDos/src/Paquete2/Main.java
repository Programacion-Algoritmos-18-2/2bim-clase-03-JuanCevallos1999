package Paquete2;

public class Main {

    public static void main(String[] args) {
        double e;
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();   //Creamos un objeto de tipo LeerArchivoTexto
        OperacionesData operaciones = new OperacionesData();  //Creamos un objeto de tipo OperacionesData
        aplicacion.abrirArchivo();   //Llamamos el metodo abrir archivo de la clase 
        operaciones.agregarInformacion(aplicacion.leerRegistros()); 
        //e = operaciones.PromedioCapacidad();  Forma de obtener el valor del promedio
        //System.out.println(e) Presentación sin orientación a objetos
        System.out.printf("El promedio es: %.2f", operaciones.PromedioCapacidad()); //Presentación con format y orientación a objetos
    }

}
