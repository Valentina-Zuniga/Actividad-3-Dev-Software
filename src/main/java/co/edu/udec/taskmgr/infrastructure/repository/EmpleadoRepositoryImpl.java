package co.edu.udec.taskmgr.infrastructure.repository;

import co.edu.udec.taskmgr.domain.entidades.Empleado;
import co.edu.udec.taskmgr.domain.puertos.IEmpleadoRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

    @Override
    public void save(Empleado emp) {
        String sql = "INSERT INTO empleado (nombre, cedula, area_id) VALUES (?, ?, ?)";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getCedula());
            stmt.setInt(3, emp.getAreaId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar empleado", e);
        }
    }

    @Override
    public Empleado findById(int codigo) {
        String sql = "SELECT * FROM empleado WHERE codigo_empleado = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return map(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar empleado", e);
        }
    }

    @Override
    public List<Empleado> findAll() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = PersistenceManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(map(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar empleados", e);
        }

        return lista;
    }

    @Override
    public void update(Empleado emp) {
        String sql = "UPDATE empleado SET nombre = ?, cedula = ?, area_id = ? WHERE codigo_empleado = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, emp.getNombre());
            stmt.setString(2, emp.getCedula());
            stmt.setInt(3, emp.getAreaId());
            stmt.setInt(4, emp.getCodigoEmpleado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar empleado", e);
        }
    }

    @Override
    public void deleteById(int codigo) {
        String sql = "DELETE FROM empleado WHERE codigo_empleado = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, codigo);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar empleado", e);
        }
    }

    private Empleado map(ResultSet rs) throws SQLException {
        Empleado e = new Empleado();
        e.setCodigoEmpleado(rs.getInt("codigo_empleado"));
        e.setNombre(rs.getString("nombre"));
        e.setCedula(rs.getString("cedula"));
        e.setAreaId(rs.getInt("area_id"));
        return e;
    }
}