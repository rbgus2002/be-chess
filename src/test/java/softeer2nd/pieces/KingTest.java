package softeer2nd.pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static softeer2nd.chess.Color.*;

class KingTest {
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
}