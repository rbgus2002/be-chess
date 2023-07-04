package softeer2nd.pieces;

public class Pawn {
    String color;

    /**
     * 자바 상수 구현
     */
    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";

    public Pawn(String color){
        this.color = color;
    }

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public String getColor() {
        return color;
    }
}
