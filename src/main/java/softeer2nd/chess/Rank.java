package softeer2nd.chess;

import softeer2nd.pieces.*;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.chess.Color.BLACK;
import static softeer2nd.chess.Color.WHITE;

public class Rank {
    private List<Piece> pieces = new ArrayList<>();

    private Rank(int line) {
        switch (line) {
            case 1:
                setFirstLine(WHITE);
                break;
            case 2:
                setSecondLine(WHITE);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                setBlankLine();
                break;
            case 7:
                setSecondLine(BLACK);
                break;
            case 8:
                setFirstLine(BLACK);
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

    private void setFirstLine(Color color) {
        pieces.add(Rook.from(color));
        pieces.add(Knight.from(color));
        pieces.add(Bishop.from(color));
        pieces.add(Queen.from(color));
        pieces.add(King.from(color));
        pieces.add(Bishop.from(color));
        pieces.add(Knight.from(color));
        pieces.add(Rook.from(color));
    }

    private void setSecondLine(Color color) {
        for(int col = 1; col <= Board.SIZE; col++){
            pieces.add(Pawn.from(color));
        }
    }

    private void setBlankLine() {
        for(int col = 1; col <= Board.SIZE; col++){
            pieces.add(Blank.create());
        }
    }

    public Piece getPieceAt(int file){
        return pieces.get(file);
    }

    public void insertPiece(Piece piece, int file){
        pieces.set(file, piece);
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
