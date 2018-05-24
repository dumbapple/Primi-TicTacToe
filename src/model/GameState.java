package model;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    private boolean isGameOver;
    private int numPositionsFilled;
    private Board gameBoard;
    private List<Player> players;
    private List<Shape> shapesPlaced;


    public GameState(Board gameBoard) {
        isGameOver = false;
        numPositionsFilled = 0;
        this.gameBoard = gameBoard;
        players = new ArrayList<>();
        shapesPlaced = new ArrayList<>();
    }

    public void setGameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getNumPositionsFilled() {
        return numPositionsFilled;
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
        numPositionsFilled++;
    }

    public List<Shape> getShapesPlaced() {
        return shapesPlaced;
    }

    public boolean isGameOverCondition(List<Position> positions, Player player) {
        if (player.getPositionsCovered().containsAll(positions)) {
            player.setWinner();
            setGameOver();
        }
        return isGameOver;
    }

//    public void setPlayerShape(Player player, Shape input) {
//            player.setSelectedShape(input);
//
//        }
    }

