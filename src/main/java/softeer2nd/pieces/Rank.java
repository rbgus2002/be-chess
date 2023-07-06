package softeer2nd.pieces;

import softeer2nd.chess.Board;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.pieces.Piece.*;

public class Rank {
    private List<Piece> files = new ArrayList<>();
    private int line;

    private Rank(int line) {
        this.line = line;

        // set files
        switch (line) {
            case 1:
                setLine1();
                break;
            case 2:
                setLine2();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                setBlankLine();
                break;
            case 7:
                setLine7();
                break;
            case 8:
                setLine8();
                break;
            default:
                throw new IllegalArgumentException("잘못된 line 입력 입니다.");
        }
    }

    public static Rank lineOf(final int line) {
        return new Rank(line);
    }

    private void setLine1() {
        files.add(createWhiteRook());
        files.add(createWhiteKnight());
        files.add(createWhiteBishop());
        files.add(createWhiteQueen());
        files.add(createWhiteKing());
        files.add(createWhiteBishop());
        files.add(createWhiteKnight());
        files.add(createWhiteRook());
    }

    private void setLine2() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createWhitePawn());
        }
    }

    private void setLine7() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createBlackPawn());
        }
    }

    private void setLine8() {
        files.add(createBlackRook());
        files.add(createBlackKnight());
        files.add(createBlackBishop());
        files.add(createBlackQueen());
        files.add(createBlackKing());
        files.add(createBlackBishop());
        files.add(createBlackKnight());
        files.add(createBlackRook());
    }

    private void setBlankLine() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createBlank());
        }
    }

    public int getPiece() {
        int size = 0;
        for(Piece file : files){
            if(!file.isBlank())
                size++;
        }
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Piece file : files){
            sb.append(file);
        }
        return sb.toString();
    }
}
