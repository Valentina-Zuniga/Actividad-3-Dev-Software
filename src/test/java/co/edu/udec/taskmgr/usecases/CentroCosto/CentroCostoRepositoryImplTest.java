package co.edu.udec.taskmgr.usecases.CentroCosto;

import cotizacionesycomprasaplication.base.CentroCosto;
import cotizacionesycomprasaplication.puertos.ICentroCostoRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;
import co.edu.udec.taskmgr.infrastructure.config.SQLiteDatabaseInitializer;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;


public class CentroCostoRepositoryImplTest {

    private ICentroCostoRepository repo;

    @Before
    public void setUp() {
        SQLiteDatabaseInitializer.initialize();
        repo = new CentroCostoRepositoryImpl();
        limpiar();
    }

    private void limpiar() {
        try (Connection conn = PersistenceManager.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute("DELETE FROM centro_costo");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGuardarYBuscar() {
        CentroCosto centro = new CentroCosto(0, "Finanzas", 101);
        repo.save(centro);
        List<CentroCosto> todos = repo.findAll();
        assertEquals(1, todos.size());

        CentroCosto buscado = repo.findById(todos.get(0).getIdCentro());
        assertNotNull(buscado);
        assertEquals("Finanzas", buscado.getNombreCentro());
    }

    @Test
    public void testActualizar() {
        CentroCosto centro = new CentroCosto(0, "Recursos Humanos", 102);
        repo.save(centro);
        CentroCosto guardado = repo.findAll().get(0);
        guardado.setNombreCentro("RRHH");
        repo.update(guardado);

        CentroCosto actualizado = repo.findById(guardado.getIdCentro());
        assertEquals("RRHH", actualizado.getNombreCentro());
    }

    @Test
    public void testEliminar() {
        CentroCosto centro = new CentroCosto(0, "Contabilidad", 103);
        repo.save(centro);
        int id = repo.findAll().get(0).getIdCentro();
        repo.deleteById(id);
        assertNull(repo.findById(id));
    }
}