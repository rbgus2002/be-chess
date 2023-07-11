package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Color;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.*;
import static softeer2nd.utils.PositionFactory.*;

class PawnTest extends Board {
    @Test
    @DisplayName("적이 존재하면 대각선으로 한칸 움직이는 것이 가능하다")
    void canMoveToDiagonalWhenExistEnemy(){
        // given
        board.initializeEmpty();
        board.insertPiece(A2, Pawn.from(WHITE));
        board.insertPiece(B3, Pawn.from(BLACK));

        // when
        boolean move = Pawn.from(WHITE).canMove(A2, B3, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("대각선으로 두칸 이상 움직이는 것은 불가능하다")
    void canNotMoveMoreThanTwoDistance(){
        // given
        board.initializeEmpty();
        board.insertPiece(A1, Pawn.from(WHITE));
        board.insertPiece(C3, Pawn.from(BLACK));

        // when
        boolean move = Pawn.from(WHITE).canMove(A1, C3, board);

        // then
        assertFalse(move);
    }

    @Test
    @DisplayName("수직으로 움직일 때 목적지가 빈칸이 아니면 이동이 불가능하다")
    void canNotMoveToNotBlank(){
        // given
        board.initializeEmpty();
        board.insertPiece(A2, Pawn.from(WHITE));
        board.insertPiece(A3, Pawn.from(BLACK));

        // when
        boolean move = Pawn.from(WHITE).canMove(A2, A3, board);

        // then
        assertFalse(move);
    }

    @Nested
    class canNotMove{
        @Test
        @DisplayName("하얀색 폰이 처음에만 두 칸 움직일 수 있다")
        void canMoveTwoDistanceOnlyFirstTime(){
            // given
            board.initializeEmpty();
            board.insertPiece(A2, Pawn.from(WHITE));

            // when
            boolean move = Pawn.from(WHITE).canMove(A2, A4, board);

            // then
            assertTrue(move);
        }

        @Test
        @DisplayName("하얀색 폰이 처음이 아니면 두 칸을 움직일 수 없다")
        void canNotMoveTwoDistance(){
            // given
            board.initializeEmpty();
            board.insertPiece(A2, Pawn.from(WHITE));

            // when
            boolean move = Pawn.from(WHITE).canMove(A3, A5, board);

            // then
            assertFalse(move);
        }
    }


}