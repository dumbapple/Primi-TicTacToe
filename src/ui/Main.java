package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner playerInput = new Scanner(System.in);

        System.out.println("Greetings! I am Primi-TicTacToe, the primitive text-based TicTacToe game!" + "\n" +
                "To play, take turns entering the position you'd like to put your shape on (see below)" + "\n" +
                "one    two     three" + "\n" +
                "four   five    six" + "\n" +
                "seven  eight   nine");

        Player playerOne = new Player();
        Player playerTwo = new Player();
        Board gameBoard = new Board();
        GameState gameState = new GameState(gameBoard);
        gameState.addPlayer(playerOne);
        gameState.addPlayer(playerTwo);
        Position one = new Position("one");
        Position two = new Position("two");
        Position three = new Position("three");
        Position four = new Position("four");
        Position five = new Position("five");
        Position six = new Position("six");
        Position seven = new Position("seven");
        Position eight = new Position("eight");
        Position nine = new Position("nine");
        gameBoard.addPositionToBoard(one);
        gameBoard.addPositionToBoard(two);
        gameBoard.addPositionToBoard(three);
        gameBoard.addPositionToBoard(four);
        gameBoard.addPositionToBoard(five);
        gameBoard.addPositionToBoard(six);
        gameBoard.addPositionToBoard(seven);
        gameBoard.addPositionToBoard(eight);
        gameBoard.addPositionToBoard(nine);
        Shape circle = new Circle();
        Shape cross = new Cross();


        System.out.println("Player 1: Please choose your shape (enter 'circle' or 'cross')!");
        String playerOneShape = playerInput.next();

        if (playerOneShape.equals("circle")) {
            circle.setAssociatedPlayer(playerOne);
            playerOne.setSelectedShape(circle);
            System.out.println("You have chosen to be 'circle'. Player 2 shall be 'cross'!");
            cross.setAssociatedPlayer(playerTwo);
            playerTwo.setSelectedShape(cross);
        } else {
            circle.setAssociatedPlayer(playerTwo);
            playerTwo.setSelectedShape(circle);
            System.out.println("You have chosen to be 'cross'. Player 2 shall be 'circle'!");
            cross.setAssociatedPlayer(playerOne);
            playerOne.setSelectedShape(cross);
        }

        List<Position> r1 = new ArrayList<>();
        r1.add(one);
        r1.add(two);
        r1.add(three);

        List<Position> r2 = new ArrayList<>();
        r2.add(four);
        r2.add(five);
        r2.add(six);

        List<Position> r3 = new ArrayList<>();
        r3.add(seven);
        r3.add(eight);
        r3.add(nine);

        List<Position> c1 = new ArrayList<>();
        c1.add(one);
        c1.add(four);
        c1.add(seven);

        List<Position> c2 = new ArrayList<>();
        c2.add(three);
        c2.add(six);
        c2.add(nine);

        List<Position> c3 = new ArrayList<>();
        c3.add(one);
        c3.add(four);
        c3.add(seven);

        List<Position> d1 = new ArrayList<>();
        d1.add(one);
        d1.add(six);
        d1.add(eight);

        List<Position> d2 = new ArrayList<>();
        d2.add(two);
        d2.add(six);
        d2.add(seven);


        while (gameState.isGameOver() == false) {
            System.out.println("Player One's turn:");
            String playerOneMove = playerInput.next();

            for (Position position : gameBoard.getBoardPositions()) {
                if (playerOneMove.equals(position.getName()) && position.getFilledStatus() == false) {
                    gameState.addShapeToBoard(playerOne.getSelectedShape());
                    position.setShape(playerOne.getSelectedShape());
                    playerOne.getSelectedShape().setSpotOccupying(position);
                    position.setFilled();
                }
            }

            System.out.println("Player 2's turn");
            String playerTwoMove = playerInput.next();

            for (Position position : gameBoard.getBoardPositions()) {
                if (playerTwoMove.equals(position.getName()) && position.getFilledStatus() == false) {
                    gameState.addShapeToBoard(playerOne.getSelectedShape());
                    position.setShape(playerOne.getSelectedShape());
                    playerOne.getSelectedShape().setSpotOccupying(position);
                    position.setFilled();
                }
            }

            // check if win condition is met
            for (Position position : ) {
                if (position.getFilledStatus() == true && ) {
                    gameState.setGameOver();
                }
            }
            for (Position position : r2) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : r3) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : c1) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : c2) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : c3) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : d1) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            for (Position position : d2) {
                if (position.getFilledStatus() == true) {
                    gameState.setGameOver();
                }
            }
            if (gameState.getPositionsFilled() == 9) {
                gameBoard.setBoardFull();
                gameState.setGameOver();
            }



        }
        if (gameState.getPositionsFilled() == 9) {
            gameBoard.setBoardFull();
        }
        gameState.setGameOver();
        System.out.println("Game over!");
    }
}

