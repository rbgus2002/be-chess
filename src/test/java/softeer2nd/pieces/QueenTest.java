package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.PositionFactory.*;

class QueenTest extends Board {
    @Test
    @DisplayName("퀸은 수평으로 이동할 수 있다")
    void moveHorizontal(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(Color.WHITE);

        // when
        boolean move = queen.canMove(D1, G1, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 수직으로 이동할 수 있다")
    void moveVertical(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(Color.WHITE);

        // when
        boolean move = queen.canMove(D1, D5, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 대각선으로 이동할 수 있다")
    void moveDiagonal(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(Color.WHITE);

        // when
        boolean move = queen.canMove(D1, H5, board);

        // then
        assertTrue(move);
    }
}