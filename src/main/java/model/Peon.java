package model;

public class Peon extends Pieza{
    public Peon(String color) {
        super(color);
    }

    @Override
    boolean movimientoValido(int x1, int y1, int x2, int y2) {
        boolean res=false;
        int direction = color.equals("blanco") ? -1 : 1;
        int dx=x2-x1;
        int dy=y2-y1;
        // Movimiento estándar (una casilla hacia adelante) o captura (una casilla diagonal)
        if (dy == 0 && dx == direction) {
            res=true; // Movimiento de una casilla adelante
        } else if (Math.abs(dy) == 1 && dx == direction) {
            res=true; // Captura en diagonal
        } else if (dy == 0 && dx == 2 * direction && ((color.equals("blanco") && x1== 6) || (color.equals("negro") && x1 == 1))) {
            res=true; // Movimiento inicial de dos casillas
        }
        return res;
    }
}
