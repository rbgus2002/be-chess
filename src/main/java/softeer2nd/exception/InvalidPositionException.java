package softeer2nd.exception;

public class InvalidPositionException extends ChessException{
    public InvalidPositionException(String message) {
        super(message);
    }
    public InvalidPositionException() {
    }
}
