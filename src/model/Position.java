package model;

// Represents a particular spot on a 3x3 game board
public class Position {
    private boolean isFilled;
    private Shape occupyingShape;
    private String name;
    private Board gameBoard;

    public Position(String name) {
        this.name = name;
        isFilled = false;
        occupyingShape = null;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public String getName() {
        return name;
    }
    public void setFilled() {
        isFilled = true;
    }

    public boolean getFilledStatus() {
        return isFilled;
    }

    public void setShape(Shape occupyingShape) {
        this.occupyingShape = occupyingShape;
    }

    public Shape getShape() {
        return occupyingShape;
    }
}
