package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Color;
import softeer2nd.chess.Position;
import softeer2nd.utils.Board;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;

class QueenTest extends Board {
    @Test
    @DisplayName("퀸은 수평으로 이동이 가능하다")
    void moveHorizontal(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(WHITE);

        // when
        boolean move = queen.canMove(D1, G1, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 수직으로 이동이 가능하다")
    void moveVertical(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(WHITE);

        // when
        boolean move = queen.canMove(D1, D5, board);

        // then
        assertTrue(move);
    }

    @Test
    @DisplayName("퀸은 대각선으로 이동이 가능하다")
    void moveDiagonal(){
        // given
        board.initializeEmpty();
        Piece queen = Queen.from(WHITE);

        // when
        boolean move = queen.canMove(D1, H5, board);

        // then
        assertTrue(move);
    }


    @Nested
    class moveQueen{
        @Test
        @DisplayName("퀸은 상하좌우으로 이동할 수 있다")
        void moveQueenTo상하좌우(){
            // given
            board.initializeEmpty();
            board.insertPiece(D1, Queen.from(WHITE));

            // when
            board.move(D1, D5);

            // then
            assertEquals(Queen.from(WHITE), board.findPieceByPosition(D5));
        }

        @Test
        @DisplayName("퀸은 대각선으로 이동할 수 있다")
        void moveQueenToDiagonal(){
            // given
            board.initializeEmpty();
            board.insertPiece(D1, Queen.from(WHITE));

            // when
            board.move(D1, G4);

            // then
            assertEquals(Queen.from(WHITE), board.findPieceByPosition(G4));
        }
    }
}