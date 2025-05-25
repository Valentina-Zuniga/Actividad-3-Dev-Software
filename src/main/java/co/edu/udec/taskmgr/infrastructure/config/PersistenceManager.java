package co.edu.udec.taskmgr.infrastructure.config;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersistenceManager {
    private static final String DB_URL = "jdbc:sqlite:taskmanager.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
