package model;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private Board gameBoard;
    private boolean isGameOver;
    private List<Player> players;
    private List<Shape> shapesPlaced;
    private List<Position> positions;
    private int positionsFilled;

    public GameState(Board gameBoard) {
        isGameOver = false;
        positionsFilled = 0;
        this.gameBoard = gameBoard;
        players = new ArrayList<>();
        shapesPlaced = new ArrayList<>();
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public int getPositionsFilled() {
        return positionsFilled;
    }

    public void addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }


    public void addShapeToBoard(Shape shape) {
        shapesPlaced.add(shape);
        positionsFilled++;
    }

    public List<Shape> getShapesPlaced() {
        return shapesPlaced;
    }

}
