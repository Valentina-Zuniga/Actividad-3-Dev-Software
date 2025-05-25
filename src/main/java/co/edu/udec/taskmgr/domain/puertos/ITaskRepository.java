package co.edu.udec.taskmgr.domain.puertos;

import co.edu.udec.taskmgr.domain.entidades.Task;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface ITaskRepository {

    void save(Task task);
    List<Task> findByUserEmail(String email) ;
}
