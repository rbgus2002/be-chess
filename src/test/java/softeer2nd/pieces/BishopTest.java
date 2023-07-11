package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;

class BishopTest extends Board {
    @Test
    @DisplayName("비숍은 대각선으로 이동이 가능하다")
    void canMoveDiagonal() {
        // given
        board.initializeEmpty();
        Piece bishop = Bishop.from(WHITE);

        // when
        boolean move = bishop.canMove(B1, D3, board);

        // then
        assertTrue(move);
    }

    @Nested
    class move {
        @Test
        @DisplayName("비숍은 대각선으로 이동할 수 있다")
        void moveToDiagonal() {
            // given
            board.initializeEmpty();
            board.insertPiece(B1, Bishop.from(WHITE));

            // when
            board.move(B1, D3);

            // then
            assertEquals(Bishop.from(WHITE), board.findPieceByPosition(D3));
        }

        @Test
        @DisplayName("시작점과 도착점 사이에 다른 기물이 존재하는 경우 실패한다")
        void moveFail(){
            // given, when
            board.initializeEmpty();
            board.insertPiece(B1, Bishop.from(WHITE));
            board.insertPiece(C2, Pawn.from(WHITE));

            // then
            assertThrows(IllegalArgumentException.class, () -> board.move(B1, D3));
        }
    }
}