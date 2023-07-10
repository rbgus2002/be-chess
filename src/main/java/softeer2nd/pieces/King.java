package softeer2nd.pieces;

import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class King extends Piece {
    private King(Color color){
        super(color, "k", 0);
    }

    public static King from(Color color){
        return new King(color);
    }

    @Override
    public boolean verifyMove(Position source, Position target) {
        return false;
    }
}
