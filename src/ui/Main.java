package ui;


import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.println("Greetings! I am Primi-TicTacToe, the primitive text-based TicTacToe game!");
        System.out.println("");
        System.out.println("To play, take turns entering the position you'd like to put your shape on (see below)");
        System.out.println("");
        System.out.println("topLeft        topMiddle          topRight");
        System.out.println("centreLeft     centreMiddle       centreRight");
        System.out.println("bottomLeft     bottomMiddle       bottomRight");
        System.out.println("");
        System.out.println("Initializing game board ...");
        System.out.println("");

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

        Player p1 = new Player();
        Player p2 = new Player();

        Shape circle = new Shape();
        Shape cross = new Shape();

        System.out.println("Player 1: Please choose your shape (enter 'circle' or 'cross')!");
        String playerOneShape = input.next();

        if (playerOneShape.equals("circle")) {
            circle.setAssociatedPlayer(p1);
            p1.setSelectedShape(circle);
            System.out.println("You have chosen to be 'circle'. Player 2 shall be 'cross'!");
            cross.setAssociatedPlayer(p2);
            p2.setSelectedShape(cross);
        } else if (playerOneShape.equals("cross")) {
            circle.setAssociatedPlayer(p2);
            p2.setSelectedShape(circle);
            System.out.println("You have chosen to be 'cross'. Player 2 shall be 'circle'!");
            cross.setAssociatedPlayer(p1);
            p1.setSelectedShape(cross);
        }



        int numSpacesFilled = gameBoard.getNumSpacesFilled();

        while ((numSpacesFilled < 9) &&
                !(topLeft.getFilledStatus() && topMiddle.getFilledStatus() && topRight.getFilledStatus()) &&
                !(centreLeft.getFilledStatus() && centreMiddle.getFilledStatus() && centreRight.getFilledStatus()) &&
                !(bottomLeft.getFilledStatus() && bottomMiddle.getFilledStatus() && bottomRight.getFilledStatus()) &&

                !(topLeft.getFilledStatus() && centreLeft.getFilledStatus() && bottomLeft.getFilledStatus()) &&
                !(topMiddle.getFilledStatus() && centreMiddle.getFilledStatus() && bottomMiddle.getFilledStatus()) &&
                !(topRight.getFilledStatus() && centreRight.getFilledStatus() && bottomRight.getFilledStatus()) &&

                !(topLeft.getFilledStatus() && centreMiddle.getFilledStatus() && bottomRight.getFilledStatus()) &&
                !(bottomLeft.getFilledStatus() && centreMiddle.getFilledStatus() && topRight.getFilledStatus())) {

            System.out.println("Player One's turn:");
            input.next();
            numSpacesFilled++;
            
            System.out.println("Player 2's turn");
            input.next();

        }
        System.out.println("Game over!");
    }
}
