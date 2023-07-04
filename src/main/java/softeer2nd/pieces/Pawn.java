package softeer2nd.pieces;

public class Pawn {
    private String color;
    private Character representation;

    /**
     * 자바 상수 구현
     */
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";
    public final static Character BLACK_REPRESENTATION = 'P';
    public final static Character WHITE_REPRESENTATION = 'p';

    public Pawn(String color, Character representation){
        this.color = color;
        this.representation = representation;
    }

    public Pawn() {
        this.color = WHITE_COLOR;
        this.representation = WHITE_REPRESENTATION;
    }

    public String getColor() {
        return color;
    }

    public Character getRepresentation() {
        return representation;
    }

    @Override
    public String toString() {
        return this.representation.toString();
    }
}
