package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int SIZE = 8;

    List<Piece> pieceList = new ArrayList<>();
    List<List<Piece>> board = new ArrayList<>();
    List<Piece> whitePawnsResults = new ArrayList<>();
    List<Piece> blackPawnsResults = new ArrayList<>();

    public int size() {
        return pieceList.size();
    }

    public void add(Piece piece) {
        pieceList.add(piece);
    }

    public Piece findPawn(int idx) {
        return pieceList.get(idx);
    }

    public Board() {
        for(int i = 0 ; i < SIZE; i++){
            whitePawnsResults.add(Piece.createWhitePawn());
        }
        for(int i = 0 ; i < SIZE; i++){
            blackPawnsResults.add(Piece.createBlackPawn());
        }
    }

    public void initialize() {
        board.add(new ArrayList<>());
        board.add(this.blackPawnsResults);
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(new ArrayList<>());
        board.add(this.whitePawnsResults);
        board.add(new ArrayList<>());
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

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Piece> row : board){
            if(row.isEmpty()){
                sb.append("********");
            }else{
                for(Piece piece : row)
                    sb.append(piece);
            }
            sb.append(StringUtils.appendNewLine(""));
        }

        return sb.toString();
    }
}
