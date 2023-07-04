package softeer2nd.pieces;

public class Piece {
    private String name; //  pawn, knight, rook, bishop, queen, king
    private String color;

    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";

    public final static String PAWN = "pawn";


    private Piece() {
    }

    private Piece(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public static Piece init(String name, String color) {
        return new Piece(name, color);
    }

    public static Piece createWhitePawn(){
        return init(PAWN, WHITE_COLOR);
    }

    public static Piece createBlackPawn() {
        return init(PAWN, BLACK_COLOR);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Character getRepresentation() {
        char ch = this.name.charAt(0);
        if(color.equals(WHITE_COLOR)){
            ch = Character.toLowerCase(ch);
        }else{
            ch = Character.toUpperCase(ch);
        }

        return ch;
    }

    @Override
    public String toString() {
        char ch = this.name.charAt(0);
        if(color.equals(WHITE_COLOR)){
            ch = Character.toLowerCase(ch);
        }else{
            ch = Character.toUpperCase(ch);
        }

        return Character.toString(ch);
    }
}
