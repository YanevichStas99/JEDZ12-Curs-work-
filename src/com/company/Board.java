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
    private List<Groupe> groupes = new ArrayList<>();
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
        if (number - 1 > 0) {
            number--;
        } else {
            if (count - 1 > 0) {
                number = count - 1;
            }
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

    public void delete() {
        for (Shape shape : shapes) {
            if (shape.getCount() == number) {
                shapes.remove(shape);
                count--;
                int tmpCount = 1;
                for (Shape shape1 : shapes) {
                    shape1.setCount(tmpCount);
                    tmpCount++;
                }
                number = count - 1;
                break;
            }
        }
    }

    public void group(double currentX, double currentY) {
        boolean x = false;
        for (Shape shape : shapes) {
            if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {
                    Shape tmpShape = null;
                    for (Shape shape1 : shapes) {
                        if (shape1.getCount() == number) {
                            tmpShape = shape1;
                        }
                    }
                    if (tmpShape.getClass() == Groupe.class) {
                        System.out.println("group");
                        tmpShape.addToGroup(shape);
                        shapes.remove(shape);
                        count--;
                        int tmpCount = 1;
                        for (Shape shape1 : shapes) {
                            shape1.setCount(tmpCount);
                            tmpCount++;
                        }
                    } else {
                        System.out.println("not group");
                        Groupe groupe = new Groupe(gc, count);
                        groupe.addToGroup(shape);
                        groupe.addToGroup(tmpShape);
                        shapes.remove(shape);
                        shapes.remove(tmpShape);
                        shapes.add(groupe);
                        groupes.add(groupe);
                        count--;
                        int tmpCount = 1;
                        for (Shape shape1 : shapes) {
                            shape1.setCount(tmpCount);
                            tmpCount++;
                        }
                    }
                    number = count - 1;
                    clear();
                    draw();
                    x = true;
                    break;
                }
            }
        }
        if (!x) {
            Shape current = null;
            for (Shape shape : shapes) {
                if (shape.getCount() == number) {
                    current = shape;
                    break;
                }
            }
            if (current.getClass() == Ball.class || current.getClass() == Square.class || current.getClass() == Poligon.class) {
                Groupe tmpGroup = new Groupe(gc, count);
                for (Groupe groupe : groupes) {
                    List<Shape> shapes = groupe.getShapes();
                    for (Shape shape : shapes) {
                        if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                            if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {
                                groupe.addToGroup(current);
                                this.shapes.remove(current);
                                count--;
                                int tmpCount = 1;
                                for (Shape shape1 : this.shapes) {
                                    shape1.setCount(tmpCount);
                                    tmpCount++;
                                }
                                number = count - 1;
                                clear();
                                draw();
                                return;
                            }
                        }
                    }
                }
            } else {
                Groupe tmpGroup = null;
                for (Groupe groupe : groupes) {
                    if (groupe.getCount() == number) {
                        tmpGroup = groupe;
                    }
                }
                for (Groupe groupe : groupes) {
                    List<Shape> shapes = groupe.getShapes();
                    for (Shape shape : shapes) {
                        if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                            if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {
                                for (Shape shape1 : shapes) {
                                    tmpGroup.addToGroup(shape1);
                                }
                                this.shapes.remove(groupe);
                                this.groupes.remove(groupe);
                                count--;
                                int tmpCount = 1;
                                for (Shape shape1 : this.shapes) {
                                    shape1.setCount(tmpCount);
                                    tmpCount++;
                                }
                                number = count - 1;
                                clear();
                                draw();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    public void copy(double currentX, double currentY) throws CloneNotSupportedException {
        Shape tmpShape = null;
        for (Shape shape1 : shapes) {
            if (shape1.getCount() == number) {
                tmpShape = shape1;
            }
        }
        for (Shape shape : shapes) {
            if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {

                    Groupe groupe = new Groupe(gc, count);
                    Shape shape1 = (Shape) shape.copy();
                    groupe.addToGroup(shape1);
                    Groupe tmpGroup = null;
                    if (tmpShape.getClass() == Groupe.class) {
                        for (Groupe groupe1 : groupes) {
                            if (groupe1.getCount() == number) {
                                tmpGroup = groupe1;
                            }
                        }
                        List<Shape> shapeList = tmpGroup.getShapes();
                        for (Shape shape3 : shapeList) {
                            Shape tmp = (Shape) shape3.copy();
                            groupe.addToGroup(tmp);
                        }
                    } else {
                        Shape shape2 = (Shape) tmpShape.copy();
                        groupe.addToGroup(shape2);
                    }
                    this.shapes.add(groupe);
                    this.groupes.add(groupe);
                    count++;
                    number = count - 1;
                    clear();
                    draw();
                    return;
                }
            }

        }
        for (Groupe groupe : groupes) {
            List<Shape> shapes = groupe.getShapes();
            for (Shape shape : shapes) {
                if (currentX > shape.getX() && currentX < shape.getX() + shape.getDIAMETER()) {
                    if (currentY > shape.getY() && currentY < shape.getY() + shape.getDIAMETER()) {
                        Groupe groupe1 = new Groupe(gc, count);
                        for (Shape shape1:shapes){
                            Shape tmp = (Shape) shape1.copy();
                            groupe1.addToGroup(tmp);
                        }
                        Groupe tmpGroup = null;
                        if (tmpShape.getClass() == Groupe.class) {
                            for (Groupe groupe2 : groupes) {
                                if (groupe2.getCount() == number) {
                                    tmpGroup = groupe2;
                                }
                            }
                            List<Shape> shapeList = tmpGroup.getShapes();
                            for (Shape shape3 : shapeList) {
                                Shape tmp = (Shape) shape3.copy();
                                groupe1.addToGroup(tmp);
                            }
                        } else {
                            Shape shape2 = (Shape) tmpShape.copy();
                            groupe1.addToGroup(shape2);
                        }
                        this.shapes.add(groupe1);
                        this.groupes.add(groupe1);
                        count++;
                        number = count - 1;
                        clear();
                        draw();
                        return;
                    }
                }
            }
        }
    }
}

