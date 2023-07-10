package softeer2nd.chess;

public class Position {
    private int file;
    private int rank;

    private Position(String position) {
        validate(position);
        this.file = position.charAt(0) - 'a';
        this.rank = (position.charAt(1) - '0') - 1; // idx 0부터 시작하기 때문에 -1
    }

    public static Position of(String position){
        return new Position(position);
    }

    /**
     * 좌표가 유효하지 않은 경우
     * 1. 길이가 2가 아닌 경우
     * 2. 첫 글자가 'a' ~ 'h'가 아닌 경우
     * 3. 마지막 글자가 '1' ~ '8'가 아닌 경우
     */
    private void validate(String position){
        if(position.length() != 2)
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        if(!isValidFile(position.charAt(0))){
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
        if(!isValidRank(position.charAt(1))){
            throw new IllegalArgumentException("잘못된 좌표입니다.");
        }
    }

    private boolean isValidFile(char file){
        return file >= 'a' && file <= 'h';
    }

    private boolean isValidRank(char rank){
        return rank >= '1' && rank <= '8';
    }

    public int getFile() {
        return file;
    }

    public int getRank() {
        return rank;
    }

    public boolean isVertical(Position target){
        return this.file == target.file;
    }

    public boolean isHorizontal(Position target){
        return this.rank == target.rank;
    }

    public boolean isDiagonal(Position target){
        return getFileDistance(target) == getRankDistance(target);
    }

    public int getFileDistance(Position target) {
        return Math.abs(this.rank - target.rank);
    }

    public int getRankDistance(Position target) {
        return Math.abs(this.file - target.file);
    }

    @Override
    public String toString() {
        return (char)(file + 'a') + Integer.toString(rank + 1);
    }
}
