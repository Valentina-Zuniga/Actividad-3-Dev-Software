package co.edu.udec.taskmgr.infrastructure.repository;

import cotizacionesycomprasaplication.base.CentroCosto;
import cotizacionesycomprasaplication.puertos.ICentroCostoRepository;
import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CentroCostoRepositoryImpl implements ICentroCostoRepository {

    @Override
    public void save(CentroCosto centro) {
        String sql = "INSERT INTO centro_costo (nombre_centro, empleado_id) VALUES (?, ?)";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, centro.getNombreCentro());
            stmt.setInt(2, centro.getEmpleadoId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar centro de costo", e);
        }
    }

    @Override
    public CentroCosto findById(int id) {
        String sql = "SELECT * FROM centro_costo WHERE id_centro = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return map(rs);
            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar centro de costo", e);
        }
    }

    @Override
    public List<CentroCosto> findAll() {
        List<CentroCosto> lista = new ArrayList<>();
        String sql = "SELECT * FROM centro_costo";

        try (Connection conn = PersistenceManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(map(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al listar centros de costo", e);
        }

        return lista;
    }

    @Override
    public void update(CentroCosto centro) {
        String sql = "UPDATE centro_costo SET nombre_centro = ?, empleado_id = ? WHERE id_centro = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, centro.getNombreCentro());
            stmt.setInt(2, centro.getEmpleadoId());
            stmt.setInt(3, centro.getIdCentro());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar centro de costo", e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM centro_costo WHERE id_centro = ?";

        try (Connection conn = PersistenceManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar centro de costo", e);
        }
    }

    private CentroCosto map(ResultSet rs) throws SQLException {
        CentroCosto centro = new CentroCosto();
        centro.setIdCentro(rs.getInt("id_centro"));
        centro.setNombreCentro(rs.getString("nombre_centro"));
        centro.setEmpleadoId(rs.getInt("empleado_id"));
        return centro;
    }
}