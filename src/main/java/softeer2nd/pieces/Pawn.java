package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

import static softeer2nd.chess.Color.WHITE;

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

    /**
     * Black : 하단으로 1칸 or 움직인적 없으면 하단으로 2칸 or 적 존재하면 대각 하단으로 한칸
     * White : 상단으로 1칸 or 움직인적 없으면 상단으로 2칸 or 적 존재하면 대각 상단으로 한칸
     */
    /**
     * 1. 대각선 검사
     * 2. target 위치에 빈칸인지 검사
     */
    @Override
    public boolean canMove(Position source, Position target, Board board) {
        if(verifyDiagonal(source, target, board)){
            return true;
        }
        if(!board.findPieceByPosition(target).isBlank()){
            return false;
        }
        if(verifyFirstMove(source, target)){
            return true;
        }

        // TODO : 팀 별로 한칸 움직일 수 있는 경우의 수 검증만 구현

        return false;
    }

    private boolean verifyDiagonal(Position source, Position target, Board board) {
        if (!source.isDiagonal(target)) {
            return false;
        }
        return source.getFileDistance(target) == DISTANCE &&
                board.findPieceByPosition(source).isEnemy(board.findPieceByPosition(target));
    }

    private boolean verifyFirstMove(Position source, Position target) {
        if(!isFirstMove(source)){
            return false;
        }
        return source.isVertical(target) &&
                (source.getFileDistance(target) == DISTANCE || source.getFileDistance(target) == DISTANCE + 1);
    }
}
