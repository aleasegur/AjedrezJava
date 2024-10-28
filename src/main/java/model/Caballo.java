package model;

public class Caballo extends Pieza{
    public Caballo(String color) {
        super(color);
    }

    @Override
    boolean movimientoValido(int x1, int y1, int x2, int y2) {
        boolean res;
        int dx=Math.abs(x2-x1);
        int dy=Math.abs(y2-y1);
        res=(dx==2 && dy==1) || (dx==1 && dy==2);
        return res;
    }
}
