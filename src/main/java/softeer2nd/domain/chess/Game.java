package softeer2nd.domain.chess;

import softeer2nd.View.InputView;
import softeer2nd.View.OutputView;
import softeer2nd.domain.pieces.Piece;
import softeer2nd.utils.Command;

public class Game {
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
        outputView.printStart();
        board.initialize();

        execute();
        outputView.printEnd();
    }

    private void execute() {
        try{
            do {
                Command now = Command.from(inputView.read());
                instruct(now);
            } while (gameContinue);
        }catch (RuntimeException e){
            outputView.printError(e);
            execute();
        }
    }

    private void instruct(Command now) {
        if(now.isEnd()){
            finishGame();
            return;
        }
        if(now.isMove()){
            move(now);
        }
        outputView.printBoard(board);
    }

    private void move(Command now) {
        Piece originalTarget = board.findPieceByPosition(Position.of(now.getTarget()));

        verifyMove(now.getSource(), now.getTarget());
        board.move(Position.of(now.getSource()), Position.of(now.getTarget()));
        checkFinishGame(originalTarget);
    }

    private void verifyMove(String source, String target) {
        verifySameSourceAndTarget(source, target);
        verifyTarget(Position.of(source), Position.of(target));
    }

    private void verifySameSourceAndTarget(String source, String target) {
        if (source.equals(target)) {
            throw new IllegalArgumentException("시작점과 동일한 위치로 이동할 수 없습니다.");
        }
    }

    private void verifyTarget(Position source, Position target) {
        if (board.findPieceByPosition(source).isTeam(board.findPieceByPosition(target))) {
            throw new IllegalArgumentException("같은 팀 기물의 위치로 이동할 수 없습니다");
        }
    }

    private void checkFinishGame(Piece originalTarget) {
        if(originalTarget.isKing()){
            finishGame();
        }
    }

    private void finishGame(){
//        outputView.printEnd(); // TODO : 킹이 잡혔음을 알리는 메세지 출력
        gameContinue = false;
    }
}
