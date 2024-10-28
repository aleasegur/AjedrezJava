package controller;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.JuegoAjedrez;
import model.Pieza;

import java.io.InputStream;

public class Controller {

    @FXML
    private GridPane gridPane; // Referencia al GridPane definido en FXML

    private JuegoAjedrez juego; // Instancia del juego de ajedrez

    @FXML
    public void initialize() {
        juego = new JuegoAjedrez(); // Inicializa el juego
        dibujarTablero(); // Dibuja el tablero y coloca las piezas
    }

    public void dibujarTablero() {
        gridPane.getChildren().clear(); // Limpia el tablero para redibujar

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Crear casilla
                Rectangle casilla = new Rectangle(60, 60);
                casilla.setFill((i + j) % 2 == 0 ? Color.BEIGE : Color.BROWN);

                final int fila = i;
                final int col = j;
                casilla.setOnMouseClicked(event -> manejarMovimiento(fila, col));

                gridPane.add(casilla, j, i); // Añade la casilla al GridPane
                dibujarPieza(fila, col); // Coloca la pieza en la casilla
            }
        }
    }

    public void manejarMovimiento(int fila, int col) {
        System.out.println("Movimiento en fila: " + fila + ", columna: " + col);
        // Aquí iría la lógica para mover piezas en el tablero
    }

    public void dibujarPieza(int fila, int col) {
        Pieza pieza = juego.getTablero().getPieza(fila, col); // Obtiene la pieza en la posición específica

        if (pieza != null) {
            String imagenPath = obtenerNombreArchivo(pieza); // Ruta de la imagen de la pieza
            InputStream inputStream = getClass().getResourceAsStream(imagenPath);

            if (inputStream != null) {
                Image imagen = new Image(inputStream);
                ImageView imageView = new ImageView(imagen);
                imageView.setFitWidth(60);
                imageView.setFitHeight(60);

                gridPane.add(imageView, col, fila); // Coloca la imagen en la posición adecuada
            } else {
                System.out.println("No se encontró la imagen en la ruta: " + imagenPath);
            }
        }
    }

    public String obtenerNombreArchivo(Pieza pieza) {
        String nombreClase = pieza.getClass().getSimpleName().toLowerCase(); // Obtiene el nombre de la clase
        String color = pieza.getColor().toLowerCase(); // Obtiene el color de la pieza
        return "/com/example/ajedrezjava/images/" + nombreClase + "_" + color + ".png";
    }

    @FXML
    public void reiniciarJuego() {
        juego.reiniciar();
        dibujarTablero(); // Redibuja el tablero y las piezas
    }
}
