package com.company;

import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Poligon extends Figgure implements Cloneable{
    @Expose
    private String type="Poligon";


    public Poligon(GraphicsContext gc, double x, double y, int count) {
        super(gc, x, y, count);
    }

    public Poligon(GraphicsContext gc, double x, double y, int DIAMETER, int count) {
        super(gc, x, y, DIAMETER, count);
    }

    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void draw() {
        double[] xPoints = {x, x + DIAMETER / 2, x + DIAMETER};
        double[] yPoints = {y + DIAMETER, y, y + DIAMETER};
        if (Board.getNumber() == count) {
            gc.setFill(Color.BLUE);
            gc.fillPolygon(xPoints, yPoints, 3);
        }
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.strokePolygon(xPoints, yPoints, 3);

    }

    @Override
    public void addToGroup(Shape shape) {

    }

    @Override
    public String toString() {
        return "Poligon{" +
                "gc=" + gc +
                ", x=" + x +
                ", y=" + y +
                ", DIAMETER=" + DIAMETER +
                ", count=" + count +
                '}';
    }
}
