package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // Greeting message
        System.out.println("Welcome to the text-based TicTacToe game!" + "\n");
        System.out.println("Take turns entering the position you'd like to put your shape on (see below)" + "\n");
        System.out.println("1    2     3" + "\n");
        System.out.println("4    5     6" + "\n");
        System.out.println("7    8     9" + "\n");

        // Initializing positions and sorting them into various lists of game-winning combinations
        Position one = new Position("1");
        Position two = new Position("2");
        Position three = new Position("3");
        Position four = new Position("4");
        Position five = new Position("5");
        Position six = new Position("6");
        Position seven = new Position("7");
        Position eight = new Position("8");
        Position nine = new Position("9");

        List<Position> row1 = new ArrayList<>();
        row1.add(one);
        row1.add(two);
        row1.add(three);

        List<Position> row2 = new ArrayList<>();
        row2.add(four);
        row2.add(five);
        row2.add(six);

        List<Position> row3 = new ArrayList<>();
        row3.add(seven);
        row3.add(eight);
        row3.add(nine);

        List<Position> column1 = new ArrayList<>();
        column1.add(one);
        column1.add(four);
        column1.add(seven);

        List<Position> column2 = new ArrayList<>();
        column2.add(two);
        column2.add(five);
        column2.add(eight);

        List<Position> column3 = new ArrayList<>();
        column3.add(three);
        column3.add(six);
        column3.add(nine);

        List<Position> diagonal1 = new ArrayList<>();
        diagonal1.add(one);
        diagonal1.add(five);
        diagonal1.add(nine);

        List<Position> diagonal2 = new ArrayList<>();
        diagonal2.add(three);
        diagonal2.add(five);
        diagonal2.add(seven);

        List<Position> gamePositions = new ArrayList<>();
        gamePositions.addAll(row1);
        gamePositions.addAll(row2);
        gamePositions.addAll(row3);

        // Make a game board with the created positions, and with it a game state focused on events on said board
        Board gameBoard = new Board(gamePositions);
        GameState gameState = new GameState(gameBoard);

        // creating shape entities that will represent player-picked spots on the board
        Shape circle = new Shape();
        Shape cross = new Shape();

        // process of choosing shapes
        System.out.println("\n" + "Player One: Please choose your shape (enter 'circle' or 'cross')!");
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

        // running the game
        while (!gameState.getGameOverStatus()) {
            System.out.println("\n" + "Player One's turn:");
            String playerOneMove = playerInput.next();

            // process of player one making a move
            for (Position position : gameBoard.getPositions()) {
                if (playerOneMove.equals(position.getName()) && !position.isFilled()) {
                    gameState.linkPositionToShape(gameState.getPlayerOne().getSelectedShape(), position);
                    gameState.getPlayerOne().getSelectedShape().addOccupyingSpot(position);
                    gameState.getPlayerOne().addPositionCovered(position);
                }
            }

            // continually check win condition after playerOne makes a move
            gameState.isThreeConnected(row1, gameState.getPlayerOne());
            gameState.isThreeConnected(row2, gameState.getPlayerOne());
            gameState.isThreeConnected(row3, gameState.getPlayerOne());
            gameState.isThreeConnected(column1, gameState.getPlayerOne());
            gameState.isThreeConnected(column2, gameState.getPlayerOne());
            gameState.isThreeConnected(column3, gameState.getPlayerOne());
            gameState.isThreeConnected(diagonal1, gameState.getPlayerOne());
            gameState.isThreeConnected(diagonal2, gameState.getPlayerOne());

            if (gameState.getNumPositionsFilled() == 9 && !gameState.getPlayerOne().getWinnerStatus()) {
                gameBoard.setBoardFull();
                System.out.println("\n" + "Tie game! No winner.");
                gameState.setGameOver();

            } else {
                if (!gameState.getPlayerOne().getWinnerStatus()) {
                    System.out.println("\n" + "Player Two's turn");
                    String playerTwoMove = playerInput.next();

                    for (Position position : gameBoard.getPositions()) {
                        if (playerTwoMove.equals(position.getName()) && !position.isFilled()) {
                            gameState.linkPositionToShape(gameState.getPlayerTwo().getSelectedShape(), position);
                            gameState.getPlayerTwo().getSelectedShape().addOccupyingSpot(position);
                            gameState.getPlayerTwo().addPositionCovered(position);
                        }
                    }

                    // check if win condition is met after player two makes a move
                    gameState.isThreeConnected(row1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(row2, gameState.getPlayerTwo());
                    gameState.isThreeConnected(row3, gameState.getPlayerTwo());
                    gameState.isThreeConnected(column1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(column2, gameState.getPlayerTwo());
                    gameState.isThreeConnected(column3, gameState.getPlayerTwo());
                    gameState.isThreeConnected(diagonal1, gameState.getPlayerTwo());
                    gameState.isThreeConnected(diagonal2, gameState.getPlayerTwo());
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

