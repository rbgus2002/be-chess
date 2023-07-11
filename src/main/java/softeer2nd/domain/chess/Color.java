package softeer2nd.domain.chess;

public enum Color {
    WHITE("흰색"),
    BLACK("검정색"),
    NONE("");

    final private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
