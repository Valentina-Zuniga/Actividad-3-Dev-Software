package co.edu.udec.taskmgr.usecases.Empleado;

import co.edu.udec.taskmgr.domain.entidades.Empleado;
import co.edu.udec.taskmgr.domain.puertos.IEmpleadoRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;
import co.edu.udec.taskmgr.infrastructure.config.SQLiteDatabaseInitializer;
import co.edu.udec.taskmgr.infrastructure.repository.EmpleadoRepositoryImpl;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author REY
 */
public class EmpleadoRepositoryImplTest {

    private IEmpleadoRepository repo;

    @Before
    public void setUp() {
        SQLiteDatabaseInitializer.initialize();
        repo = new EmpleadoRepositoryImpl();
        limpiar();
    }

    private void limpiar() {
        try (Connection conn = PersistenceManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM empleado");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGuardarYBuscar() {
        Empleado e = new Empleado(0, "Rey", "10001234", 3);
        repo.save(e);
        List<Empleado> todos = repo.findAll();
        assertEquals(1, todos.size());
        Empleado uno = repo.findById(todos.get(0).getCodigoEmpleado());
        assertNotNull(uno);
        assertEquals("Rey", uno.getNombre());
    }

    @Test
    public void testActualizar() {
        Empleado e = new Empleado(0, "Luis", "8888", 1);
        repo.save(e);
        Empleado guardado = repo.findAll().get(0);
        guardado.setNombre("Luis Miguel");
        repo.update(guardado);
        Empleado actualizado = repo.findById(guardado.getCodigoEmpleado());
        assertEquals("Luis Miguel", actualizado.getNombre());
    }

    @Test
    public void testEliminar() {
        Empleado e = new Empleado(0, "Ana", "12345", 2);
        repo.save(e);
        int id = repo.findAll().get(0).getCodigoEmpleado();
        repo.deleteById(id);
        assertNull(repo.findById(id));
    }
}
