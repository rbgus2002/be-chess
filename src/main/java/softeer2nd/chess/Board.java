package softeer2nd.chess;

import softeer2nd.pieces.Pawn;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int SIZE = 8;

    List<Pawn> pawnList = new ArrayList<>();
    List<List<Pawn>> board = new ArrayList<>();
    List<Pawn> whitePawnsResults = new ArrayList<>();
    List<Pawn> blackPawnsResults = new ArrayList<>();

    public int size() {
        return pawnList.size();
    }

    public void add(Pawn pawn) {
        pawnList.add(pawn);
    }

    public Pawn findPawn(int idx) {
        return pawnList.get(idx);
    }

    public Board() {
        for(int i = 0 ; i < SIZE; i++){
            whitePawnsResults.add(new Pawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION));
        }
        for(int i = 0 ; i < SIZE; i++){
            blackPawnsResults.add(new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION));
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
        for(Pawn pawn : whitePawnsResults)
            sb.append(pawn);
        return sb.toString();
    }

    public String getBlackPawnsResults() {
        StringBuilder sb = new StringBuilder();
        for(Pawn pawn : blackPawnsResults)
            sb.append(pawn);
        return sb.toString();
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Pawn> row : board){
            if(row.isEmpty()){
                sb.append("********");
            }else{
                for(Pawn pawn : row)
                    sb.append(pawn.getRepresentation());
            }
            sb.append(StringUtils.appendNewLine(""));
        }

        return sb.toString();
    }
}
