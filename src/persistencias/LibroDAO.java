
package persistencias;

import entidades.Libro;


public final class LibroDAO extends DAO {
    public void guardarLibro(Libro l){
        super.guardar(l);
        
    }
}
