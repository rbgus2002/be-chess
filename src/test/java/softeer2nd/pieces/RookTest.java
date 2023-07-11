package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;

class RookTest extends Board {

    @Nested
    class canMove{
        @Test
        @DisplayName("룩은 수직으로 이동 가능하다")
        void canMoveVertical(){
            // given
            board.initializeEmpty();
            Piece rook = Rook.from(WHITE);

            // when
            boolean move = rook.canMove(A1, A6, board);

            // then
            assertTrue(move);
        }

        @Test
        @DisplayName("룩은 수평으로 이동 가능하다")
        void canMoveHorizontal(){
            // given
            board.initializeEmpty();
            Piece rook = Rook.from(WHITE);

            // when
            boolean move = rook.canMove(A1, G1, board);

            // then
            assertTrue(move);
        }
    }

    @Nested
    class move{
        @Test
        @DisplayName("룩은 수직으로 이동할 수 있다")
        void moveVertical(){
            // given
            board.initializeEmpty();
            board.insertPiece(A1, Rook.from(WHITE));

            // when
            board.move(A1, A5);

            // then
            assertEquals(Rook.from(WHITE), board.findPieceByPosition(A5));
        }

        @Test
        @DisplayName("룩은 수평으로 이동할 수 있다")
        void moveHorizontal(){
            // given
            board.initializeEmpty();
            board.insertPiece(A1, Rook.from(WHITE));

            // when
            board.move(A1, D1);

            // then
            assertEquals(Rook.from(WHITE), board.findPieceByPosition(D1));
        }

        @Test
        @DisplayName("시작점과 도착점 사이에 다른 기물이 존재하는 경우 실패한다")
        void moveFail(){
            // given, when
            board.initializeEmpty();
            board.insertPiece(A1, Rook.from(WHITE));
            board.insertPiece(A3, Pawn.from(WHITE));

            // then
            assertThrows(IllegalArgumentException.class, () -> board.move(A1, A5));
        }
    }
}