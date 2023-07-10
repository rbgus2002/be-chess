package softeer2nd.pieces;

import softeer2nd.chess.Board;
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
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
