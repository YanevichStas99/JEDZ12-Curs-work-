package com.company;

public interface Shape {
    void draw();
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveDown();
    int getCount();
    void increaseSize();
    void decreaseSize();
    double getX();
    double getY();
    int getDIAMETER();
    void setCount(int count);
    void addToGroup(Shape shape);
    Object copy() throws CloneNotSupportedException;
}
