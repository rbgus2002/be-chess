package softeer2nd.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.*;
import static softeer2nd.utils.PositionFactory.*;

class KingTest extends Board {
    @Test
    @DisplayName("King을 생성한다")
    void createKing() {
        // given, when
        Piece whiteKing = King.from(WHITE);
        Piece blackKing = King.from(BLACK);

        // then
        assertEquals("K", blackKing.toString());
        assertEquals("k", whiteKing.toString());
    }

    @Nested
    class verifyKingMove {
        @Test
        @DisplayName("이동하려는 위치에 같은 편 기물이 존재하는 경우 King 이동에 실패한다")
        void kingMoveFailureWhenSameTeamPieceExistsInTarget() {
            // given
            board.initializeEmpty();
            Piece king = King.from(WHITE);

            board.insertPiece(E1, king);
            board.insertPiece(E2, Pawn.from(WHITE));

            // when
            boolean move = king.canMove(E1, E2, board);

            // then
            assertFalse(move);
        }

        @Test
        @DisplayName("두 칸 이상 이동을 시도하는 경우 King 이동에 실패한다")
        void kingMoveFailureWhenMovingMoreThanTwoDistance() {
            // given
            board.initializeEmpty();

            Piece king = King.from(WHITE);
            board.insertPiece(E1, king);

            // when
            boolean move = king.canMove(E1, E3, board);

            // then
            assertFalse(move);
        }

        @Test
        @DisplayName("King은 수평 및 수직 방향으로 한칸 이동 가능하다")
        void moveHorizontalOrVertical() {
            // given
            board.initializeEmpty();
            Piece king = King.from(WHITE);

            board.insertPiece(E1, king);

            // when
            boolean move = king.canMove(E1, E2, board);

            // then
            assertTrue(move);
        }

        @Test
        @DisplayName("King은 대각선으로 한칸 이동 가능하다.")
        void moveDiagonal() {
            // given
            board.initializeEmpty();
            Piece king = King.from(WHITE);

            board.insertPiece(E1, king);

            // when
            boolean move = king.canMove(E1, F2, board);

            // then
            assertTrue(move);
        }
    }

    @Test
    @DisplayName("King이 체스판 내에서 한 칸 이동한다")
    void moveKing() {
        // given
        board.initializeEmpty();
        Piece king = King.from(WHITE);
        board.insertPiece(E1, king);

        // when
        board.move(E1, E2);
        Piece moved = board.findPieceByPosition(E2);

        // then
        assertEquals(king, moved);
    }
}
