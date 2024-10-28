package model;
/*Clase modelo que extendera las demas piezas del ajedrez*/
public abstract class Pieza {
    protected String color;

    public Pieza(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    abstract boolean movimientoValido(int x1, int y1, int x2, int y2);
}
