
package persistencias;

import entidades.Autor;
import java.util.List;


public final class AutorDAO extends DAO {
      
    public void guardarAutor(Autor a){
        super.guardar(a);
    }
    public List<Autor> TraerAutores() {
        List<Autor> autores=null;
        try {
            super.conectar();
            autores= super.em.createQuery("SELECT a" + " FROM Autor a").getResultList();
        } catch (Exception e) {
            
            System.out.println("Ocurrio un error: No se pudo trer los Autores");
        } finally {
            super.desconectar();
            return autores;
        }  
    }
    public Autor traerAutor(int id) {
        Autor a= new Autor();
        try {  
            super.conectar();
            a= super.em.find(Autor.class, id);    
        } catch (Exception e) {
            System.out.println("Hubo un error no se pudo recuperar el Autor");
            
        }finally {
            super.desconectar();
            return a;
        }   
    } 
    public void actualizarAutor(Autor a) {
        super.editar(a);
    }
}
