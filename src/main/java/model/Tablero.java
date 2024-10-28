package model;

//Maneja las posiciones de las piezas y sus movimientos
public class Tablero {
    private Pieza[][] casilla = new Pieza[8][8];

    /*Inicializa las posiciones iniciales de todas las piezas en el tablero*/
    void inicializarTablero() {
        // Coloca las piezas negras
        casilla[0][0] = new Torre("black");
        casilla[0][1] = new Caballo("black");
        casilla[0][2] = new Alfil("black");
        casilla[0][3] = new Reina("black");
        casilla[0][4] = new Rey("black");
        casilla[0][5] = new Alfil("black");
        casilla[0][6] = new Caballo("black");
        casilla[0][7] = new Torre("black");

        for (int i = 0; i < 8; i++) {
            casilla[1][i] = new Peon("black"); // Peones negros
            casilla[6][i] = new Peon("white"); // Peones blancos
        }

        // Coloca las piezas blancas
        casilla[7][0] = new Torre("white");
        casilla[7][1] = new Caballo("white");
        casilla[7][2] = new Alfil("white");
        casilla[7][3] = new Reina("white");
        casilla[7][4] = new Rey("white");
        casilla[7][5] = new Alfil("white");
        casilla[7][6] = new Caballo("white");
        casilla[7][7] = new Torre("white");
    }
    /*Verifica si una posición está dentro de los límites del tablero.*/
    boolean dentroDelTablero(int x, int y){
        boolean res=x >= 0 && x < 8 && y >= 0 && y < 8;
        return res;
    }

    /*Mueve una pieza de una posición inicial a una posición final si el movimiento es válido.*/
    boolean moverPieza(int x1, int y1, int x2, int y2) {
        boolean res=false;
        // Verifica si las coordenadas están dentro de los límites del tablero
        if (!dentroDelTablero(x1, y2) || !dentroDelTablero(x2, y2)) {
            res = false;
        }

        // Verifica si hay una pieza en la posición inicial
        Pieza pieza = casilla[x1][y1];
        if (pieza == null) {
            res=false; // No hay pieza para mover
        }

        // Verifica si el movimiento es válido para esa pieza
        if (pieza.movimientoValido(x1, y1, x2, y2)) {
            // Verifica si hay una pieza del mismo color en la posición de destino
            Pieza piezaDestino = casilla[x2][y2];
            if (piezaDestino == null || !piezaDestino.getColor().equals(pieza.getColor())) {
                // Realiza el movimiento
                casilla[x2][y2] = pieza;
                casilla[x1][y1] = null;
                res= true;
            }
        }
        return res; // Movimiento no válido o posición de destino ocupada por pieza del mismo color
    }

    /*Devuelve la pieza en una posición específica del tablero.*/

    public Pieza getPieza(int x, int y){
        Pieza pieza=null;
        if (dentroDelTablero(x, y)) {
            pieza=casilla[x][y];
        }
        return pieza;
    }
    public void setPieza(int fila, int col, Pieza pieza) {
        casilla[fila][col] = pieza; // Coloca la pieza en la posición especificada
    }


}
