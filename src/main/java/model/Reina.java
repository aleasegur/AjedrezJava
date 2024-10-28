package model;

public class Reina extends Pieza{
    public Reina(String color) {
        super(color);
    }

    @Override
    boolean movimientoValido(int x1, int y1, int x2, int y2) {
        boolean res;
        int dx=Math.abs(x2-x1);
        int dy=Math.abs(y2-y1);
        res=(x1==x2 || y1==y2) || (dx==dy);
        return res;
    }
}
