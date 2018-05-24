package model;

import java.util.ArrayList;
import java.util.List;

// Represents a player
public class Player {
    private Shape selectedShape;
    private boolean isWinner;
    private List<Position> positionsCovered;

    public Player() {
        this.selectedShape = null;
        isWinner = false;
        positionsCovered = new ArrayList<>();
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

    public boolean getWinnerStatus() {
        return isWinner;
    }

    public void addPositionCovered(Position position) {
        if (!positionsCovered.contains(position)) {
            positionsCovered.add(position);
        }
    }

    public List<Position> getPositionsCovered() {
        return positionsCovered;
    }
}
