package model;

// Represents an instance of a cross shape object
public class Cross extends Shape {
    private Position spotOccupying;

    public void setSpotOccupying(Position position) {
        spotOccupying = position;
    }

    public Position getSpotOccupying() {
        return spotOccupying;
    }
}
