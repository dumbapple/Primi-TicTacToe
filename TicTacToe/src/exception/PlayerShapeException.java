package exception;

public class PlayerShapeException extends Exception {

    public PlayerShapeException() {
        System.out.println("Detected invalid input. Please try again.");
    }
}
