package softeer2nd.pieces;

import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class Bishop extends Piece{
    private Bishop(Color color){
        super(color, "b", 3.0);
    }

    public static Bishop from(Color color){
        return new Bishop(color);
    }

    @Override
    boolean verifyMove(Position source, Position target) {
        return false;
    }
}
