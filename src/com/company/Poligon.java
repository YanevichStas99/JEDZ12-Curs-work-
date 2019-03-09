package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Poligon extends Figgure {
    public Poligon(GraphicsContext gc, double x, double y, int count) {
        super(gc, x, y, count);
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
}
