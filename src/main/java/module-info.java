module org.example.empresati {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.empresati to javafx.fxml;
    exports org.example.empresati;
}