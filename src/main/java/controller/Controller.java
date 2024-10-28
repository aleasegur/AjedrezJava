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
    private Pieza piezaSeleccionada = null;
    private int filaSeleccionada = -1;
    private int colSeleccionada = -1;
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
        Pieza piezaActual = juego.getTablero().getPieza(fila, col); // Obtiene la pieza en la posición actual

        // Si no hay ninguna pieza seleccionada y hay una pieza en la nueva posición
        if (piezaSeleccionada == null && piezaActual != null) {
            piezaSeleccionada = piezaActual; // Selecciona la pieza
            filaSeleccionada = fila;
            colSeleccionada = col;
        } else if (piezaSeleccionada != null) { // Si ya hay una pieza seleccionada
            // Intenta mover la pieza a la nueva posición
            if (juego.getTablero().puedeMover(piezaSeleccionada, fila, col)) {
                // Realiza el movimiento
                juego.getTablero().moverPieza(filaSeleccionada, colSeleccionada, fila, col);
                // Reinicia la selección
                piezaSeleccionada = null;
                filaSeleccionada = -1;
                colSeleccionada = -1;
            } else {
                // Si no puede mover, puedes deseleccionar la pieza
                piezaSeleccionada = null;
                filaSeleccionada = -1;
                colSeleccionada = -1;
            }
            dibujarTablero(); // Redibuja el tablero después del movimiento
        }
    }

    public void dibujarPieza(int fila, int col) {
        Pieza pieza = juego.getTablero().getPieza(fila, col);
        if (pieza != null) {
            String imagenPath = obtenerNombreArchivo(pieza);
            Image image = new Image(getClass().getResourceAsStream(imagenPath));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(60);
            imageView.setFitWidth(60);
            gridPane.add(imageView, col, fila);
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
