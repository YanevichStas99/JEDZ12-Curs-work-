package com.company;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball extends Figgure {


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


}
