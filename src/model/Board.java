package model;

import java.util.ArrayList;
import java.util.List;

// Represents the board on which the game will take place
public class Board {
    private boolean isCompletelyFilled;
    private List<Position> positions;
//    private List<Shape> shapesPlaced;

    public Board() {
        isCompletelyFilled = false;
        positions = new ArrayList<>();
//        shapesPlaced = new ArrayList<>();
    }

    public void setBoardFull() {
        isCompletelyFilled = true;
    }

    public boolean getBoardFilledStatus() {
        return isCompletelyFilled;
    }

    public List<Position> getBoardPositions() {
        return positions;
    }

//    public List<Shape> getShapesPlaced() {
//
//    }
}
