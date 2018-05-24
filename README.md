# Primi-TicTacToe
A primitive, text-based tic tac toe game. This is my first project, trying to apply skills learned in a second year software design class.

As of commit #6 the game-like functionality is working, but sometimes a player can win even if they don't have 3 spaces filled in a straight line. Suspect issue is in the method in GameState.java that handles game-over conditions, or the while-loop in Main.java.

Have neglected to write tests thus far; will create test classes soon to hopefully debug code.

Looking to add a new class that defines methods advancing the game state; the usage implementation defined in Main.java could be extracted as methods in the new class. This would make the main method less clustered.
