
package servicios;

import entidades.Autor;
import java.util.List;
import java.util.Scanner;
import persistencias.AutorDAO;


public class AutorServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private AutorDAO adao= new AutorDAO();
    
    public Autor crearAutor(){
        Autor a = new Autor();
        try{
            System.out.println("Ingrese los nombres de autor");   
            a.setNombre(leer.next());
            a.setAlta(true);
            adao.guardarAutor(a);
        }catch (Exception e){
            System.out.println("ERROR:" + e.toString());
        }finally{
            return a;
        }
        
      }
    public void guardarAutor(Autor a){
        adao.guardarAutor(a);
    }
    public void listarAutores(){
            String respuesta;
         do {
            System.out.print("¿Deseas listar los autores? (Sí/No): ");
            respuesta = leer.nextLine().toLowerCase();

            if (respuesta.equals("sí") || respuesta.equals("si")) {
                listarTodo(adao.TraerAutores());
                System.out.println("Listando autores...");
            } else if (!respuesta.equals("no")) {
                System.out.println("Respuesta inválida. Por favor, responde 'Sí' o 'No'.");
            }
        } while (!respuesta.equals("no"));
    }
        
    
    private void listarTodo(List<Autor> l) {
        for (Autor v : l) {
            System.out.println(v.toString());
            }
         }
    
    public Autor buscarIdAutor(int id) {
        return adao.traerAutor(id);
        }
     public void darAltaOBaja() {
        try {
            System.out.println("Elija el id de autor que desea dar de baja");
            listarAutores();
            System.out.print(">>");
            int num =leer.nextInt();
            Autor a= buscarIdAutor(num);
            System.out.println("Selecione una opcion: \n 1. Alta \n 2. Baja");
            if (leer.nextInt() == 1) {
                a.setAlta(true);
            } else {
                a.setAlta(false);
            }
            adao.actualizarAutor(a);
            System.out.println("Modificación exitosa");
        } catch (Exception e) {
            System.out.println("Error"+ e.toString());
        }
        
    }
   }

