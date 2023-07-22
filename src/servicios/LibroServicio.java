
package servicios;

import entidades.Libro;
import java.util.Scanner;
import persistencias.LibroDAO;


public class LibroServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private LibroDAO ldao= new LibroDAO();
    public Libro crearLibro(){
        Libro l = new Libro();
        AutorServicio as= new AutorServicio();
        EditorialServicio es= new EditorialServicio();
        
        try{
        l.setAutor(as.crearAutor());
        l.setEditorial(es.crearEditorial());
            System.out.println("Titulo");
        l.setTitulo(leer.nextLine());
            System.out.println("Año de Salida");
        l.setAnio(leer.nextInt());
            System.out.println("Cantidad de ejemplares");
        l.setEjemplares(leer.nextInt());
            System.out.println("Ejemplares Prestados");
        l.setEjemplaresPrestados(leer.nextInt());
            System.out.println("Ejemplares Restantes");
        l.setEjemplaresRestantes(leer.nextInt());
        l.setAlta(true);
            ldao.guardarLibro(l) ;   
        
        }catch(Exception e){
            System.out.println("error:" + e.toString() );
            
        }finally{
            return l;
        }
        
    }
}
