package softeer2nd.manager;

import softeer2nd.chess.Board;
import softeer2nd.chess.Position;

public class Game {
    private final String START = "start";
    private final String END = "end";
    private final String MOVE = "move";

    private Board board;
    private final InputView inputView;
    private final OutputView outputView;
    private boolean gameContinue;

    public Game() {
        this.board = new Board();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.gameContinue = true;
    }

    // TODO : Game 객체가 명령어 유효성을 검증해주는게 마음에 들지 않음
    public void run() {
        outputView.printToStart();
        board.initialize();

        try{
            do {
                instruct(inputView.read());
                outputView.printBoard(board);
            }while (gameContinue);
        }catch (IllegalArgumentException e){
            outputView.printError(e);
            run();
        }

        outputView.printToEnd();
    }

    private void instruct(String input) {
        verifyInput(input);

        if(input.startsWith(MOVE)){
            move(input);
        }else if(input.equals(END)){
            gameContinue = false;
        }
    }

    private void move(String input) {
        String[] inputs = input.split(" ");
        Position source = Position.of(inputs[1]);
        Position target = Position.of(inputs[2]);

        verifyMove(inputs[1], inputs[2]);

        board.move(Position.of(source), Position.of(target));
    }

    private void verifyMove(String source, String target){
        verifySameSourceAndTarget(source, target);
        verifyTarget(Position.of(source), Position.of(target));
    }

    private void verifyTarget(Position source, Position target) {
        if(board.findPieceByPosition(source).isTeam(board.findPieceByPosition(target))){
            throw new IllegalArgumentException("같은 팀 기물의 위치로 이동할 수 없습니다");
        }
    }

    private void verifySameSourceAndTarget(String source, String target) {
        if(source.equals(target)){
            throw new IllegalArgumentException("시작점과 동일한 위치로 이동할 수 없습니다.");
        }
    }


    // TODO : 유효성 검증하는 메소드 이름 통일
    private void verifyInput(String input){
        if(input.equals(START) || input.equals(END) || input.startsWith(MOVE)){
            return;
        }

        throw new IllegalArgumentException("잘못된 명령어입니다.");
    }
}
