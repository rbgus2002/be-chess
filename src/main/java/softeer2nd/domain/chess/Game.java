package softeer2nd.domain.chess;

import softeer2nd.View.InputView;
import softeer2nd.View.OutputView;
import softeer2nd.domain.pieces.Piece;
import softeer2nd.utils.Command;

public class Game {
    private final Board board;
    private final InputView inputView;
    private final OutputView outputView;
    private final Turn turn;

    public Game() {
        this.board = new Board();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.turn = Turn.init();
    }

    public void run() {
        outputView.printStart();
        board.initialize();

        execute();
    }

    private void execute() {
        try{
            do {
                outputView.printBoard(board);
                outputView.printNowTurn(turn);
                Command now = Command.from(inputView.read());
                instruct(now);
            } while (turn.progress());
        }catch (RuntimeException e){
            outputView.printError(e);
            execute();
        }
    }

    private void instruct(Command now) {
        if(now.isEnd()){
            outputView.printEnd();
            finishGame();
            return;
        }
        if(now.isMove()){
            move(now);
        }
    }

    private void move(Command now) {
        Piece originalTarget = board.findPieceByPosition(Position.of(now.getTarget()));

        verifyTurn(Position.of(now.getSource()));
        verifyMove(now.getSource(), now.getTarget());
        board.move(Position.of(now.getSource()), Position.of(now.getTarget()));
        checkFinishGame(originalTarget);
        turn.nextTurn();
    }

    private void verifyTurn(Position source) {
        Piece sourcePiece = board.findPieceByPosition(source);
        if(sourcePiece.isBlank()){
            return;
        }

        if(!turn.validateTurn(sourcePiece)){
            throw new IllegalArgumentException("선택한 기물의 차례가 아닙니다");
        }
    }

    private void verifyMove(String source, String target) {
        verifySameSourceAndTarget(source, target);
        verifyTarget(Position.of(source), Position.of(target));
    }

    private void verifySameSourceAndTarget(String source, String target) {
        if (source.equals(target)) {
            throw new IllegalArgumentException("시작점과 동일한 위치로 이동할 수 없습니다");
        }
    }

    private void verifyTarget(Position source, Position target) {
        if (board.findPieceByPosition(source).isTeam(board.findPieceByPosition(target))) {
            throw new IllegalArgumentException("같은 팀 기물의 위치로 이동할 수 없습니다");
        }
    }

    private void checkFinishGame(Piece originalTarget) {
        if(originalTarget.isKing()){
            outputView.printEnd(turn);
            finishGame();
        }
    }

    private void finishGame(){
        turn.finishGame();
    }
}
