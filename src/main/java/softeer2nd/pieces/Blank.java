package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

import static softeer2nd.chess.Color.NONE;

public class Blank extends Piece{
    private Blank(Color color){
        super(color, ".", 0);
    }

    public static Blank create(){
        return new Blank(NONE);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        return false;
    }
}
