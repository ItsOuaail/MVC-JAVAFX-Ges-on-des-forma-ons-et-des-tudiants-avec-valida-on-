package xml1.gestionformationss.model;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/db1"; // URL de connexion PostgreSQL
    private static final String USER = "postgres"; // Remplacez par votre nom d'utilisateur PostgreSQL
    private static final String PASSWORD = "1234"; // Remplacez par votre mot de passe PostgreSQL





    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
