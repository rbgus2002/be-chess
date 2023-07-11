package softeer2nd.domain.pieces;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Color;
import softeer2nd.domain.chess.Position;

import java.util.Objects;

import static softeer2nd.domain.chess.Color.*;

public abstract class Piece {
    private final Color color;
    protected final String representation;
    private final double score; // TODO : 삭제 고려

    public Piece(Color color, String representation, double score) {
        this.color = color;
        this.representation = setRepresentation(representation);
        this.score = score;
    }

    private String setRepresentation(String representation) {
        if (this.color == BLACK) {
            return representation.toUpperCase();
        }
        return representation;
    }

    public boolean isBlack() {
        return this.color == BLACK;
    }

    public boolean isWhite() {
        return this.color == WHITE;
    }

    public boolean isBlank(){
        return isTypeOf(Blank.class);
    }

    public boolean isSameColor(Piece piece) {
        return this.color == piece.getColor();
    }

    public String getRepresentation() {
        return representation;
    }

    public Color getColor() {
        return color;
    }

    public boolean isTypeOf(Class<?> target) {
        return target.isInstance(this);
    }

    public boolean isKnight() {
        return isTypeOf(Knight.class);
    }
    public boolean isKing() {
        return isTypeOf(King.class);
    }

    public boolean isTeam(Piece target){
        if(this.isBlank() || target.isBlank())
            return false;
        return this.isSameColor(target);
    }

    public boolean isEnemy(Piece target){
        if(this.isBlank() || target.isBlank())
            return false;
        return !this.isSameColor(target);
    }

    abstract public boolean canMove(Position source, Position target, Board board);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && Objects.equals(representation, piece.representation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, representation);
    }

    @Override
    public String toString() {
        return representation;
    }
}
