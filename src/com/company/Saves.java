package com.company;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public class Saves {
    private int activeNumber;
    private List<ListOfShapes> shapes;


    private class ListOfShapes {
        private String type;
        private double x;
        private double y;
        private int DIAMETER;
        private int count;
        private List<ListOfShapes> shapes;

        public String getType() {
            return type;
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

        public int getCount() {
            return count;
        }

        public List<ListOfShapes> getShapes() {
            return shapes;
        }

        public ListOfShapes(String type, double x, double y, int DIAMETER, int count) {
            this.type = type;
            this.x = x;
            this.y = y;
            this.DIAMETER = DIAMETER;
            this.count = count;
        }

        public ListOfShapes(String type, int count, List<ListOfShapes> shapes) {
            this.type = type;
            this.count = count;
            this.shapes = shapes;
        }
    }

    public Saves(int activeNumber, List<ListOfShapes> shapes) {
        this.activeNumber = activeNumber;
        this.shapes = shapes;
    }

    @Override
    public String toString() {
        return "Saves{" +
                "activeNumber=" + activeNumber +
                ", shapes=" + shapes +
                '}';
    }

    public List<Shape> createShapeList(GraphicsContext gc){
         List<Shape> shapeList=new ArrayList<>();
        for(ListOfShapes shapes1: shapes){
            if (shapes1.getType().equals("Ball")){
                shapeList.add(new Ball(gc,shapes1.getX(),shapes1.getY(),shapes1.getDIAMETER(),shapes1.getCount()));
            }
            if (shapes1.getType().equals("Square")){
                shapeList.add(new Square(gc,shapes1.getX(),shapes1.getY(),shapes1.getDIAMETER(),shapes1.getCount()));
            }
            if (shapes1.getType().equals("Poligon")){
                shapeList.add(new Poligon(gc,shapes1.getX(),shapes1.getY(),shapes1.getDIAMETER(),shapes1.getCount()));
            }
            if(shapes1.getType().equals("Groupe")){
                Groupe groupe=new Groupe(gc,shapes1.getCount());
                for (ListOfShapes shapes2:shapes1.getShapes()){
                    if (shapes2.getType().equals("Ball")){
                        groupe.addToGroup(new Ball(gc,shapes2.getX(),shapes2.getY(),shapes2.getDIAMETER(),shapes2.getCount()));
                    }
                    if (shapes2.getType().equals("Square")){
                        groupe.addToGroup(new Square(gc,shapes2.getX(),shapes2.getY(),shapes2.getDIAMETER(),shapes2.getCount()));
                    }
                    if (shapes2.getType().equals("Poligon")){
                        groupe.addToGroup(new Poligon(gc,shapes2.getX(),shapes2.getY(),shapes2.getDIAMETER(),shapes2.getCount()));
                    }
                }
                shapeList.add(groupe);
            }
        }
        return shapeList;
    }

    public int getActiveNumber() {
        return activeNumber;
    }
}
