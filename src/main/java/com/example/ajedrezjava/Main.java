package com.example.ajedrezjava;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();

        // Crea una escena con el nodo raíz cargado desde FXML
        Scene scene = new Scene(root, 480, 480); // Puedes ajustar el tamaño según tus necesidades

        // Configura el título de la ventana
        primaryStage.setTitle("Ajedrez");
        primaryStage.setScene(scene);
        primaryStage.show(); // Muestra la ventana
    }

    public static void main(String[] args) {
        launch(args); // Lanza la aplicación

    }
}
