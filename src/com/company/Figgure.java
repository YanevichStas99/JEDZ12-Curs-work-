package com.company;

import javafx.scene.canvas.GraphicsContext;

public abstract class Figgure implements Shape {
    protected GraphicsContext gc;
    protected double x;
    protected double y;
    protected int DIAMETER = 20;
    protected int count;

    public Figgure(GraphicsContext gc, double x, double y, int count) {
        this.gc = gc;
        this.x = x;
        this.y = y;
        this.count = count;
    }

    @Override
    public void moveRight() {
        if (x < gc.getCanvas().getWidth() - DIAMETER) {
            x = x + 5;
        }
    }

    @Override
    public void moveLeft() {
        if (x > 0) {
            x = x - 5;
        }
    }

    @Override
    public void moveUp() {
        if (y > 0) {
            y = y - 5;
        }
    }

    @Override
    public void moveDown() {
        if (y < gc.getCanvas().getHeight() - 30) {
            y = y + 5;
        }
    }

    public int getCount() {
        return count;
    }

    public void increaseSize() {
        if (DIAMETER + 5 < 100) {
            DIAMETER = DIAMETER + 5;
        }
    }
    public void decreaseSize() {
        if (DIAMETER -5 >15) {
            DIAMETER = DIAMETER - 5;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDIAMETER() {
        return DIAMETER;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
