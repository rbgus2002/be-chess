package softeer2nd.View;

import softeer2nd.domain.chess.Board;
import softeer2nd.domain.chess.Turn;
import softeer2nd.utils.StringUtils;

public class OutputView {
    public void printStart(){
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.appendNewLine("Game Start!"));
        sb.append(StringUtils.appendNewLine("1. start (show board)"));
        sb.append(StringUtils.appendNewLine("2. move"));
        sb.append(StringUtils.appendNewLine("3. end"));
        System.out.print(sb);
    }

    public void printEnd(){
        System.out.println("Game End!");
    }

    public void printEnd(Turn turn){
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.appendNewLine(turn.getNowTurn() + "의 승리입니다"));
        sb.append(StringUtils.appendNewLine("Game End!"));
        System.out.print(sb);
    }

    public void printBoard(Board board){
        System.out.println(board.showBoard());
    }

    public void printError(RuntimeException e){
        StringBuilder sb = new StringBuilder();
        sb.append("[ERROR] : ");
        sb.append(StringUtils.appendNewLine((e.getMessage())));
        sb.append(StringUtils.appendNewLine("명령어를 다시 입력해주세요"));
        System.out.print(sb);
    }

    public void printNowTurn(Turn turn) {
        StringBuilder sb = new StringBuilder();
        sb.append(turn.getNowTurn());
        sb.append(StringUtils.appendNewLine(" 차례 입니다"));
        System.out.print(sb);
    }
}
