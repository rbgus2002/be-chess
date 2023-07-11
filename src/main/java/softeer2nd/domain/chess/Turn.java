package softeer2nd.domain.chess;

import softeer2nd.domain.pieces.Piece;

import static softeer2nd.domain.chess.Color.BLACK;
import static softeer2nd.domain.chess.Color.WHITE;

public class Turn {
    private Color now;
    private boolean gameContinue;

    private Turn() {
        this.now = WHITE; // 화이트 선공
        this.gameContinue = true;
    }

    public static Turn init(){
        return new Turn();
    }

    public void nextTurn(){
        now = (now == WHITE) ? BLACK : WHITE;
    }

    public boolean progress() {
        return gameContinue;
    }

    public void finishGame(){
        this.gameContinue = false;
    }

    public String getNowTurn() {
        return now.getName();
    }

    public boolean validateTurn(Piece source) {
        return now == source.getColor();
    }
}
