package model;

// Represents the player-selected shapes for the game; in this case, CIRCLE and CROSS
public abstract class Shape {
    private Player associatedPlayer;

    public Shape() {
        associatedPlayer = null;
    }

    public void setAssociatedPlayer(Player player) {
        associatedPlayer = player;
    }

    public Player getAssociatedPlayer() {
        return associatedPlayer;
    }
}
