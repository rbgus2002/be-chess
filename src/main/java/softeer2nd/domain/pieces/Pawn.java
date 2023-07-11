package softeer2nd.domain.pieces;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Color;
import softeer2nd.domain.chess.Position;

import static softeer2nd.domain.chess.Color.WHITE;

public class Pawn extends Piece {
    private static final double SCORE = 1.0;
    private final int DISTANCE = 1;

    private Pawn(Color color) {
        super(color, "p", SCORE);
    }

    public static Pawn from(Color color) {
        return new Pawn(color);
    }

    private boolean isFirstMove(Position source) {
        int rank = source.getRank() + 1;
        return (getColor() == WHITE) ? rank == 2 : rank == 7;
    }

    @Override
    public boolean canMove(Position source, Position target, Board board) {
        if(source.isDiagonal(target)){
            return Math.abs(source.getFileDistance(target)) == DISTANCE &&
                    board.findPieceByPosition(source).isEnemy(board.findPieceByPosition(target));
        }
        if(!board.findPieceByPosition(target).isBlank()){
            return false;
        }
        if(verifyFirstMove(source, target)){
            return true;
        }
        if(verifyMove(source, target, board)){
            return true;
        }

        return false;
    }

    private boolean verifyFirstMove(Position source, Position target) {
        if(!isFirstMove(source)){
            return false;
        }
        return source.isVertical(target) &&
                (Math.abs(source.getFileDistance(target)) == DISTANCE || Math.abs(source.getFileDistance(target)) == DISTANCE + 1);
    }

    private boolean verifyMove(Position source, Position target, Board board) {
        if(board.findPieceByPosition(source).isBlack()){
            return source.getFileDistance(target) == -DISTANCE;
        }
        else{
            return source.getFileDistance(target) == DISTANCE;
        }
    }
}
