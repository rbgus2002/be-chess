package softeer2nd.pieces;

public class Piece {
    private String name; // pawn, knight, rook, bishop, queen, king
    private String color;

    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";

    public final static String PAWN = "pawn";
    public final static String KNIGHT = "knight";
    public final static String ROOK = "rook";
    public final static String BISHOP = "bishop";
    public final static String QUEEN = "queen";
    public final static String KING = "king";


    private Piece() {
    }

    private Piece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Piece 생성을 위한 팩토리 메소드
     */
    public static Piece createWhitePawn() {
        return new Piece(PAWN, WHITE_COLOR);
    }
    public static Piece createBlackPawn() {
        return new Piece(PAWN, BLACK_COLOR);
    }
    public static Piece createWhiteKnight() {
        return new Piece(KNIGHT, WHITE_COLOR);
    }
    public static Piece createBlackKnight() {
        return new Piece(KNIGHT, BLACK_COLOR);
    }
    public static Piece createWhiteRook() {
        return new Piece(ROOK, WHITE_COLOR);
    }
    public static Piece createBlackRook() {
        return new Piece(ROOK, BLACK_COLOR);
    }
    public static Piece createWhiteBishop() {
        return new Piece(BISHOP, WHITE_COLOR);
    }
    public static Piece createBlackBishop() {
        return new Piece(BISHOP, BLACK_COLOR);
    }
    public static Piece createWhiteQueen() {
        return new Piece(QUEEN, WHITE_COLOR);
    }
    public static Piece createBlackQueen() {
        return new Piece(QUEEN, BLACK_COLOR);
    }
    public static Piece createWhiteKing() {
        return new Piece(KING, WHITE_COLOR);
    }
    public static Piece createBlackKing() {
        return new Piece(KING, BLACK_COLOR);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Character getRepresentation() {
        char ch = (!this.name.equals(KNIGHT) ? this.name.charAt(0) : this.name.charAt(1));
        if (color.equals(WHITE_COLOR)) {
            ch = Character.toLowerCase(ch);
        } else {
            ch = Character.toUpperCase(ch);
        }

        return ch;
    }

    public boolean isWhite() {
        return this.color.equals(WHITE_COLOR);
    }

    public boolean isBlack() {
        return this.color.equals(BLACK_COLOR);
    }

    @Override
    public String toString() {
        return getRepresentation().toString();
    }
}
