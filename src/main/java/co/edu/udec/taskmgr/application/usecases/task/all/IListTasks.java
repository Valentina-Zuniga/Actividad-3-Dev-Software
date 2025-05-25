package co.edu.udec.taskmgr.application.usecases.task.all;

import co.edu.udec.taskmgr.domain.entidades.Task;
import java.util.List;

/**
 *
 * @author John Carlos Arrieta Arrieta
 */
public interface IListTasks {

    List<Task> handle(ListTasksQuery query);
}
