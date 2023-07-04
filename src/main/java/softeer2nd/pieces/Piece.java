package softeer2nd.pieces;

public class Piece {
    private String name; //  pawn, knight, rook, bishop, queen, king
    private String color;
    private Character representation;

    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static Character WHITE_PAWN_REPRESENTATION = 'p';
    public final static Character BLACK_PAWN_REPRESENTATION = 'P';

    private Piece() {
    }

    private Piece(String name, String color, Character representation) {
        this.name = name;
        this.color = color;
        this.representation = representation;
    }

    public static Piece init(String name, String color, Character representation) {
        return new Piece(name, color, representation);
    }

    public static Piece createWhitePawn(){
        return init("pawn", WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
    }

    public static Piece createBlackPawn() {
        return init("pawn", BLACK_COLOR, BLACK_PAWN_REPRESENTATION);
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public Character getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        char ch = this.name.charAt(0);
        if(color.equals("white")){
            ch = Character.toLowerCase(ch);
        }else{
            ch = Character.toUpperCase(ch);
        }

        return Character.toString(ch);
    }
}
