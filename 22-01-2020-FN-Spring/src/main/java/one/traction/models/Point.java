package one.traction.models;

public class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x) {
        this.x = x;
    }

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }
    public Integer getY() {
        return this.y;
    }

    public Boolean setX(Integer value) {
        this.x = value;
        return true;
    }
    public Boolean setY(Integer value) {
        this.y = value;
        return true;
    }
}
