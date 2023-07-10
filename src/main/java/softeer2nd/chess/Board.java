package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.pieces.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static softeer2nd.pieces.Piece.*;
import static softeer2nd.pieces.Piece.Type.PAWN;
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

    public Piece findPieceByPosition(Position position) {
        return board.get(position.getRank()).getPieceAt(position.getFileToInt());
    }

    public void insertPiece(Position position, Piece piece) {
        board.get(position.getRank()).insertPiece(piece, position.getFileToInt());
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

            if(piece.isPawn()){
                pawnScore += piece.getType().getScore();
            }else{
                score += piece.getType().getScore();
            }
        }

        if(pawnScore > PAWN.getScore()){
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
                return Double.compare(o2.getType().getScore(), o1.getType().getScore());
            }
        });
        return pieceList;
    }

    public void move(Position source, Position target){
        insertPiece(target, findPieceByPosition(source));
        insertPiece(source, Piece.createBlank());
    }
}
