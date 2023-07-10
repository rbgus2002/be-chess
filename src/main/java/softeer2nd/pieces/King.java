package softeer2nd.pieces;

import softeer2nd.chess.Board;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

public class King extends Piece {
    private final int DISTANCE = 1;
    private King(Color color){
        super(color, "k", 0);
    }

    public static King from(Color color){
        return new King(color);
    }

    /**
     * 이동이 유효하지 않은 경우
     * 1. target에 같은 편 기물이 존재하는 경우
     * 2. 2칸 이상을 움직이는 경우
     */
    @Override
    public boolean canMove(Position source, Position target, Board board) {
        if (board.isSameTeam(source, target, board)) {
            return false;
        }
        if (!verifyKingMove(source, target)) {
            return false;
        }
        return true;
    }

    private boolean verifyKingMove(Position source, Position target) {
        if(source.isVertical(target) && source.getFileDistance(target) == DISTANCE){
            return true;
        }
        if(source.isHorizontal(target) && source.getRankDistance(target) == DISTANCE){
            return true;
        }
        if(source.isDiagonal(target) && source.getRankDistance(target) == DISTANCE && source.getFileDistance(target) == DISTANCE){
            return true;
        }

        return false;
    }
}
