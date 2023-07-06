package softeer2nd.chess;

public class Point {
    private char file;
    private int rank;

    private Point(String point) {
        validate(point);
        this.file = point.charAt(0);
        this.rank = (point.charAt(1) - '0') - 1; // idx 0부터 시작하기 때문에 -1
    }

    public static Point of(String point){
        return new Point(point);
    }

    /**
     * 좌표가 유효하지 않은 경우
     * 1. 길이가 2가 아닌 경우
     * 2. 첫 글자가 'a' ~ 'h'가 아닌 경우
     * 3. 마지막 글자가 '1' ~ '8'가 아닌 경우
     */
    private void validate(String point){
        if(point.length() != 2)
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        if(!isValidFile(point.charAt(0))){
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
        if(!isValidRank(point.charAt(1))){
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
    }

    private boolean isValidFile(char file){
        return file >= 'a' && file <= 'h';
    }

    private boolean isValidRank(char rank){
        return rank >= '1' && rank <= '8';
    }

    public int getFileToInt() {
        return file - 'a';
    }

    public int getRank() {
        return rank;
    }
}
