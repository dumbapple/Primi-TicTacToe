package model;

import java.util.List;

// Represents the status of all events in the game
public class GameState {
    private boolean gameOverStatus;
    private int numPositionsFilled;
    private Board gameBoard;
    private Player playerOne;
    private Player playerTwo;

    public GameState(Board gameBoard) {
        gameOverStatus = false;
        numPositionsFilled = 0;
        this.gameBoard = gameBoard;
        playerOne = new Player("Player One");
        playerTwo = new Player("Player Two");
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setGameOver() {
        gameOverStatus = true;
        System.out.println("Game over!");
    }

    public boolean getGameOverStatus() {
        return gameOverStatus;
    }

    public int getNumPositionsFilled() {
        return numPositionsFilled;
    }

    public void linkPositionToShape(Shape shape, Position position) {
        shape.getSpotsOccupied().add(position);
        position.setOccupiedShape(shape);
        position.setFilled();
        numPositionsFilled++;
    }

    public boolean isThreeConnected(List<Position> positions, Player player) {
        if (player.getPositionsCovered().containsAll(positions)) {
            player.setWinner();
            setGameOver();
        }
        return gameOverStatus;
    }
}


