package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int SIZE = 8;

    List<List<Piece>> board = new ArrayList<>();
    List<Piece> whitePawnsResults = new ArrayList<>();
    List<Piece> blackPawnsResults = new ArrayList<>();


    public Board() {
        for(int i = 0 ; i < SIZE; i++){
            whitePawnsResults.add(Piece.createWhitePawn());
        }
        for(int i = 0 ; i < SIZE; i++){
            blackPawnsResults.add(Piece.createBlackPawn());
        }
    }

    public void initialize() {
        board.add(initFirstLineInBoard(Piece.BLACK_COLOR));
        board.add(this.blackPawnsResults);
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(this.whitePawnsResults);
        board.add(initFirstLineInBoard(Piece.WHITE_COLOR));
    }

    private List<Piece> initFirstLineInBoard(final String color){
        List<Piece> pieceList = new ArrayList<>();

        if(color.equals(Piece.BLACK_COLOR)){
            pieceList.add(Piece.createBlackRook());
            pieceList.add(Piece.createBlackKnight());
            pieceList.add(Piece.createBlackBishop());
            pieceList.add(Piece.createBlackQueen());
            pieceList.add(Piece.createBlackKing());
            pieceList.add(Piece.createBlackBishop());
            pieceList.add(Piece.createBlackKnight());
            pieceList.add(Piece.createBlackRook());
        }else{
            pieceList.add(Piece.createWhiteRook());
            pieceList.add(Piece.createWhiteKnight());
            pieceList.add(Piece.createWhiteBishop());
            pieceList.add(Piece.createWhiteQueen());
            pieceList.add(Piece.createWhiteKing());
            pieceList.add(Piece.createWhiteBishop());
            pieceList.add(Piece.createWhiteKnight());
            pieceList.add(Piece.createWhiteRook());
        }

        return pieceList;
    }

    public String getWhitePawnsResults() {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : whitePawnsResults)
            sb.append(piece);
        return sb.toString();
    }

    public String getBlackPawnsResults() {
        StringBuilder sb = new StringBuilder();
        for(Piece piece : blackPawnsResults)
            sb.append(piece);
        return sb.toString();
    }

    public String showBoard() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Piece> row : board){
            if(row.isEmpty()){
                sb.append("........");
            }else{
                for(Piece piece : row)
                    sb.append(piece);
            }
            sb.append(StringUtils.appendNewLine(""));
        }

        return sb.toString();
    }

    public int pieceCount() {
        int size = 0;
        for(List row : board){
            size += row.size();
        }

        return size;
    }
}
