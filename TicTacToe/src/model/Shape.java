package model;

// Represents the player-selected shapes for the game; in this case, CIRCLE and CROSS
public class Shape {
    private Player associatedPlayer;
//    private Position spotOccupying;

    public Shape() {
//        spotOccupying = spot;
        associatedPlayer = null;
    }

    public void setAssociatedPlayer(Player player) {
        associatedPlayer = player;
    }

    public Player getAssociatedPlayer() {
        return associatedPlayer;
    }






}
