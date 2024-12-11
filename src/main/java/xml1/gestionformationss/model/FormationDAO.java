package xml1.gestionformationss.model;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormationDAO {
    public List<Formation> getAllFormations() throws SQLException {
        List<Formation> formations = new ArrayList<>();
        String sql = "SELECT id, name FROM Formation";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                formations.add(new Formation(rs.getString("id"), rs.getString("name")));
            }
        }
        return formations;
    }
}
