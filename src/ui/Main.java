package ui;


import model.*;

import java.util.Scanner;

public class Main {

    public static void main(String args[]) {

        Scanner playerInput = new Scanner(System.in);

        System.out.println("Greetings! I am Primi-TicTacToe, the primitive text-based TicTacToe game!" + "\n" +
                "To play, take turns entering the position you'd like to put your shape on (see below)" + "\n" +
                "topLeft        topMiddle          topRight" + "\n" +
                "centreLeft     centreMiddle       centreRight" + "\n" +
                "bottomLeft     bottomMiddle       bottomRight");

        Position topLeft = new Position();
        Position topRight = new Position();
        Position topMiddle = new Position();
        Position centreLeft = new Position();
        Position centreRight = new Position();
        Position centreMiddle = new Position();
        Position bottomLeft = new Position();
        Position bottomRight = new Position();
        Position bottomMiddle = new Position();

        Board gameBoard = new Board();
        gameBoard.getBoardPositions().add(topLeft);
        gameBoard.getBoardPositions().add(topRight);
        gameBoard.getBoardPositions().add(topMiddle);
        gameBoard.getBoardPositions().add(centreLeft);
        gameBoard.getBoardPositions().add(centreRight);
        gameBoard.getBoardPositions().add(centreMiddle);
        gameBoard.getBoardPositions().add(bottomLeft);
        gameBoard.getBoardPositions().add(bottomRight);
        gameBoard.getBoardPositions().add(bottomMiddle);

        Player playerOne = new Player();
        Player playerTwo = new Player();
        Shape circle = new Circle();

        Shape cross;

        GameState gameState = new GameState(gameBoard);
        gameState.addPlayer(playerOne);
        gameState.addPlayer(playerTwo);

        System.out.println("Player 1: Please choose your shape (enter 'circle' or 'cross')!");
        String playerOneShape = playerInput.next();

        if (playerOneShape.equals("circle")) {
            circle.setAssociatedPlayer(playerOne);
            playerOne.setSelectedShape(circle);
            System.out.println("You have chosen to be 'circle'. Player 2 shall be 'cross'!");
            cross.setAssociatedPlayer(playerTwo);
            playerTwo.setSelectedShape(cross);
        } else if (playerOneShape.equals("cross")) {
            circle.setAssociatedPlayer(playerTwo);
            playerTwo.setSelectedShape(circle);
            System.out.println("You have chosen to be 'cross'. Player 2 shall be 'circle'!");
            cross.setAssociatedPlayer(playerOne);
            playerOne.setSelectedShape(cross);
        }

        int positionsFilled = gameState.getPositionsFilled();

        while (positionsFilled < 9) &&
                 {

            System.out.println("Player One's turn:");
            String move = playerInput.next();
            switch (move) {
                case "topLeft":
                    if (topLeft.getFilledStatus() == false ) {
                        topLeft.setFilled();
                        topLeft.setShape(playerOne.getSelectedShape());
                        gameState.addShapeToBoard(playerOne.getSelectedShape());
                    }
            }

            System.out.println("Player 2's turn");
            playerInput.next();

        }
        gameState.setGameOver();
        System.out.println("Game over!");
    }
}
