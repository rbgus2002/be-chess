package softeer2nd.pieces;

import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class Pawn extends Piece{
    public static final double SCORE = 1.0;

    private Pawn(Color color){
        super(color, "p", SCORE);
    }

    public static Pawn from(Color color){
        return new Pawn(color);
    }
    @Override
    boolean verifyMove(Position source, Position target) {
        return false;
    }
}
