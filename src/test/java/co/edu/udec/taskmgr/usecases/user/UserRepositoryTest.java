package co.edu.udec.taskmgr.usecases.user;

import co.edu.udec.taskmgr.domain.entidades.User;
import co.edu.udec.taskmgr.domain.enums.UserRole;
import co.edu.udec.taskmgr.domain.puertos.IUserRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;
import co.edu.udec.taskmgr.infrastructure.config.SQLiteDatabaseInitializer;
import co.edu.udec.taskmgr.infrastructure.repository.UserRepositoryImp;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.*;

public class UserRepositoryTest {

    private IUserRepository repository;

    @Before
    public void setup() throws Exception {
        SQLiteDatabaseInitializer.initialize();
        repository = new UserRepositoryImp();
        try (Connection conn = PersistenceManager.getConnection()) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DROP TABLE IF EXISTS users");
            stmt.executeUpdate("CREATE TABLE users (email TEXT PRIMARY KEY, password TEXT, name TEXT, role TEXT)");
        }
    }

    @Test
    public void testSaveAndFindUser() {
        SQLiteDatabaseInitializer.initialize();
        User user = new User("repo@test.com", "123456", "Test Repo", UserRole.STANDARD);
        repository.save(user);

        User result = repository.findByEmail("repo@test.com");

        assertNotNull(result);
        assertEquals("Test Repo", result.getName());
        assertEquals(UserRole.STANDARD, result.getRole());
    }
}
