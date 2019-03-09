package com.company;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Figgure {
    public Square(GraphicsContext gc, double x, double y, int count) {
        super(gc, x, y, count);
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
}
