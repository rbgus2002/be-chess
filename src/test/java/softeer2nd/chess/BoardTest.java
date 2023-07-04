package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.Pawn;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    Pawn white;
    Pawn black;

    @BeforeEach
    public void init() {
        board = new Board();

        white = new Pawn(Pawn.WHITE_COLOR);
        black = new Pawn(Pawn.BLACK_COLOR);
    }

    @Nested
    class create {
        @Test
        @DisplayName("체스판에 Pawn을 추가한다")
        public void create() {
            board.add(white);
            assertEquals(1, board.size());
            assertEquals(white, board.findPawn(0));

            board.add(black);
            assertEquals(2, board.size());
            assertEquals(black, board.findPawn(1));
        }

        @Test
        @DisplayName("체스판에 Pawn 이외에 객체를 추가하면 실패한다")
        public void create_NotPawn() {
//            board.add(new Integer("7")); // 컴파일 에러
        }
    }
}