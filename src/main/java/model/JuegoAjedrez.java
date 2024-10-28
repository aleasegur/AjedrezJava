package model;

public class JuegoAjedrez {
    private Tablero tablero;
    private String turno;

    public JuegoAjedrez() {
        tablero = new Tablero();
        turno = "blanco";
        inicializarPiezas();
    }

    public void reiniciar() {
        tablero = new Tablero(); // Reinicia el tablero
        inicializarPiezas(); // Coloca las piezas en sus posiciones iniciales
    }

    /*Metodo que cambia el turno del jugador actual*/
    void cambiarTurno() {
        turno = turno.equals("blanco") ? "negro" : "blanco";
    }
    /*Devuelve el color del jugador que tiene el turno actual.*/
    public String getTurno() {
        return turno;
    }

    /*Devuelve el tablero actual del juego*/
    public Tablero getTablero(){
        return tablero;
    }

    public boolean moverPieza(int x1, int y1, int x2, int y2) {
        boolean res = false;
        // Verifica si el movimiento es válido
        Pieza pieza = tablero.getPieza(x1, y1);
        if (pieza != null && pieza.getColor().equals(turno)) {
            // Intenta mover la pieza
            boolean movimientoValido = tablero.moverPieza(x1, y1, x2, y2);
            if (movimientoValido) {
                // Cambia el turno si el movimiento fue exitoso
                cambiarTurno();
                res = true; // Movimiento exitoso
            }
        }
        return res; // Retorna false si el movimiento no fue válido
    }

    public void inicializarPiezas() {
        // Posiciona las piezas negras en la fila 0 (torre, caballo, alfil, reina, rey, alfil, caballo, torre)
        tablero.setPieza(0, 0, new Torre("negro"));
        tablero.setPieza(0, 1, new Caballo("negro"));
        tablero.setPieza(0, 2, new Alfil("negro"));
        tablero.setPieza(0, 3, new Reina("negro"));
        tablero.setPieza(0, 4, new Rey("negro"));
        tablero.setPieza(0, 5, new Alfil("negro"));
        tablero.setPieza(0, 6, new Caballo("negro"));
        tablero.setPieza(0, 7, new Torre("negro"));

        // Posiciona los peones negros en la fila 1
        for (int i = 0; i < 8; i++) {
            tablero.setPieza(1, i, new Peon("negro"));
        }

        // Posiciona las piezas blancas en la fila 7 (torre, caballo, alfil, reina, rey, alfil, caballo, torre)
        tablero.setPieza(7, 0, new Torre("blanco"));
        tablero.setPieza(7, 1, new Caballo("blanco"));
        tablero.setPieza(7, 2, new Alfil("blanco"));
        tablero.setPieza(7, 3, new Reina("blanco"));
        tablero.setPieza(7, 4, new Rey("blanco"));
        tablero.setPieza(7, 5, new Alfil("blanco"));
        tablero.setPieza(7, 6, new Caballo("blanco"));
        tablero.setPieza(7, 7, new Torre("blanco"));

        // Posiciona los peones blancos en la fila 6
        for (int i = 0; i < 8; i++) {
            tablero.setPieza(6, i, new Peon("blanco"));
        }
    }


}
