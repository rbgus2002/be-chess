package softeer2nd.manager;

import softeer2nd.chess.Board;
import softeer2nd.utils.StringUtils;

public class OutputView {
    public void printToStart(){
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.appendNewLine("Game Start!"));
        sb.append(StringUtils.appendNewLine("1. start"));
        sb.append(StringUtils.appendNewLine("2. move"));
        sb.append(StringUtils.appendNewLine("3. end"));

        System.out.print(sb);
    }

    public void printToEnd(){
        System.out.println("Game End!");
    }

    public void printBoard(Board board){
        System.out.println(board.showBoard());
    }

    public void printError(RuntimeException e){
        System.out.println("[ERROR] : " + e.getMessage());
    }
}
