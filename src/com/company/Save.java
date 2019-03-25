package com.company;

import com.google.gson.annotations.Expose;
import javafx.scene.canvas.GraphicsContext;

import java.util.List;

public class Save {
    @Expose
    private int activeNumber;
    @Expose
    private List<Shape> shapes;


    public Save(int activeNumber, List<Shape> shapes) {
        this.activeNumber = activeNumber;
        this.shapes = shapes;

    }

    public int getActiveNumber() {
        return activeNumber;
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public String toString() {
        return "Save{" +
                "activeNumber=" + activeNumber +
                ", shapes=" + shapes +
                '}';
    }
}
