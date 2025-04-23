module org.example.empresati {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports org.example.empresati;
    exports org.example.empresati.controller;
    exports org.example.empresati.dto;
    exports org.example.empresati.model;

    opens org.example.empresati to javafx.fxml, javafx.graphics;
    opens org.example.empresati.controller to javafx.fxml;
    opens org.example.empresati.dto to javafx.base, javafx.fxml;
    opens org.example.empresati.model to javafx.base, javafx.fxml;
}
