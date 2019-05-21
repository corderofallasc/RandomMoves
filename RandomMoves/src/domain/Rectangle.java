package domain;

public class Rectangle {

    private int yAxis;
    private int xAxis;
    private int width;
    private int height;

    public Rectangle() {
        this.yAxis = 0;
        this.xAxis = 0;
        this.width = 0;
        this.height = 0;
    }
    
    

    public int getxAxis() {
        return xAxis;
    }

    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getyAxis() {
        return yAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
