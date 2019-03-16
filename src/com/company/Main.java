package com.company;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {

    private static final int BOARD_WIDTH = 1000;
    private static final int BOARD_HEIGHT = 750;
    private Board board;
    private int x = 10;
    private int y = 10;
    private GraphicsContext gc;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(String.valueOf(Board.getNumber()));
        Canvas canvas = new Canvas();
        canvas.setWidth(BOARD_WIDTH);
        canvas.setHeight(BOARD_HEIGHT);
        BorderPane group = new BorderPane(canvas);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
        primaryStage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        board = new Board(gc);
        board.draw();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.DIGIT1) {
                    System.out.println("1");
                    board.addBall();
                }
                if (event.getCode() == KeyCode.DIGIT2) {
                    System.out.println("2");
                    board.addSquare();
                }
                if (event.getCode() == KeyCode.DIGIT3) {
                    System.out.println("3");
                    board.addPolygon();
                }
                if (event.getCode() == KeyCode.LEFT) {
                    System.out.println("LEFT");
                    board.moveLeft();
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    System.out.println("RIGHT");
                    board.moveRight();
                }
                if (event.getCode() == KeyCode.UP) {
                    System.out.println("UP");
                    board.moveUp();
                }
                if (event.getCode() == KeyCode.DOWN) {
                    System.out.println("DOWN");
                    board.moveDown();
                }
                if (event.getCode() == KeyCode.PAGE_DOWN) {
                    board.numberDawn();
                }
                if (event.getCode() == KeyCode.PAGE_UP) {
                    board.numberUp();
                }
                if (event.getCode() == KeyCode.Q) {
                    board.increaseSize();
                }
                if (event.getCode() == KeyCode.W) {
                    board.decreaseSize();
                }
                if(event.getCode()==KeyCode.DELETE){
                    board.delete();
                }
                board.clear();
                board.draw();
                primaryStage.setTitle(String.valueOf(Board.getNumber()));
            }
        });
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isControlDown() && event.getButton() == MouseButton.PRIMARY) {
                    board.group(event.getX(), event.getY());
                }
                if (event.isShiftDown() && event.getButton()==MouseButton.PRIMARY){
                    try {
                        board.copy(event.getX(), event.getY());
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }


}