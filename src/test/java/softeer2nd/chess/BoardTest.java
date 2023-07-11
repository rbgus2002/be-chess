package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.BLACK;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    private Board board;

    @BeforeEach
    void initBoard() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판이 알맞게 초기화 되었는지 확인한다")
    public void initialize() {
        // given, when
        board.initialize();

        // then
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

    @Nested
    class FindPieceByPosition {
        @Test
        @DisplayName("유효하지 않은 좌표의 경우 예외를 던진다")
        void findPieceByInvalidPoint() {
            // given
            String invalidPoint1 = "a88";
            String invalidPoint2 = "88";
            String invalidPoint3 = "aa";
            String invalidPoint4 = "a9";
            String invalidPoint5 = "j9";

            // when
            board.initialize();

            // then
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPosition(Position.of(invalidPoint1)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPosition(Position.of(invalidPoint2)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPosition(Position.of(invalidPoint3)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPosition(Position.of(invalidPoint4)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPosition(Position.of(invalidPoint5)));
        }

        @Test
        @DisplayName("기물의 위치를 조회해서 가져온다")
        void findPieceByPoint() {
            // given, when
            board.initialize();

            // then
            assertAll(
                    () -> assertEquals(BLACK, board.findPieceByPosition(A8).getColor()),
                    () -> assertEquals(Rook.from(BLACK), board.findPieceByPosition(A8)),
                    () -> assertEquals(King.from(WHITE), board.findPieceByPosition(E1))
            );
        }
    }

    @Test
    @DisplayName("빈 체스판을 초기화 한다")
    void initializeEmpty() {
        // given, when
        board.initializeEmpty();

        // then
        String blankRank = appendNewLine("........");
        assertEquals(
                blankRank + blankRank + blankRank + blankRank +
                        blankRank + blankRank + blankRank + blankRank,
                board.showBoard());
    }

    @Test
    @DisplayName("빈 체스판에 기물을 추가한다")
    void moveInEmptyBoard() {
        // given
        board.initializeEmpty();

        // when
        Piece blackPawn = Pawn.from(BLACK);
        board.insertPiece(C5, blackPawn);

        // then
        assertEquals(blackPawn, board.findPieceByPosition(C5));
    }

    @Test
    @DisplayName("중간에 다른 기물이 존재하면 움직일 수 없다")
    void existOtherPiece(){
        // given, when
        board.initializeEmpty();
        board.insertPiece(D1, Queen.from(WHITE));
        board.insertPiece(D2, Pawn.from(WHITE));

        // then
        assertThrows(IllegalArgumentException.class, () -> board.move(D1, D4));
    }
}