package softeer2nd.chess;

import softeer2nd.pieces.Piece;
import softeer2nd.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static softeer2nd.pieces.Piece.*;
import static softeer2nd.pieces.Piece.Color.BLACK;
import static softeer2nd.pieces.Piece.Color.WHITE;
import static softeer2nd.pieces.Piece.createWhiteKing;

public class Board {
    private final int SIZE = 8;

    List<List<Piece>> board;

    public Board() {
    }

    public void initialize() {
        board = new ArrayList<>();

        board.add(initBlackFirstLine());
        board.add(initPawnLine(BLACK));
        board.add(initBlank());
        board.add(initBlank());
        board.add(initBlank());
        board.add(initBlank());
        board.add(initPawnLine(WHITE));
        board.add(initWhiteFirstLine());
    }

    private List<Piece> initPawnLine(Color color){
        List<Piece> pawnList = new ArrayList<>();
        for(int col = 0; col < SIZE; col++){
            pawnList.add((color == WHITE) ? createWhitePawn() : createBlackPawn());
        }
        return pawnList;
    }

    // TODO : stream 학습 후 적용
    private List<Piece> initBlank(){
        List<Piece> blankList = new ArrayList<>();
        for(int col = 0; col < SIZE; col++){
            blankList.add(createBlank());
        }
        return blankList;
    }
    
    private List<Piece> initBlackFirstLine(){
        List<Piece> blackList = new ArrayList<>();
        blackList.add(createBlackRook());
        blackList.add(createBlackKnight());
        blackList.add(createBlackBishop());
        blackList.add(createBlackQueen());
        blackList.add(createBlackKing());
        blackList.add(createBlackBishop());
        blackList.add(createBlackKnight());
        blackList.add(createBlackRook());

        return blackList;
    }

    private List<Piece> initWhiteFirstLine(){
        List<Piece> whiteList = new ArrayList<>();
        whiteList.add(createWhiteRook());
        whiteList.add(createWhiteKnight());
        whiteList.add(createWhiteBishop());
        whiteList.add(createWhiteQueen());
        whiteList.add(createWhiteKing());
        whiteList.add(createWhiteBishop());
        whiteList.add(createWhiteKnight());
        whiteList.add(createWhiteRook());

        return whiteList;
    }

    public String showBoard() {
        return this.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Piece> row : board){
            for(Piece piece : row)
                sb.append(piece);
            sb.append(StringUtils.appendNewLine(""));
        }

        return sb.toString();
    }

    public int pieceCount() {
        int size = 0;
        for(List<Piece> row : board){
            for(Piece col : row){
                size += (col.isBlank()) ? 0 : 1;
            }
        }

        return size;
    }
}
