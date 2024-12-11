package xml1.gestionformationss.controller;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import xml1.gestionformationss.model.Student;
import xml1.gestionformationss.model.StudentDAO;

public class AddStudentController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField moyField;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    private String formationId;
    private StudentDAO studentDAO = new StudentDAO();

    public void setFormationId(String formationId) {
        this.formationId = formationId;
    }

    @FXML
    public void initialize() {
        saveButton.setOnAction(e -> saveStudent());
        cancelButton.setOnAction(e -> closeWindow());
    }

    private void saveStudent() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String moyStr = moyField.getText().trim();

        if (id.isEmpty() || name.isEmpty() || moyStr.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        float moyenne;
        try {
            moyenne = Float.parseFloat(moyStr);
        } catch (NumberFormatException ex) {
            showAlert("Erreur", "La moyenne doit être un nombre.");
            return;
        }

        Student s = new Student(id, name, moyenne, formationId);

        try {
            studentDAO.addStudent(s);
            closeWindow();
        } catch (IllegalArgumentException ex) {
            // Moyenne invalide
            showAlert("Erreur", ex.getMessage());
        } catch (Exception ex) {
            showAlert("Erreur", "Erreur lors de l'ajout de l'étudiant : " + ex.getMessage());
        }
    }

    private void closeWindow() {
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
