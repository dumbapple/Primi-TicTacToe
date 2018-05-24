package model;

// Represents the player-selected shapes for the game; in this case, CIRCLE and CROSS
public abstract class Shape {
    private Player associatedPlayer;
    private Position spotOccupying;

    public Shape() {
        associatedPlayer = null;
        spotOccupying = null;
    }

    public void setAssociatedPlayer(Player player) {
        associatedPlayer = player;
    }

    public Player getAssociatedPlayer() {
        return associatedPlayer;
    }

    public void setSpotOccupying(Position position) {
        spotOccupying = position;
    }

    public Position getSpotOccupying() {
        return spotOccupying;
    }
}
