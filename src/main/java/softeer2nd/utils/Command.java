package softeer2nd.utils;

import softeer2nd.exception.IllegalCommandException;

public class Command {
    private final String START = "start";
    private final String END = "end";
    private final String MOVE = "move";
    private String input;

    private Command(String input) {
        validateInput(input);
        this.input = input;
    }

    public static Command from(String input) {
        return new Command(input);
    }

    private void validateInput(String input) {
        if (input.equals(START) || input.equals(END) || input.startsWith(MOVE)) {
            return;
        }
        throw new IllegalCommandException("잘못된 명령어입니다");
    }

    public boolean isMove(){
        return input.startsWith(MOVE);
    }

    public boolean isEnd(){
        return input.equals(END);
    }

    public String getSource(){
        if(!isMove()){
            throw new IllegalCommandException("move 명령어가 아니면 해당 함수를 호출할 수 없습니다");
        }
        return input.split(" ")[1];
    }

    public String getTarget() {
        if(!isMove()){
            throw new IllegalCommandException("move 명령어가 아니면 해당 함수를 호출할 수 없습니다");
        }
        return input.split(" ")[2];
    }
}
