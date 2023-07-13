package softeer2nd.domain.pieces;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Color;
import softeer2nd.domain.chess.Position;

import static softeer2nd.domain.chess.Color.NONE;

public class Blank extends Piece{
    private Blank(Color color){
        super(color, ".");
    }

    public static Blank create(){
        return new Blank(NONE);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
