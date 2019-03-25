package com.company;

import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Figgure implements Cloneable{
    @Expose
    private String type="Square";


    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Square(GraphicsContext gc, double x, double y, int count) {
        super(gc, x, y, count);
    }

    public Square(GraphicsContext gc, double x, double y, int DIAMETER, int count) {
        super(gc, x, y, DIAMETER, count);
    }

    @Override
    public void draw() {
        if (Board.getNumber() == count) {
            gc.setFill(Color.GREEN);
            gc.fillRect(x, y, DIAMETER, DIAMETER);
        }
        gc.setStroke(Color.GREEN);
        gc.setLineWidth(2);

        gc.strokeRect(x, y, DIAMETER, DIAMETER);
    }

    @Override
    public void addToGroup(Shape shape) {

    }

    @Override
    public String toString() {
        return "Square{" +
                "gc=" + gc +
                ", x=" + x +
                ", y=" + y +
                ", DIAMETER=" + DIAMETER +
                ", count=" + count +
                '}';
    }
}
