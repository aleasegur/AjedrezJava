package model;

public class Alfil extends Pieza{
    public Alfil(String color) {
        super(color);
    }

    @Override
    boolean movimientoValido(int x1, int y1, int x2, int y2) {
        boolean res=Math.abs(x2-x1)==Math.abs(y2-y1);
        return res;
    }
}
