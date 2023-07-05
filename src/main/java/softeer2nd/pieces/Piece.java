package softeer2nd.pieces;

public class Piece {
    private String name; //  pawn, knight, rook, bishop, queen, king
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

    public static Piece init(String name, String color) {
        return new Piece(name, color);
    }

    public static Piece createWhitePawn() {
        return init(PAWN, WHITE_COLOR);
    }

    public static Piece createBlackPawn() {
        return init(PAWN, BLACK_COLOR);
    }

    public static Piece createWhiteKnight() {
        return init(KNIGHT, WHITE_COLOR);
    }

    public static Piece createBlackKnight() {
        return init(KNIGHT, BLACK_COLOR);
    }

    public static Piece createWhiteRook() {
        return init(ROOK, WHITE_COLOR);
    }

    public static Piece createBlackRook() {
        return init(ROOK, BLACK_COLOR);
    }

    public static Piece createWhiteBishop() {
        return init(BISHOP, WHITE_COLOR);
    }

    public static Piece createBlackBishop() {
        return init(BISHOP, BLACK_COLOR);
    }

    public static Piece createWhiteQueen() {
        return init(QUEEN, WHITE_COLOR);
    }

    public static Piece createBlackQueen() {
        return init(QUEEN, BLACK_COLOR);
    }

    public static Piece createWhiteKing() {
        return init(KING, WHITE_COLOR);
    }

    public static Piece createBlackKing() {
        return init(KING, BLACK_COLOR);
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

    @Override
    public String toString() {
        return getRepresentation().toString();
    }
}
