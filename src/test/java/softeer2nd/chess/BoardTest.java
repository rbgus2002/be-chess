package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.pieces.Piece.Color.*;
import static softeer2nd.pieces.Piece.Type.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    private final int PIECE_COUNT = 32;

    @Test
    @DisplayName("체스판이 알맞게 초기화 되었는지 확인한다")
    public void initialize() {
        // given
        Board board = new Board();

        // when
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
            // given
            Board board = new Board();

            // when
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
            Board board = new Board();

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
}