package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class Knight extends Piece{
    private final int DISTANCE = 3;
    private Knight(Color color){
        super(color, "n", 2.5);
    }

    public static Knight from(Color color){
        return new Knight(color);
    }

    @Override
    public boolean canMove(Position source, Position target, Board board){
        if(source.isVertical(target) || source.isHorizontal(target)){
            return false;
        }
        return Math.abs(source.getFileDistance(target)) + Math.abs(source.getRankDistance(target)) == DISTANCE;
    }
}
