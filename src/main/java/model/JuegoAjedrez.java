package model;

public class JuegoAjedrez {
    private Tablero tablero;
    private String turno;

    public JuegoAjedrez() {
        tablero = new Tablero();
        turno = "blanco";
    }

    /*Metodo que cambia el turno del jugador actual*/
    void cambiarTurno() {
        turno = turno.equals("white") ? "black" : "white";
    }
    /*Devuelve el color del jugador que tiene el turno actual.*/
    public String getTurno() {
        return turno;
    }

    /*Devuelve el tablero actual del juego*/
    public Tablero getTablero(){
        return tablero;
    }

    /*Realiza un movimiento de una pieza en el tablero*/
    public boolean moverPieza(int x1, int y1, int x2, int y2) {
        boolean res = false, movimientoValido;
        // Verifica si el movimiento es válido
        Pieza pieza = tablero.getPieza(x1, y1);
        if (pieza != null && pieza.getColor().equals(turno)) {
            // Intenta mover la pieza
            movimientoValido = tablero.moverPieza(x1, y1, x2, y2);
            if (movimientoValido) {
                // Cambia el turno si el movimiento fue exitoso
                cambiarTurno();
                res = true;
            }
        }
        return res; // Movimiento no válido
    }

    void inicializarPiezas() {
        // Inicializa las piezas blancas
        tablero.setPieza(1, 0, new Torre("white"));
        tablero.setPieza(1, 1, new Caballo("white"));
        tablero.setPieza(1, 2, new Alfil("white"));
        tablero.setPieza(1, 3, new Reina("white"));
        tablero.setPieza(1, 4, new Rey("white"));
        tablero.setPieza(1, 5, new Alfil("white"));
        tablero.setPieza(1, 6, new Caballo("white"));
        tablero.setPieza(1, 7, new Torre("white"));

        // Inicializa los peones blancos
        for (int col = 0; col < 8; col++) {
            tablero.setPieza(0, col, new Peon("white"));
        }

        // Inicializa las piezas negras (similar a las blancas)
        tablero.setPieza(6, 0, new Torre("black"));
        tablero.setPieza(6, 1, new Caballo("black"));
        tablero.setPieza(6, 2, new Alfil("black"));
        tablero.setPieza(6, 3, new Reina("black"));
        tablero.setPieza(6, 4, new Rey("black"));
        tablero.setPieza(6, 5, new Alfil("black"));
        tablero.setPieza(6, 6, new Caballo("black"));
        tablero.setPieza(6, 7, new Torre("black"));

        // Inicializa los peones negros
        for (int col = 0; col < 8; col++) {
            tablero.setPieza(7, col, new Peon("black"));
        }
    }

}
