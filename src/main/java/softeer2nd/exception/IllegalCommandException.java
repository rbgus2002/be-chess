package softeer2nd.exception;

public class IllegalCommandException extends ChessException{
    public IllegalCommandException(String message) {
        super(message);
    }

    public IllegalCommandException() {
    }
}
