package model;

// Represents a player
public class Player {
    private Shape selectedShape;
    private boolean isWinner;

    public Player() {
        this.selectedShape = null;
        isWinner = false;
    }

    public void setSelectedShape(Shape selectedShape) {
        this.selectedShape = selectedShape;
    }

    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setWinner() {
        isWinner = true;
        System.out.println("Congratulations on your glorious victory!");
    }
}
