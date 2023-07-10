package softeer2nd.pieces;

import softeer2nd.chess.Color;
import softeer2nd.chess.Position;

import java.util.Objects;

import static softeer2nd.chess.Color.BLACK;
import static softeer2nd.chess.Color.WHITE;

public abstract class Piece {
    private final Color color;
    protected final String representation;
    private final double score;

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

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public String getRepresentation() {
        return representation;
    }

    public double getScore() {
        return score;
    }

    public Color getColor() {
        return color;
    }

    public boolean isTypeOf(Class<?> target) {
        return target.isInstance(this);
    }

    abstract boolean verifyMove(Position source, Position target);

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