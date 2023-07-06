package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.pieces.Piece;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class BoardTest {
    private final int PIECECOUNT = 32;

    @Test
    @DisplayName("체스판이 알맞게 초기화 되었는지 확인한다")
    public void initialize() {
        // given
        Board board = new Board();

        // when
        board.initialize();

        // then
        assertEquals(PIECECOUNT, board.pieceCount());
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