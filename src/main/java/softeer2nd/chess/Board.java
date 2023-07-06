package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.pieces.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.pieces.Piece.*;
import static softeer2nd.pieces.Piece.Type.*;
import static softeer2nd.utils.StringUtils.*;

public class Board {
    public final static int SIZE = 8;

    private List<Rank> board;

    public Board() {
    }

    public void initialize() {
        board = new ArrayList<>();
        for (int line = 1; line <= SIZE; line++) {
            board.add(Rank.lineOf(line));
        }
    }

    public void initializeEmpty() {
        board = new ArrayList<>();
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

    /**
     * 체스판에서 전체 기물의 개수를 가져온다.
     */
    public int getPieceCount() {
        int size = 0;
        for (Rank rank : board) {
            size += rank.getPieceCount();
        }
        return size;
    }

    /**
     * 체스판에서 종류와 색깔이 일치하는 기물의 개수를 가져온다.
     */
    public int getPieceCount(Type type, Color color) {
        int size = 0;
        for (Rank rank : board) {
            size += rank.getPieceCount(type, color);
        }
        return size;
    }

    public Piece findPieceByPosition(Position position) {
        return board.get(position.getRank()).getPiece(position.getFileToInt());
    }

    // TODO : 추후 미션6에서 Move class로 분리 필수
    public void board(Position position, Piece blackPawn) {
        board.get(position.getRank()).insertPiece(blackPawn, position.getFileToInt());
    }

    public double calculateScore(Color color) {
        double score = 0;
        for (int line = 0; line < SIZE; line++) {
            Rank rank = board.get(line);
            score += calculateScoreInRank(rank, color, line);
        }
        return score;
    }

    private double calculateScoreInRank(Rank rank, Color color, int line) {
        double score = 0;
        for (int file = 0; file < SIZE; file++) {
            Piece piece = rank.getPiece(file);

            if (piece.isSameColor(color)) {
                score += piece.getType().getScore();
                if (piece.isPawn() && existPawnInSameFile(file, line, piece.getColor())) {
                    score -= 0.5;
                }
            }
        }
        return score;
    }

    /**
     * 같은 파일에 같은 색 Pawn이 있는가?
     */
    private boolean existPawnInSameFile(int file, int exceptLine, Color color) {
        for(int line = 0; line < SIZE; line++){
            if(line == exceptLine)
                continue;

            Rank rank = board.get(line);
            if(rank.getPiece(file).isSameTypeAndColor(PAWN, color))
                return true;
        }
        return false;
    }

    public List<Piece> getPieceListOrderByScoreDesc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for(Rank rank : board){
            rank.addPieceOfSameColor(pieceList, color);
        }
        Collections.sort(pieceList, new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                return Double.compare(o2.getType().getScore(), o1.getType().getScore());
            }
        });
        return pieceList;
    }
}
