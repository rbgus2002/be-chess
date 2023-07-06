package softeer2nd.pieces;

import softeer2nd.chess.Board;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.pieces.Piece.*;

public class Rank {
    private List<Piece> pieces = new ArrayList<>();

    private Rank(int line) {
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

    public List<Piece> getPieces() {
        return pieces;
    }

    public static Rank lineOf(final int line) {
        return new Rank(line);
    }

    private void setLine1() {
        pieces.add(createWhiteRook());
        pieces.add(createWhiteKnight());
        pieces.add(createWhiteBishop());
        pieces.add(createWhiteQueen());
        pieces.add(createWhiteKing());
        pieces.add(createWhiteBishop());
        pieces.add(createWhiteKnight());
        pieces.add(createWhiteRook());
    }

    private void setLine2() {
        for(int col = 1; col <= Board.SIZE; col++){
            pieces.add(createWhitePawn());
        }
    }

    private void setLine7() {
        for(int col = 1; col <= Board.SIZE; col++){
            pieces.add(createBlackPawn());
        }
    }

    private void setLine8() {
        pieces.add(createBlackRook());
        pieces.add(createBlackKnight());
        pieces.add(createBlackBishop());
        pieces.add(createBlackQueen());
        pieces.add(createBlackKing());
        pieces.add(createBlackBishop());
        pieces.add(createBlackKnight());
        pieces.add(createBlackRook());
    }

    private void setBlankLine() {
        for(int col = 1; col <= Board.SIZE; col++){
            pieces.add(createBlank());
        }
    }

    public int getPieceCount() {
        int size = 0;
        for(Piece file : pieces){
            if(!file.isBlank())
                size++;
        }
        return size;
    }

    public int getPieceCount(Type type, Color color) {
        int size = 0;
        for(Piece file : pieces){
            if(file.isSameTypeAndColor(type, color))
                size++;
        }
        return size;
    }

    public Piece getPiece(int file){
        return pieces.get(file);
    }

    // TODO : Move class 분리하면서 refactoring
    public void insertPiece(Piece newPiece, int file){
        pieces.set(file, newPiece);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Piece file : pieces){
            sb.append(file);
        }
        return sb.toString();
    }

    public void addPieceOfSameColor(List<Piece> pieceList, Color color) {
        for(Piece piece : pieces){
            if(piece.isSameColor(color)){
                pieceList.add(piece);
            }
        }
    }
}
