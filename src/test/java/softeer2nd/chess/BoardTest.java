package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    Board board;
    Piece white;
    Piece black;

    @BeforeEach
    public void init() {
        board = new Board();

        white = Piece.createWhitePawn();
        black = Piece.createBlackPawn();
    }

    @Nested
    class create {
//        @Test
//        @DisplayName("체스판에 Pawn을 추가한다")
//        public void create() {
//            board.initialize();
//
//            board.add(white);
//            assertEquals(1, board.size());
//            assertEquals(white, board.findPawn(0));
//
//            board.add(black);
//            assertEquals(2, board.size());
//            assertEquals(black, board.findPawn(1));
//        }

        @Test
        @DisplayName("체스판에 Pawn 이외에 객체를 추가하면 실패한다")
        public void create_NotPawn() {
//            board.add(new Integer("7")); // 컴파일 에러
        }
    }

    @Test
    @DisplayName("체스판 초기화 후 Pawn이 잘 들어갔는지 확인한다")
    public void initialize() {
        board.initialize();

        assertAll(
                () -> assertEquals("pppppppp", board.getWhitePawnsResults()),
                () -> assertEquals("PPPPPPPP", board.getBlackPawnsResults())
        );
    }

    @Test
    @DisplayName("보드를 출력한다")
    public void print() {
        board.initialize();

        System.out.println(board.showBoard());

        assertEquals(32, board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"),
                board.showBoard());
    }

}