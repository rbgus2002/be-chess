package softeer2nd.pieces;

import static softeer2nd.pieces.Piece.Color.*;
import static softeer2nd.pieces.Piece.Type.*;

public class Piece {
    private Color color;
    private Type type;

    public enum Color {
        WHITE, BLACK, NONE;
    }

    public enum Type {
        PAWN('p', 1.0), KNIGHT('n', 2.5), ROOK('r', 5.0), BISHOP('b', 3), QUEEN('q', 9), KING('k', 0), NO_PIECE('.', 0);

        private char representation;
        private double score;

        Type(char representation, double score) {
            this.representation = representation;
            this.score = score;
        }

        public char getRepresentation() {
            return representation;
        }

        public double getScore() {
            return score;
        }
    }

    private Piece() {
    }

    public Piece(Type typeEnum, Color colorEnum) {
        this.type = typeEnum;
        this.color = colorEnum;
    }

    /**
     * 정적 팩토리 메소드
     */
    public static Piece createWhitePawn() {
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn() {
        return createBlack(PAWN);
    }

    public static Piece createWhiteKnight() {
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight() {
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook() {
        return createWhite(ROOK);
    }

    public static Piece createBlackRook() {
        return createBlack(ROOK);
    }

    public static Piece createWhiteBishop() {
        return createWhite(BISHOP);
    }

    public static Piece createBlackBishop() {
        return createBlack(BISHOP);
    }

    public static Piece createWhiteQueen() {
        return createWhite(QUEEN);
    }

    public static Piece createBlackQueen() {
        return createBlack(QUEEN);
    }

    public static Piece createWhiteKing() {
        return createWhite(KING);
    }

    public static Piece createBlackKing() {
        return createBlack(KING);
    }

    public static Piece createBlank() {
        return new Piece(NO_PIECE, NONE);
    }

    private static Piece createWhite(Type type) {
        return new Piece(type, WHITE);
    }

    private static Piece createBlack(Type type) {
        return new Piece(type, BLACK);
    }

    public Character getRepresentation() {
        if (color == BLACK) {
            return Character.toUpperCase(type.getRepresentation());
        }
        return type.getRepresentation();
    }

    public boolean isWhite() {
        return color == WHITE;
    }

    public boolean isBlack() {
        return color == BLACK;
    }

    public boolean isBlank() {
        return type == NO_PIECE;
    }

    public boolean isPawn() {
        return this.type == PAWN;
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public boolean isSameTypeAndColor(Type type, Color color) {
        return this.type == type && this.color == color;
    }

    @Override
    public String toString() {
        return getRepresentation().toString();
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
