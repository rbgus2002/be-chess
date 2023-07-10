package softeer2nd.utils;

import org.junit.jupiter.api.BeforeEach;

public class Board {
    protected softeer2nd.chess.Board board;

    @BeforeEach
    void initBoard() {
        board = new softeer2nd.chess.Board();
    }
}
