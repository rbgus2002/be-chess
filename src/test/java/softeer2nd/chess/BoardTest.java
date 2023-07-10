package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.*;
import softeer2nd.utils.PositionFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.BLACK;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;
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
        Position position = C5;
        board.insertPiece(position, blackPawn);

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
            board.insertPiece(B6, Pawn.from(BLACK));
            board.insertPiece(E6, Queen.from(BLACK));
            board.insertPiece(B8, King.from(BLACK));
            board.insertPiece(C8, Rook.from(BLACK));
            board.insertPiece(F2, Pawn.from(WHITE));
            board.insertPiece(G2, Pawn.from(WHITE));
            board.insertPiece(E1, Rook.from(WHITE));
            board.insertPiece(F1, King.from(WHITE));

            // then
            assertEquals(15.0, board.getScoreOfColor(BLACK), 0.01);
            assertEquals(7.0, board.getScoreOfColor(WHITE), 0.01);
            System.out.println(board.showBoard());
        }

        @Test
        @DisplayName("같은 파일에 같은색 Pawn이 있는 경우 0.5점을 뺀다")
        void calculatePawnScore() {
            // given
            board.initializeEmpty();

            // when
            board.insertPiece(F2, Pawn.from(BLACK));
            board.insertPiece(F3, Pawn.from(BLACK));
            board.insertPiece(F4, Pawn.from(BLACK));

            // then
            assertEquals(1.5, board.getScoreOfColor(BLACK), 0.01);
            System.out.println(board.showBoard());
        }
    }

    @Test
    @DisplayName("현재 체스판에서 특정 색깔의 기물의 점수를 오름차순으로 정렬한다")
    void getPieceListOrderByScoreDesc(){
        // given
        board.initializeEmpty();

        board.insertPiece(B1, Pawn.from(WHITE));
        board.insertPiece(C1, Rook.from(WHITE));
        board.insertPiece(D1, King.from(WHITE));

        // when
        List<Piece> pieceList = board.getPieceListOrderByScoreDesc(WHITE);

        // then
        assertEquals(3, pieceList.size());
        assertThat(pieceList.get(0).getScore()).isGreaterThan(pieceList.get(1).getScore());
    }
}