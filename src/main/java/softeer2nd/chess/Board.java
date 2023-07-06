package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.pieces.Rank;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.pieces.Piece.*;
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

    public Piece findPieceByPoint(Point point){
        return board.get(point.getRank()).getPiece(point.getFileToInt());
    }
}
