package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Color;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;

class KnightTest extends Board {
    @Test
    @DisplayName("나이트는 수평, 수직으로 이동할 수 없다")
    void knightCanNotMoveHorizontalAndVertical(){
        // given
        board.initializeEmpty();
        board.insertPiece(D4, Knight.from(WHITE));
        
        // when
        boolean moveHorizontal = Knight.from(WHITE).canMove(D4, F4, board);
        boolean moveVertical = Knight.from(WHITE).canMove(D4, D7, board);

        // then
        assertFalse(moveHorizontal);
        assertFalse(moveVertical);
    }

    @Test
    @DisplayName("나이트는 해밍 거리가 3인 위치만 이동할 수 있다")
    void knightCanMoveHammingDistanceEqualToThree(){
        // given
        board.initializeEmpty();
        board.insertPiece(D4, Knight.from(WHITE));

        // when
        boolean move1 = Knight.from(WHITE).canMove(D4, E6, board);
        boolean move2 = Knight.from(WHITE).canMove(D4, F5, board);
        boolean move3 = Knight.from(WHITE).canMove(D4, F3, board);
        boolean move4 = Knight.from(WHITE).canMove(D4, E2, board);
        boolean move5 = Knight.from(WHITE).canMove(D4, C2, board);
        boolean move6 = Knight.from(WHITE).canMove(D4, B3, board);
        boolean move7 = Knight.from(WHITE).canMove(D4, B5, board);
        boolean move8 = Knight.from(WHITE).canMove(D4, C6, board);

        // then
        assertTrue(move1);
        assertTrue(move2);
        assertTrue(move3);
        assertTrue(move4);
        assertTrue(move5);
        assertTrue(move6);
        assertTrue(move7);
        assertTrue(move8);
    }
    
    @Test
    @DisplayName("나이트는 기물을 건너뛸 수 있다")
    void knightCanJump(){
        // given
        board.initializeEmpty();
        board.insertPiece(D4, Knight.from(WHITE));
        board.insertPiece(E5, Pawn.from(WHITE));

        // when
        boolean move1 = Knight.from(WHITE).canMove(D4, E6, board);
        boolean move2 = Knight.from(WHITE).canMove(D4, F5, board);

        // then
        assertTrue(move1);
        assertTrue(move2);
    }
}