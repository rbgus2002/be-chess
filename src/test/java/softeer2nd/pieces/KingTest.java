package softeer2nd.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Position;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.*;

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
            Position source = Position.of("e1");
            board.insertPiece(source, king);

            Position target = Position.of("e2");
            board.insertPiece(target, Pawn.from(WHITE));

            // when
            boolean move = king.canMove(source, target, board);

            // then
            assertFalse(move);
        }

        @Test
        @DisplayName("두 칸 이상 이동을 시도하는 경우 King 이동에 실패한다")
        void kingMoveFailureWhenMovingMoreThanTwoDistance() {
            // given
            board.initializeEmpty();

            Position source = Position.of("e1");
            Position target = Position.of("e3");

            Piece king = King.from(WHITE);
            board.insertPiece(source, king);

            // when
            boolean move = king.canMove(source, target, board);

            // then
            assertFalse(move);
        }

        @Test
        @DisplayName("King은 수평 및 수직 방향으로 한칸 이동 가능하다")
        void moveHorizontalOrVertical() {
            // given
            board.initializeEmpty();

            Position source = Position.of("e1");
            Position target = Position.of("e2");

            Piece king = King.from(WHITE);
            board.insertPiece(source, king);

            // when
            boolean move = king.canMove(source, target, board);

            // then
            assertTrue(move);
        }

        @Test
        @DisplayName("King은 대각선으로 한칸 이동 가능하다.")
        void moveDiagonal() {
            // given
            board.initializeEmpty();

            Position source = Position.of("e1");
            Position target = Position.of("f2");

            Piece king = King.from(WHITE);
            board.insertPiece(source, king);

            // when
            boolean move = king.canMove(source, target, board);

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
        board.insertPiece(Position.of("e1"), king);

        // when
        board.move(Position.of("e1"), Position.of("e2"));
        Piece moved = board.findPieceByPosition(Position.of("e2"));

        // then
        assertEquals(king, moved);
    }
}
