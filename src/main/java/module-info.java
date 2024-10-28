module com.example.ajedrezjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.ajedrezjava to javafx.fxml;
    exports com.example.ajedrezjava;
    exports controller;
    opens controller to javafx.fxml;
}