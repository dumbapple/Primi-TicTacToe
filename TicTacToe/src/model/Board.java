package model;

import java.util.HashSet;
import java.util.Set;

// Represents the board on which the game will take place
public class Board {
    private int numSpacesFilled;
    private boolean isCompletelyFilled;
    private Set<Position> positions;
    private Set<Shape> shapesPlaced;

    public Board() {
        numSpacesFilled = 0;
        isCompletelyFilled = false;
        positions = new HashSet<>();
        shapesPlaced = new HashSet<>();
    }

    public void setBoardFull() {
        isCompletelyFilled = true;
        numSpacesFilled = 9;
    }

    public void clearBoard() {
        isCompletelyFilled = false;
        numSpacesFilled = 0;
    }

    public Set<Position> getBoardPositions() {
        return positions;
    }

    public Set<Shape> getShapesPlaced() {
        return shapesPlaced;
    }

    public boolean getBoardFilledStatus() {
        return isCompletelyFilled;
    }

    public int getNumSpacesFilled() {
        return numSpacesFilled;
    }

    public void addShapeToBoard(Shape shape) {
        if (numSpacesFilled < 9) {
            numSpacesFilled++;
            shapesPlaced.add(shape);
        }
    }

    public void removeShapeFromBoard(Shape shape) {
        if (numSpacesFilled > 0) {
            numSpacesFilled--;
            shapesPlaced.remove(shape);
        }
    }
}
