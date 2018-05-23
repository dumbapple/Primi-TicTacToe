package model;

// Represents an instance of a circle shape object
public class Circle extends Shape {
    private Position spotOccupying;

    public void setSpotOccupying(Position position) {
        spotOccupying = position;
    }

    public Position getSpotOccupying() {
        return spotOccupying;
    }
}
