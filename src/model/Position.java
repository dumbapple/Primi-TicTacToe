package model;

// Represents a particular spot on a 3x3 game board
public class Position {
    private boolean isFilled;
    private String name;
    private Shape occupiedShape;

    public Position(String name) {
        isFilled = false;
        this.name = name;
        occupiedShape = null;
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

    public void setOccupiedShapeShape(Shape occupiedShape) {
        this.occupiedShape = occupiedShape;
    }

    public Shape getOccupiedShape() {
        return occupiedShape;
    }
}
