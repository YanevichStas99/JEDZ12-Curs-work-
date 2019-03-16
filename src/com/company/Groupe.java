package com.company;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Groupe implements Shape  {
    protected GraphicsContext gc;
    protected int count;

    public List<Shape> getShapes() {
        return shapes;
    }

    private List<Shape> shapes = new ArrayList<>();


    public Groupe(GraphicsContext gc, int count) {
        this.gc = gc;
        this.count = count;
    }

    public void addToGroup(Shape shape) {

        shape.setCount(count);
        shapes.add(shape);
    }

    @Override
    public Object copy() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public void draw() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    @Override
    public void moveRight() {
        for (Shape shape : shapes) {
            shape.moveRight();
        }
    }

    @Override
    public void moveLeft() {
        for (Shape shape : shapes) {
            shape.moveLeft();
        }
    }

    @Override
    public void moveUp() {
        for (Shape shape : shapes) {
            shape.moveUp();
        }
    }

    @Override
    public void moveDown() {
        for (Shape shape : shapes) {
            shape.moveDown();
        }
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void increaseSize() {
        for (Shape shape : shapes) {
            shape.increaseSize();
        }
    }

    @Override
    public void decreaseSize() {
        for (Shape shape : shapes) {
            shape.decreaseSize();
        }
    }

    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public int getDIAMETER() {
        return 0;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
        for(Shape shape:shapes){
            shape.setCount(count);
        }
    }
}
