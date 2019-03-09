package com.company;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private GraphicsContext gc;
    private int x = 10;
    private int y = 10;
    private int count = 1;
    private List<Shape> shapes = new ArrayList<>();
    private static int number;

    public Board(GraphicsContext gc) {
        this.gc = gc;

    }

    public void draw() {
        clear();
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public void addBall() {
        shapes.add(new Ball(gc, x, y, count));
        count++;
        number = count - 1;
    }

    public void addSquare() {
        shapes.add(new Square(gc, x, y, count));
        count++;
        number = count - 1;
    }

    public void addPolygon() {
        shapes.add(new Poligon(gc, x, y, count));
        count++;
        number = count - 1;
    }

    public void moveRight() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.moveRight();
            }
        }
    }

    public void moveLeft() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.moveLeft();
            }
        }
    }

    public void moveUp() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.moveUp();
            }
        }
    }

    public void moveDown() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.moveDown();
            }
        }
    }

    public void numberDawn() {
        if (number - 1 != 0) {
            number--;
        } else {
            number = count - 1;
        }
    }

    public void numberUp() {
        if (number + 1 < count) {
            number++;
        } else {
            number = 1;
        }
    }

    public static int getNumber() {
        return number;
    }

    public void increaseSize() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.increaseSize();
            }
        }
    }

    public void decreaseSize() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shape.decreaseSize();
            }
        }
    }

    public void group(double currentX, double currentY) {
        for (Shape shape : shapes) {
            if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {
                    shape.setCount(number);
                    //count--;
                    clear();
                    draw();
                }
            }
        }
        /*int tmpCount=1;
        int tmpNumber=0;
        for (Shape shape : shapes) {
            if (shape.getCount() == number && tmpNumber==0) {
                tmpNumber=tmpCount;
                shape.setCount(tmpNumber);
                tmpCount++;
                continue;
            }
            if (shape.getCount() == number) {
                shape.setCount(tmpCount);
            }else {
                shape.setCount(tmpCount);
                tmpCount++;
            }
        }
        number=tmpNumber;
        clear();
        draw();*/
    }
}

