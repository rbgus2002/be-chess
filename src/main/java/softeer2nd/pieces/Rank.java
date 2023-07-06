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
    }

    public static Rank lineOf(final int line) {
        Rank rank = new Rank(line);

        switch (line) {
            case 1:
                rank.createLine1();
                break;
            case 2:
                rank.createLine2();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                rank.createBlankLine();
                break;
            case 7:
                rank.createLine7();
                break;
            case 8:
                rank.createLine8();
                break;
            default:
                throw new IllegalArgumentException("잘못된 line 입력 입니다.");
        }
        return rank;
    }

    private void createLine1() {
        files.add(createWhiteRook());
        files.add(createWhiteKnight());
        files.add(createWhiteBishop());
        files.add(createWhiteQueen());
        files.add(createWhiteKing());
        files.add(createWhiteBishop());
        files.add(createWhiteKnight());
        files.add(createWhiteRook());
    }

    private void createLine2() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createWhitePawn());
        }
    }

    private void createLine7() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createBlackPawn());
        }
    }

    private void createLine8() {


        files.add(createBlackRook());
        files.add(createBlackKnight());
        files.add(createBlackBishop());
        files.add(createBlackQueen());
        files.add(createBlackKing());
        files.add(createBlackBishop());
        files.add(createBlackKnight());
        files.add(createBlackRook());
    }

    private void createBlankLine() {
        for(int col = 1; col <= Board.SIZE; col++){
            files.add(createBlank());
        }
    }

    public List<Piece> getFiles() {
        return files;
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
