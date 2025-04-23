package org.example.empresati;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/empresati/solicitacao.fxml"));
        Parent root = loader.load();
        stage.setTitle("Solicitação de Equipamento");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}