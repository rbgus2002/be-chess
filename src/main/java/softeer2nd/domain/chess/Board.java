package softeer2nd.domain.chess;

import softeer2nd.domain.pieces.Blank;
import softeer2nd.domain.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.utils.StringUtils.*;

public class Board {
    public final static int SIZE = 8;

    private List<Rank> board = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        board.clear();
        for (int line = 1; line <= SIZE; line++) {
            board.add(Rank.lineOf(line));
        }
    }

    public void initializeEmpty() {
        board.clear();
        for (int line = 1; line <= SIZE; line++) {
            board.add(Rank.lineOf(4));
        }
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int row = SIZE - 1; row >= 0; row--) {
            sb.append(appendNewLine(board.get(row).toString()));
        }

        return sb.toString();
    }

    public Piece findPieceByPosition(Position position) {
        return board.get(position.getRank()).getPieceAt(position.getFile());
    }

    public void insertPiece(Position position, Piece piece) {
        board.get(position.getRank()).insertPiece(piece, position.getFile());
    }

    public void move(Position source, Position target){
        validateMove(source, target);
        validateBlocked(source, target);
        moveExecution(source, target);
    }

    private void validateMove(Position source, Position target){
        Piece sourcePiece = findPieceByPosition(source);
        if(!sourcePiece.canMove(source, target, this)){
            throw new IllegalArgumentException(sourcePiece + "는 " + target + "으로 움직일 수 없습니다.");
        }
    }

    private void validateBlocked(Position source, Position target) {
        // 나이트는 기물 건너 뛸 수 있음
        if(findPieceByPosition(source).isKnight()){
            return;
        }
        int maxSide = source.getMaxSide(target);
        int nextRank = source.getNextRank(target);
        int nextFile = source.getNextFile(target);

        Position now = Position.of(source);
        for(int i = 0; i < maxSide - 1; i++){
            now = now.calculateNextPosition(nextRank, nextFile);
            if(!findPieceByPosition(now).isBlank()){
                throw new IllegalArgumentException(source + "와 " + target + " 사이에 다른 기물이 존재할 수 없습니다");
            }
        }
    }

    private void moveExecution(Position source, Position target) {
        insertPiece(target, findPieceByPosition(source));
        insertPiece(source, Blank.create());
    }
}
