package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class Rook extends Piece{
    private Rook(Color color){
        super(color, "r", 5.0);
    }

    public static Rook from(Color color){
        return new Rook(color);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
