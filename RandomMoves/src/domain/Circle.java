package domain;

public class Circle {

    private int yAxis;
    private int xAxis;
    private int width;
    private int height;

    public Circle() {
        this.yAxis = 0;
        this.xAxis = 0;
        this.width = 0;
        this.height = 0;
    }

    public void setyAxis(int laFila) {
        yAxis = laFila;
    }

    public void setxAxis(int laColumna) {
        xAxis = laColumna;
    }

    public void setWidth(int elAncho) {
        width = elAncho;
    }

    public void setHeight(int elAlto) {
        height = elAlto;
    }

    public int getyAxis() {
        return yAxis;
    }

    public int getxAxis() {
        return xAxis;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
