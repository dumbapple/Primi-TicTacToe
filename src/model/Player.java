package model;

import java.util.ArrayList;
import java.util.List;

// Represents a participating player
public class Player {
    private Shape selectedShape;
    private boolean isWinner;
    private List<Position> positionsCovered;
    private String name;

    public Player(String name) {
        this.name = name;
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
        System.out.println("\n" + name + " is victorious!");

    }

    public boolean getWinnerStatus() {
        return isWinner;
    }

    public void addPositionCovered(Position position) {
        if (!positionsCovered.contains(position)) {
            positionsCovered.add(position);
            position.setFilled();
        }
    }

    public List<Position> getPositionsCovered() {
        return positionsCovered;
    }
}
