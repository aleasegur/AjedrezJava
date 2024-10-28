package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.JuegoAjedrez;
import model.Pieza;

import java.io.InputStream; // Para InputStream

import javafx.scene.image.Image; // Para Image
import javafx.scene.image.ImageView; // Para ImageView

public class Controller {

    @FXML
    private GridPane gridPane; // El tablero en el que se dibujan las piezas

    private JuegoAjedrez juego;
    private boolean seleccionInicial = false;
    private int xInicial, yInicial;

    public void initialize() {
        juego = new JuegoAjedrez(); // Inicializa el juego
        dibujarPiezas();
        inicializarTablero(); // Dibuja el tablero
    }

    /* Inicializa el tablero en la interfaz gráfica.*/
    public void inicializarTablero() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Rectangle rectangulo = new Rectangle(60, 60);
                if ((i + j) % 2 == 0) {
                    rectangulo.setFill(Color.BEIGE); // Color de las casillas blancas
                } else {
                    rectangulo.setFill(Color.BROWN); // Color de las casillas negras
                }

                final int fila = i;
                final int col = j;


                rectangulo.setOnMouseClicked(event -> manejarMovimiento(fila, col)); // Maneja el movimiento al hacer clic
                gridPane.add(rectangulo, j, i); // Agrega el rectángulo al GridPane

                // Dibuja las piezas
                dibujarPieza(fila, col);
            }
        }
    }

    /*Dibuja las piezas en el tablero según su posición.*/
    public void dibujarPieza(int fila, int col) {
        System.out.println("dibujarPieza llamada para fila: " + fila + ", col: " + col);
        Pieza pieza = juego.getTablero().getPieza(fila, col); // Obtiene la pieza del tablero

        if (pieza != null) { // Verifica si hay una pieza en la posición
            String nombrePieza = pieza.getClass().getSimpleName().toLowerCase(); // Convierte el nombre de la clase a minúsculas
            String color = pieza.getColor(); // Obtiene el color directamente (debería ser "white" o "black")

            // Construye la ruta de la imagen
            String imagenPath = "/com/example/ajedrezjava/images/" + nombrePieza + "_" + color + ".png";
            System.out.println("Ruta de imagen construida: " + imagenPath); // Imprimir ruta para depuración

            InputStream inputStream = getClass().getResourceAsStream(imagenPath); // Intenta cargar la imagen
            if (inputStream != null) {
                Image imagen = new Image(inputStream); // Carga la imagen
                ImageView imageView = new ImageView(imagen); // Crea un ImageView para la imagen
                imageView.setFitWidth(60); // Establece el ancho
                imageView.setFitHeight(60); // Establece la altura
                gridPane.add(imageView, col, fila); // Agrega la imagen al GridPane
            } else {
                System.out.println("No se encontró la imagen en la ruta: " + imagenPath); // Error si no se encuentra la imagen
            }
        }
    }

    void dibujarPiezas() {
        for (int fila = 0; fila < 8; fila++) {
            for (int col = 0; col < 8; col++) {
                dibujarPieza(fila, col); // Llama al método que dibuja la pieza en la interfaz
            }
        }
    }

    /* Maneja el movimiento de las piezas al hacer clic en las casillas.*/
    public void manejarMovimiento(int fila, int col) {
        if (!seleccionInicial) {
            // Selecciona la pieza inicial
            xInicial = fila;
            yInicial = col;
            seleccionInicial = true;
        } else {
            // Intenta mover la pieza
            if (juego.moverPieza(xInicial, yInicial, fila, col)) {
                // Actualiza el tablero si el movimiento fue exitoso
                gridPane.getChildren().clear(); // Limpia el tablero
                inicializarTablero(); // Redibuja el tablero
            }
            seleccionInicial = false; // Reinicia la selección
        }
    }

    /*Reinicia el juego, restableciendo el estado del tablero.*/
    @FXML
    public void reiniciarJuego() {
        juego = new JuegoAjedrez(); // Reinicia el juego
        gridPane.getChildren().clear(); // Limpia el tablero
        inicializarTablero(); // Redibuja el tablero
    }
}