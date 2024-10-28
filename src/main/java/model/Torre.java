package model;

public class Torre extends Pieza{
    public Torre(String color) {
        super(color);
    }

    @Override
    boolean movimientoValido(int x1, int y1, int x2, int y2) {
        boolean res=(x1==x2 || y1==y2);
        return res;
    }
}
