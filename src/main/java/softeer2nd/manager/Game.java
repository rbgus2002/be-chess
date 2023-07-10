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
        String source = inputs[1];
        String target = inputs[2];

        board.move(Position.of(source), Position.of(target));
    }

    private void verifyInput(String input){
        if(input.equals(START) || input.equals(END) || input.startsWith(MOVE)){
            return;
        }

        throw new IllegalArgumentException("잘못된 명령어입니다.");
    }
}
