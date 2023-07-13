package softeer2nd.domain.pieces;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Color;
import softeer2nd.domain.chess.Position;

public class Rook extends Piece{
    private Rook(Color color){
        super(color, "r");
    }

    public static Rook from(Color color){
        return new Rook(color);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return source.isVertical(target) || source.isHorizontal(target);
    }
}
