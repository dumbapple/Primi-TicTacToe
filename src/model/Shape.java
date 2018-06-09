package model;

import java.util.ArrayList;
import java.util.List;

// Represents the player-selected shapes for the game; for our purposes, 'circle' and 'cross'
public class Shape {
    private Player associatedPlayer;
    private List<Position> spotsOccupied;

    public Shape() {
        associatedPlayer = null;
        spotsOccupied = new ArrayList<>();
    }

    public void setAssociatedPlayer(Player player) {
        associatedPlayer = player;
    }

    public void addOccupyingSpot(Position position) {
        spotsOccupied.add(position);
    }

    public List<Position> getSpotsOccupied() {
        return spotsOccupied;
    }
}
