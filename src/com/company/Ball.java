package com.company;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Figgure implements Cloneable {

    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Ball(GraphicsContext gc, double x, double y, int count) {
        super(gc, x, y, count);
    }

    @Override
    public void draw() {
        if (Board.getNumber() == count) {
            gc.setFill(Color.RED);
            gc.fillOval(x, y, DIAMETER, DIAMETER);
        }
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        gc.strokeOval(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void addToGroup(Shape shape) {}

    @Override
    public String toString() {
        return "Ball{" +
                "gc=" + gc +
                ", x=" + x +
                ", y=" + y +
                ", DIAMETER=" + DIAMETER +
                ", count=" + count +
                '}';
    }

}
