package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.pieces.Rank;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = SIZE - 1; row >= 0; row--){
            sb.append(appendNewLine(board.get(row).toString()));
        }

        return sb.toString();
    }

    public int pieceCount() {
        int size = 0;
        for(Rank rank : board){
            size += rank.getPiece();
        }
        return size;
    }
}
