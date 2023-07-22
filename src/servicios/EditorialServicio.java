
package servicios;

import entidades.Editorial;
import java.util.Scanner;
import persistencias.EditorialDAO;

public class EditorialServicio {
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    private EditorialDAO edao= new EditorialDAO();
   
    public Editorial crearEditorial(){
        Editorial e = new Editorial();
        try{
            System.out.println("Ingrese el nombre de la editorial");   
            e.setNombre(leer.nextLine());
            e.setAlta(true);
            edao.guardarEditorial(e);
        }catch (Exception er){
            System.out.println("ERROR:" + er.toString());
        }finally{
            return e;
        }
        
      }
    }

