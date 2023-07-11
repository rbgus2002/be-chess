package softeer2nd.exception;

public class IllegalTurnException extends ChessException{
    public IllegalTurnException(String message) {
        super(message);
    }

    public IllegalTurnException() {
    }
}
