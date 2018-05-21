//package model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GameState {
//    private List<Player> players;
//    private Board gameBoard;
//    private boolean isGameOver;
//
//
//
//    public GameState(Board gameBoard) {
//        players = new ArrayList<>();
//        this.gameBoard = gameBoard;
//        isGameOver = true;
//    }
//
//    public void addPlayer(Player player) {
//        if (!players.contains(player)) {
//            players.add(player);
//        }
//    }
//
//    public List<Player> getPlayers() {
//        return players;
//    }
//
//    public void setGameOver() {
//        isGameOver = true;
//    }
//
//    public void setGameNotOver() {
//        isGameOver = false;
//    }
//
////    public boolean isGameOver() {
////        if (gameBoard.getNumSpacesFilled() == 9) {
////            setGameOver();
////        }
////
////        if (gameBoard.)
////        return
////    }
//
//}
