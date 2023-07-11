package softeer2nd.domain.pieces;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Color;
import softeer2nd.domain.chess.Position;

public class Bishop extends Piece{
    private Bishop(Color color){
        super(color, "b", 3.0);
    }

    public static Bishop from(Color color){
        return new Bishop(color);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return source.isDiagonal(target);
    }
}
