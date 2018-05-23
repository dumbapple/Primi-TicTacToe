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

        Position one = new Position();
        Position two = new Position();
        Position three = new Position();
        Position four = new Position();
        Position five = new Position();
        Position six = new Position();
        Position seven = new Position();
        Position eight = new Position();
        Position nine = new Position();
        Board gameBoard = new Board();
        gameBoard.getBoardPositions().add(one);
        gameBoard.getBoardPositions().add(two);
        gameBoard.getBoardPositions().add(three);
        gameBoard.getBoardPositions().add(four);
        gameBoard.getBoardPositions().add(five);
        gameBoard.getBoardPositions().add(six);
        gameBoard.getBoardPositions().add(seven);
        gameBoard.getBoardPositions().add(eight);
        gameBoard.getBoardPositions().add(nine);

        Player playerOne = new Player();
        Player playerTwo = new Player();
        Shape circle = new Circle();
        Shape cross = new Cross();

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
        } else {
            circle.setAssociatedPlayer(playerTwo);
            playerTwo.setSelectedShape(circle);
            System.out.println("You have chosen to be 'cross'. Player 2 shall be 'circle'!");
            cross.setAssociatedPlayer(playerOne);
            playerOne.setSelectedShape(cross);
        }

        int positionsFilled = gameState.getPositionsFilled();
        boolean isNull = gameBoard.getBoardPositions().isEmpty();
        boolean gameOver = (positionsFilled == 9) ||
                ((one.getShape() == two.getShape()) && (two.getShape() == three.getShape())) ||
                ((four.getShape() == five.getShape()) && (five.getShape() == six.getShape())) ||
                ((seven.getShape() == eight.getShape()) && (eight.getShape() == nine.getShape())) ||
                ((one.getShape() == four.getShape()) && (four.getShape() == seven.getShape())) ||
                ((two.getShape() == five.getShape()) && (five.getShape() == eight.getShape())) ||
                ((three.getShape() == six.getShape()) && (six.getShape() == nine.getShape())) ||
                ((one.getShape() == five.getShape()) && (five.getShape() == nine.getShape())) ||
                ((three.getShape() == five.getShape()) && (five.getShape() == seven.getShape()));

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


        while () {
            System.out.println("Player One's turn:");
            String move = playerInput.next();
            for (Position p : gameBoard.getBoardPositions()) {
                if (move == p.toString()) {
                    p.setFilled();
                    p.setShape(playerOne.getSelectedShape());
                    gameState.addShapeToBoard(playerOne.getSelectedShape());

                }
            }

            System.out.println("Player 2's turn");
            String otherMove = playerInput.next();
            for (Position p : gameBoard.getBoardPositions()) {
                if (otherMove == p.toString()) {
                    p.setFilled();
                    p.setShape(playerTwo.getSelectedShape());
                    gameState.addShapeToBoard(playerTwo.getSelectedShape());
                }
            }

        }
        if (gameState.getPositionsFilled() == 9) {
            gameBoard.setBoardFull();
        }
        gameState.setGameOver();
        System.out.println("Game over!");
    }
}

