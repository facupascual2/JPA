
package main;

import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;



public class Main {

    
    public static void main(String[] args) {

         LibroServicio ls = new LibroServicio();
         ls.crearLibro();
         AutorServicio as = new AutorServicio();
         
         //as.darAltaOBaja();
    }
}
