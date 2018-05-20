package ui;


import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        Player p1 = new Player();
        Player p2 = new Player();

        Shape circle = new Shape();
        Shape cross = new Shape();

        System.out.println("Player 1: Please choose your shape (enter 'circle' or 'cross'");
        String playerOneShape = input.next();

        if (playerOneShape.equals("circle")) {
            circle.setAssociatedPlayer(p1);
            p1.setSelectedShape(circle);
            System.out.println("You have chosen to be 'circle'. Player 2 shall be 'cross'");
            cross.setAssociatedPlayer(p2);
            p2.setSelectedShape(cross);
        } else if (playerOneShape.equals("cross")) {
            circle.setAssociatedPlayer(p2);
            p2.setSelectedShape(circle);
            System.out.println("You have chosen to be 'cross'. Player 2 shall be 'circle'");
            cross.setAssociatedPlayer(p1);
            p1.setSelectedShape(cross);
        }

        System.out.println("Initializing game board ...");

        Board gameBoard = new Board();

        Position topLeft = new Position();
        Position topRight = new Position();
        Position topMiddle = new Position();
        Position centreLeft = new Position();
        Position centreRight = new Position();
        Position centreMiddle = new Position();
        Position bottomLeft = new Position();
        Position bottomRight = new Position();
        Position bottomMiddle = new Position();


        gameBoard.getBoardPositions().add(topLeft);
        gameBoard.getBoardPositions().add(topRight);
        gameBoard.getBoardPositions().add(topMiddle);
        gameBoard.getBoardPositions().add(centreLeft);
        gameBoard.getBoardPositions().add(centreRight);
        gameBoard.getBoardPositions().add(centreMiddle);
        gameBoard.getBoardPositions().add(bottomLeft);
        gameBoard.getBoardPositions().add(bottomRight);
        gameBoard.getBoardPositions().add(bottomMiddle);

        GameState gameState = new GameState();

        int numSpacesFilled = gameBoard.getNumSpacesFilled();



//        while ((filledSpaces < 9) ||
//                !(topLeft.getStatus() && topMiddle.getStatus() && topRight.getStatus()) ||
//                !(centreLeft.getStatus() && centreMiddle.getStatus() && centreRight.getStatus()) ||
//                !(bottomLeft.getStatus() && bottomMiddle.getStatus() && bottomRight.getStatus()) ||
//
//                !(topLeft.getStatus() && centreLeft.getStatus() && bottomLeft.getStatus()) ||
//                !(bottomRight.getStatus() && centreRight.getStatus() && topRight.getStatus()) ||
//                !(topMiddle.getStatus() && centreMiddle.getStatus() && bottomMiddle.getStatus()) ||
//
//                !(topLeft.getStatus() && centreMiddle.getStatus() && bottomRight.getStatus()) ||
//                !(bottomLeft.getStatus() && centreMiddle.getStatus() && topRight.getStatus())) {
//
//            System.out.println("Player 1's turn");
//            input.next();
//            filledSpaces++;
//            if (filledSpaces == 9) {
//                break;
//            }
//            System.out.println("Player 2's turn");
//            input.next();
//
//        }
//        System.out.println("Main over!");
    }
}
