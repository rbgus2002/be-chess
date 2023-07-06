package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.Piece;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
                    () -> assertTrue(board.findPieceByPosition(Position.of("a8")).isSameTypeAndColor(ROOK, BLACK)),
                    () -> assertTrue(board.findPieceByPosition(Position.of("e1")).isSameTypeAndColor(KING, WHITE))
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
        Piece blackPawn = Piece.createBlackPawn();
        Position position = Position.of("c5");
        board.board(position, blackPawn);

        // then
        assertEquals(blackPawn, board.findPieceByPosition(position));
    }

    @Nested
    class CalculateScore {
        @Test
        @DisplayName("색깔별로 체스판의 점수를 계산한다")
        void calculateScore() {
            // given
            board.initializeEmpty();

            // when
            board.board(Position.of("b6"), Piece.createBlackPawn());
            board.board(Position.of("e6"), Piece.createBlackQueen());
            board.board(Position.of("b8"), Piece.createBlackKing());
            board.board(Position.of("c8"), Piece.createBlackRook());

            board.board(Position.of("f2"), Piece.createWhitePawn());
            board.board(Position.of("g2"), Piece.createWhitePawn());
            board.board(Position.of("e1"), Piece.createWhiteRook());
            board.board(Position.of("f1"), Piece.createWhiteKing());

            // then
            assertEquals(15.0, board.calculateScore(Piece.Color.BLACK), 0.01);
            assertEquals(7.0, board.calculateScore(Piece.Color.WHITE), 0.01);
            System.out.println(board.showBoard());
        }

        @Test
        @DisplayName("같은 파일에 같은색 Pawn이 있는 경우 0.5점을 뺀다")
        void calculatePawnScore() {
            // given
            board.initializeEmpty();

            // when
            board.board(Position.of("f2"), Piece.createBlackPawn());
            board.board(Position.of("f3"), Piece.createBlackPawn());
            board.board(Position.of("f4"), Piece.createBlackPawn());

            // then
            assertEquals(1.5, board.calculateScore(Piece.Color.BLACK), 0.01);
            System.out.println(board.showBoard());
        }
    }
    
    @Test
    @DisplayName("현재 체스판에서 특정 색깔의 기물의 점수를 오름차순으로 정렬한다")
    void getPieceListOrderByScoreDesc(){
        // given
        board.initializeEmpty();

        board.board(Position.of("b1"), Piece.createWhitePawn());
        board.board(Position.of("c1"), Piece.createWhiteRook());
        board.board(Position.of("d1"), Piece.createWhiteKing());

        // when
        List<Piece> pieceList = board.getPieceListOrderByScoreDesc(WHITE);

        // then
        assertEquals(3, pieceList.size());
        assertThat(pieceList.get(0).getType().getScore()).isGreaterThan(pieceList.get(1).getType().getScore());
        System.out.println(pieceList);
    }
}