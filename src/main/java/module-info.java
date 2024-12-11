module xml1.gestionformationss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    // Ouvrir le package controller pour l'accès via la réflexion du FXML Loader
    opens xml1.gestionformationss.controller to javafx.fxml;

    exports xml1.gestionformationss;
}
