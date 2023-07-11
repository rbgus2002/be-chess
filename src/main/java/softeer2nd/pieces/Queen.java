package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class Queen extends Piece{
    private Queen(Color color){
        super(color, "q", 9.0);
    }

    public static Queen from(Color color){
        return new Queen(color);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        if(!verifyQueenMove(source, target)){
            return false;
        }
        return true;
    }

    private boolean verifyQueenMove(Position source, Position target){
        return source.isHorizontal(target) || source.isVertical(target) || source.isDiagonal(target);
    }
}
