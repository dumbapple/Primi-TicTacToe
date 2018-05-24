package ui;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        // greeting message
        System.out.println("Welcome to Primi-TicTacToe, the primitive text-based TicTacToe game!" + "\n" +
                "To play, take turns entering the position you'd like to put your shape on (see below)" + "\n" +
                "one    two     three" + "\n" +
                "four   five    six" + "\n" +
                "seven  eight   nine");

        // initialization code
        Player playerA = new Player();
        Player playerB = new Player();
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

        Board gameBoard = new Board();
        gameBoard.addPositionToBoard(one);
        gameBoard.addPositionToBoard(two);
        gameBoard.addPositionToBoard(three);
        gameBoard.addPositionToBoard(four);
        gameBoard.addPositionToBoard(five);
        gameBoard.addPositionToBoard(six);
        gameBoard.addPositionToBoard(seven);
        gameBoard.addPositionToBoard(eight);
        gameBoard.addPositionToBoard(nine);
        GameState gameState = new GameState(gameBoard);
        gameState.addPlayer(playerA);
        gameState.addPlayer(playerB);
        Shape circle = new Shape();
        Shape cross = new Shape();



        // choosing shapes
        System.out.println("Player A: Please choose your shape (enter 'circle' or 'cross')!");
        Scanner playerInput = new Scanner(System.in);
        String playerOneShape = playerInput.next();
        if (playerOneShape.equals("circle")) {
            System.out.println("You have chosen to be 'circle'. Player B shall be 'cross'!");
            playerA.setSelectedShape(circle);
            circle.setAssociatedPlayer(playerA);
            playerB.setSelectedShape(cross);
            cross.setAssociatedPlayer(playerB);
        } else {
            System.out.println("You have chosen to be 'cross'. Player B shall be 'circle'!");
            playerB.setSelectedShape(circle);
            circle.setAssociatedPlayer(playerB);
            playerA.setSelectedShape(cross);
            cross.setAssociatedPlayer(playerA);
        }

        // running the game
        while (gameState.isGameOver() == false) {
            System.out.println("Player A's turn:");
            String playerOneMove = playerInput.next();

            for (Position position : gameBoard.getBoardPositions()) {
                if (playerOneMove.equals(position.getName()) && position.getFilledStatus() == false) {
                    gameState.addShapeToBoard(playerA.getSelectedShape());
                    position.setOccupiedShapeShape(playerA.getSelectedShape());
                    playerA.getSelectedShape().addOccupyingSpot(position);
                    playerA.addPositionCovered(position);
                    position.setFilled();
                }
            }

            // check if win condition is met after playerA makes a move
            gameState.isGameOverCondition(r1, playerA);
            gameState.isGameOverCondition(r2, playerA);
            gameState.isGameOverCondition(r3, playerA);
            gameState.isGameOverCondition(c1, playerA);
            gameState.isGameOverCondition(c2, playerA);
            gameState.isGameOverCondition(c3, playerA);
            gameState.isGameOverCondition(d1, playerA);
            gameState.isGameOverCondition(d2, playerA);
            if (gameState.getNumPositionsFilled() == 9) {
                gameBoard.setBoardFull();
                gameState.setGameOver();
            }

            System.out.println("Player B's turn");
            String playerTwoMove = playerInput.next();

            for (Position position : gameBoard.getBoardPositions()) {
                if (playerTwoMove.equals(position.getName()) && position.getFilledStatus() == false) {
                    gameState.addShapeToBoard(playerA.getSelectedShape());
                    position.setOccupiedShapeShape(playerA.getSelectedShape());
                    playerA.getSelectedShape().addOccupyingSpot(position);
                    playerA.addPositionCovered(position);
                    position.setFilled();
                }
            }

            // check if win condition is met after playerB makes a move
            gameState.isGameOverCondition(r1, playerB);
            gameState.isGameOverCondition(r2, playerB);
            gameState.isGameOverCondition(r3, playerB);
            gameState.isGameOverCondition(c1, playerB);
            gameState.isGameOverCondition(c2, playerB);
            gameState.isGameOverCondition(c3, playerB);
            gameState.isGameOverCondition(d1, playerB);
            gameState.isGameOverCondition(d2, playerB);
            if (gameState.getNumPositionsFilled() == 9) {
                gameBoard.setBoardFull();
                gameState.setGameOver();
            }
        }
        System.out.println("Game over!");
    }
}

