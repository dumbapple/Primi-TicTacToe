package model;

import java.util.List;

// Represents the 3x3 board on which the game will take place
public class Board {
    private boolean isCompletelyFilled;
    private List<Position> positionsAvailable;
    private List<Position> positions;

    public Board(List<Position> positions) {
        isCompletelyFilled = false;
        this.positions = positions;
        this.positionsAvailable = positions;
    }

    public void setBoardFull() {
        isCompletelyFilled = true;
    }

    public boolean isBoardFilled() {
        return isCompletelyFilled;
    }

    public List<Position> getPositionsAvailable() {
        return positionsAvailable;
    }

    public List<Position> getPositions() {
        return positions;
    }

}
