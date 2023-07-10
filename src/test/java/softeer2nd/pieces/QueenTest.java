package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest extends Board {
    @Test
    @DisplayName("퀸은 수평으로 이동할 수 있다")
    void moveHorizontal(){
        // given
        board.initializeEmpty();

        Piece queen = Queen.from(Color.WHITE);
        Position p1 = Position.of("d1");
        Position p2 = Position.of("g1");

        // when
        boolean move = queen.canMove(p1, p2, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 수직으로 이동할 수 있다")
    void moveVertical(){
        // given
        board.initializeEmpty();

        Piece queen = Queen.from(Color.WHITE);
        Position p1 = Position.of("d1");
        Position p2 = Position.of("d5");

        // when
        boolean move = queen.canMove(p1, p2, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 대각선으로 이동할 수 있다")
    void moveDiagonal(){
        // given
        board.initializeEmpty();

        Piece queen = Queen.from(Color.WHITE);
        Position p1 = Position.of("d1");
        Position p2 = Position.of("h5");

        // when
        boolean move = queen.canMove(p1, p2, board);

        // then
        assertTrue(move);
    }
}