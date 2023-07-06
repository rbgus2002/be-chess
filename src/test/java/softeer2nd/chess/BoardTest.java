package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.pieces.Piece.Color.*;
import static softeer2nd.pieces.Piece.Type.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    private final int PIECE_COUNT = 32;
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
    class GetPieceCount {
        @Test
        @DisplayName("체스판에서 전체 기물의 개수를 가져온다")
        void getAllPieceCount() {
            // given, when
            board.initialize();

            // then
            assertEquals(PIECE_COUNT, board.getPieceCount());
        }

        @Test
        @DisplayName("체스판에서 특정 기물의 개수를 가져온다")
        void getSpecificPieceCount() {
            // given
            final int PAWN_COUNT = 8;
            final int ROOK_COUNT = 2;
            final int BISHOP_COUNT = 2;
            final int KNIGHT_COUNT = 2;
            final int QUEEN_COUNT = 1;
            final int KING_COUNT = 1;

            // when
            board.initialize();

            // then
            assertAll(
                    () -> assertEquals(PAWN_COUNT, board.getPieceCount(PAWN, WHITE)),
                    () -> assertEquals(PAWN_COUNT, board.getPieceCount(PAWN, BLACK)),
                    () -> assertEquals(ROOK_COUNT, board.getPieceCount(ROOK, WHITE)),
                    () -> assertEquals(ROOK_COUNT, board.getPieceCount(ROOK, BLACK)),
                    () -> assertEquals(BISHOP_COUNT, board.getPieceCount(BISHOP, WHITE)),
                    () -> assertEquals(BISHOP_COUNT, board.getPieceCount(BISHOP, BLACK)),
                    () -> assertEquals(KNIGHT_COUNT, board.getPieceCount(KNIGHT, WHITE)),
                    () -> assertEquals(KNIGHT_COUNT, board.getPieceCount(KNIGHT, BLACK)),
                    () -> assertEquals(QUEEN_COUNT, board.getPieceCount(QUEEN, WHITE)),
                    () -> assertEquals(QUEEN_COUNT, board.getPieceCount(QUEEN, BLACK)),
                    () -> assertEquals(KING_COUNT, board.getPieceCount(KING, WHITE)),
                    () -> assertEquals(KING_COUNT, board.getPieceCount(KING, BLACK))
            );
        }
    }

    @Nested
    class FindPieceByPoint {
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
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPoint(Point.of(invalidPoint1)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPoint(Point.of(invalidPoint2)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPoint(Point.of(invalidPoint3)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPoint(Point.of(invalidPoint4)));
            assertThrows(IllegalArgumentException.class, () -> board.findPieceByPoint(Point.of(invalidPoint5)));
        }

        @Test
        @DisplayName("기물의 위치를 조회해서 가져온다")
        void findPieceByPoint() {
            // given, when
            board.initialize();

            // then
            assertAll(
                    () -> assertTrue(board.findPieceByPoint(Point.of("a8")).isSameTypeAndColor(ROOK, BLACK)),
                    () -> assertTrue(board.findPieceByPoint(Point.of("e1")).isSameTypeAndColor(KING, WHITE))
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
    void moveInEmptyBoard(){
        // given
        board.initializeEmpty();

        // when
        Piece blackPawn = Piece.createBlackPawn();
        Point point = Point.of("c5");
        board.move(blackPawn, point);

        // then
        assertEquals(blackPawn, board.findPieceByPoint(point));
    }
}