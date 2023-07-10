package softeer2nd.chess;

import softeer2nd.pieces.Blank;
import softeer2nd.pieces.Pawn;
import softeer2nd.pieces.Piece;
//import softeer2nd.chess.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.utils.StringUtils.*;

public class Board {
    public final static int SIZE = 8;

    private List<Rank> board = new ArrayList<>();

    public Board() {
    }

    public void initialize() {
        board.clear();
        for (int line = 1; line <= SIZE; line++) {
            board.add(Rank.lineOf(line));
        }
    }

    public void initializeEmpty() {
        board.clear();
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

    public Piece findPieceByPosition(Position position) {
        return board.get(position.getRank()).getPieceAt(position.getFile());
    }

    public void insertPiece(Position position, Piece piece) {
        board.get(position.getRank()).insertPiece(piece, position.getFile());
    }

    public double getScoreOfColor(Color color) {
        double score = 0;
        for(int fileIdx = 0; fileIdx < SIZE; fileIdx++){
            score += calculateScoreInFile(fileIdx, color);
        }
        return score;
    }

    private double calculateScoreInFile(int fileIdx, Color color){
        double pawnScore = 0;
        double score = 0;
        for(int rankIdx = 0 ; rankIdx < SIZE; rankIdx++){
            Piece piece = board.get(rankIdx).getPieceAt(fileIdx);

            if(!piece.isSameColor(color)){
                continue;
            }

            if(piece.isTypeOf(Pawn.class)){
                pawnScore += piece.getScore();
            }else{
                score += piece.getScore();
            }
        }

        if(pawnScore > Pawn.SCORE){
            pawnScore /= 2;
        }
        score += pawnScore;

        return score;
    }

    public List<Piece> getPieceListOrderByScoreDesc(Color color) {
        List<Piece> pieceList = new ArrayList<>();
        for(Rank rank : board){
            rank.addPieceOfSameColor(pieceList, color);
        }
        Collections.sort(pieceList, new Comparator<Piece>() {
            @Override
            public int compare(Piece o1, Piece o2) {
                return Double.compare(o2.getScore(), o1.getScore());
            }
        });
        return pieceList;
    }

//    public int getDistance(Position p1, Position p2){
//        return 1;
//    }

    public void move(Position source, Position target){
        Piece sourcePiece = findPieceByPosition(source);
        if(!sourcePiece.canMove(source, target, this)){
            throw new IllegalArgumentException(sourcePiece + "는 " + target + "으로 움직일 수 없습니다.");
        }

        insertPiece(target, sourcePiece);
        insertPiece(source, Blank.create());
    }
}
