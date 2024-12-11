package xml1.gestionformationss.model;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getStudentsByFormation(String formationId) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, moyenne, formation_id FROM Student WHERE formation_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, formationId);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    students.add(new Student(rs.getString("id"),
                            rs.getString("name"),
                            rs.getFloat("moyenne"),
                            rs.getString("formation_id")));
                }
            }
        }
        return students;
    }

    public void addStudent(Student student) throws SQLException, IllegalArgumentException {
        // Validation côté applicatif
        if (student.getMoyenne() < 0 || student.getMoyenne() > 20) {
            throw new IllegalArgumentException("La moyenne doit être comprise entre 0 et 20.");
        }

        String sql = "INSERT INTO Student (id, name, moyenne, formation_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, student.getId());
            pst.setString(2, student.getName());
            pst.setFloat(3, student.getMoyenne());
            pst.setString(4, student.getFormationId());
            pst.executeUpdate();
        }
    }

    public float getAverageForFormation(String formationId) throws SQLException {
        String sql = "SELECT AVG(moyenne) as avg_moy FROM Student WHERE formation_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, formationId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getFloat("avg_moy");
                }
            }
        }
        return 0f;
    }
}
