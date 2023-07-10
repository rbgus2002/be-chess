package softeer2nd.pieces;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.Board;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.Color.*;

class KingTest {
    private Board board;
    @BeforeEach
    void initBoard(){
        board = new Board();
    }

    @Test
    @DisplayName("King을 생성한다")
    void createKing(){
        // given, when
        Piece whiteKing = King.from(WHITE);
        Piece blackKing = King.from(BLACK);

        // then
        assertEquals("K", blackKing.toString());
        assertEquals("k", whiteKing.toString());
    }

    @Test
    @DisplayName("King이 체스판 내에서 이동한다")
    void moveKing(){
        // given
        
        // when
        
        // then
        
    }
}