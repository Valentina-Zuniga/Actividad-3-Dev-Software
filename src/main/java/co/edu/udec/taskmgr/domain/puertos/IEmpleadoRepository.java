
package co.edu.udec.taskmgr.domain.puertos;

import co.edu.udec.taskmgr.domain.entidades.Empleado;
import java.util.List;

/**
 *
 * @author REY
 */
public interface IEmpleadoRepository {
    
    void save(Empleado empleado);         // Crear
    
    Empleado findById(int codigo);        // Leer por ID
    
    List<Empleado> findAll();             // Leer todos
    
    void update(Empleado empleado);       // Actualizar
    
    void deleteById(int codigo);          // Eliminar por ID
}
