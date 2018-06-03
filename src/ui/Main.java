package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // greeting message
        System.out.println("Welcome to Primi-TicTacToe, the primitive text-based TicTacToe game!" + "\n" + "\n" +
                "To play, take turns entering the position you'd like to put your shape on (see below)" + "\n" + "\n" +
                "one    two     three" + "\n" +
                "four   five    six" + "\n" +
                "seven  eight   nine");

        // initialization code

        Position one = new Position("one");
        Position two = new Position("two");
        Position three = new Position("three");
        Position four = new Position("four");
        Position five = new Position("five");
        Position six = new Position("six");
        Position seven = new Position("seven");
        Position eight = new Position("eight");
        Position nine = new Position("nine");

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
        c2.add(two);
        c2.add(five);
        c2.add(eight);
        List<Position> c3 = new ArrayList<>();
        c3.add(three);
        c3.add(six);
        c3.add(nine);
        List<Position> d1 = new ArrayList<>();
        d1.add(one);
        d1.add(five);
        d1.add(nine);
        List<Position> d2 = new ArrayList<>();
        d2.add(three);
        d2.add(five);
        d2.add(seven);

        List<Position> gamePositions = new ArrayList<>();
        gamePositions.addAll(r1);
        gamePositions.addAll(r2);
        gamePositions.addAll(r3);

        Board gameBoard = new Board(gamePositions);
        GameState gameState = new GameState(gameBoard);

        Shape circle = new Shape();
        Shape cross = new Shape();

        Player playerOne = gameState.getPlayerOne();
        Player playerTwo = gameState.getPlayerTwo();


        // choosing shapes
        System.out.println("\n");
        System.out.println("Player One: Please choose your shape (enter 'circle' or 'cross')!");
        Scanner playerInput = new Scanner(System.in);
        String playerOneShape = playerInput.next();
        if (playerOneShape.equals("circle")) {
            System.out.println("You have chosen to be 'circle'. Player Two shall be 'cross'!");
            gameState.getPlayerOne().setSelectedShape(circle);
            circle.setAssociatedPlayer(gameState.getPlayerOne());
            gameState.getPlayerTwo().setSelectedShape(cross);
            cross.setAssociatedPlayer(gameState.getPlayerTwo());
        } else {
            System.out.println("You have chosen to be 'cross'. Player Two shall be 'circle'!");
            gameState.getPlayerTwo().setSelectedShape(circle);
            circle.setAssociatedPlayer(gameState.getPlayerTwo());
            gameState.getPlayerOne().setSelectedShape(cross);
            cross.setAssociatedPlayer(gameState.getPlayerOne());
        }

        //x running the game
        while (gameState.getGameOverStatus() == false) {
            System.out.println("\n");
            System.out.println("Player One's turn:");
            String playerOneMove = playerInput.next();

            for (Position position : gameBoard.getPositions()) {
                if (playerOneMove.equals(position.getName()) && position.isFilled() == false) {
                    gameState.linkPositionToShape(gameState.getPlayerOne().getSelectedShape(), position);
                    gameState.getPlayerOne().getSelectedShape().addOccupyingSpot(position);
                    gameState.getPlayerOne().addPositionCovered(position);
                }
            }
            // check if win condition is met after playerOne makes a move
            gameState.isThreeConnected(r1, gameState.getPlayerOne());
            gameState.isThreeConnected(r2, gameState.getPlayerOne());
            gameState.isThreeConnected(r3, gameState.getPlayerOne());
            gameState.isThreeConnected(c1, gameState.getPlayerOne());
            gameState.isThreeConnected(c2, gameState.getPlayerOne());
            gameState.isThreeConnected(c3, gameState.getPlayerOne());
            gameState.isThreeConnected(d1, gameState.getPlayerOne());
            gameState.isThreeConnected(d2, gameState.getPlayerOne());

            if (gameState.getNumPositionsFilled() == 9) {
                gameBoard.setBoardFull();
                gameState.setGameOver();
                System.out.println("\n" + "Tie game! No winner.");
            } else {
                if (playerOne.getWinnerStatus() == false) {
                    System.out.println("\n");
                    System.out.println("Player Two's turn");
                    String playerTwoMove = playerInput.next();

                    for (Position position : gameBoard.getPositions()) {
                        if (playerTwoMove.equals(position.getName()) && position.isFilled() == false) {
                            gameState.linkPositionToShape(gameState.getPlayerOne().getSelectedShape(), position);
                            position.setOccupiedShape(gameState.getPlayerOne().getSelectedShape());
                            gameState.getPlayerTwo().getSelectedShape().addOccupyingSpot(position);
                            gameState.getPlayerTwo().addPositionCovered(position);
                            position.setFilled();
                        }
                    }

                    // check if win condition is met after playerB makes a move
                    gameState.isThreeConnected(r1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(r2, gameState.getPlayerTwo());
                    gameState.isThreeConnected(r3, gameState.getPlayerTwo());
                    gameState.isThreeConnected(c1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(c2, gameState.getPlayerTwo());
                    gameState.isThreeConnected(c3, gameState.getPlayerTwo());
                    gameState.isThreeConnected(d1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(d2, gameState.getPlayerTwo());
                    if (gameState.getNumPositionsFilled() == 9) {
                        gameBoard.setBoardFull();
                        System.out.println("Tie game! No winner.");
                        gameState.setGameOver();

                    }
                }
            }
        }
    }
}

