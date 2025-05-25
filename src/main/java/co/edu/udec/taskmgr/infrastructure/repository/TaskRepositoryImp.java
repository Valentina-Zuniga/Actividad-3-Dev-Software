package co.edu.udec.taskmgr.infrastructure.repository;

import co.edu.udec.taskmgr.infrastructure.config.PersistenceManager;
import co.edu.udec.taskmgr.domain.enums.TaskStatus;
import co.edu.udec.taskmgr.domain.entidades.Task;
import co.edu.udec.taskmgr.domain.puertos.ITaskRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImp implements ITaskRepository {

    @Override
    public void save(Task task) {
        try (Connection conn = PersistenceManager.getConnection()) {
            String sql = "INSERT INTO tasks (title, description, status, user_email) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDescription());
            stmt.setString(3, task.getStatus().name());
            stmt.setString(4, task.getUserEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saving task", e);
        }
    }

    @Override
    public List<Task> findByUserEmail(String email) {
        List<Task> tasks = new ArrayList<>();
        try (Connection conn = PersistenceManager.getConnection()) {
            String sql = "SELECT * FROM tasks WHERE user_email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tasks.add(new Task(
                    rs.getString("title"),
                    rs.getString("description"),
                    TaskStatus.valueOf(rs.getString("status")),
                    rs.getString("user_email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching tasks", e);
        }
        return tasks;
    }
}
