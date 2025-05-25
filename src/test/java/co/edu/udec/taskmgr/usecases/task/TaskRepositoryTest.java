package co.edu.udec.taskmgr.usecases.task;

import co.edu.udec.taskmgr.domain.entidades.Task;
import co.edu.udec.taskmgr.domain.enums.TaskStatus;
import co.edu.udec.taskmgr.domain.puertos.ITaskRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;
import co.edu.udec.taskmgr.infrastructure.config.SQLiteDatabaseInitializer;
import co.edu.udec.taskmgr.infrastructure.repository.TaskRepositoryImp;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

public class TaskRepositoryTest {

    private ITaskRepository repository;

    @Before
    public void setup() throws Exception {
        SQLiteDatabaseInitializer.initialize();
        repository = new TaskRepositoryImp();
        try (Connection conn = PersistenceManager.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS tasks");
            stmt.executeUpdate("CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, status TEXT, user_email TEXT)");
        }
    }

    @Test
    public void testSaveAndFindByUserEmail() {
        SQLiteDatabaseInitializer.initialize();
        Task task = new Task("Test Task", "Testing persistence", TaskStatus.PENDING, "test@user.com");
        repository.save(task);

        List<Task> tasks = repository.findByUserEmail("test@user.com");

        assertFalse(tasks.isEmpty());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }
}
