package softeer2nd.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.Color.BLACK;
import static softeer2nd.chess.Color.WHITE;


class PieceTest {
    @Test
    @DisplayName("Piece가 가지는 말의 representation을 출력한다")
    public void getRepresentation() {
        verifyRepresentation(Pawn.from(WHITE), "p");
        verifyRepresentation(Pawn.from(BLACK), "P");

        verifyRepresentation(Knight.from(WHITE), "n");
        verifyRepresentation(Knight.from(BLACK), "N");

        verifyRepresentation(Rook.from(WHITE), "r");
        verifyRepresentation(Rook.from(BLACK), "R");

        verifyRepresentation(Bishop.from(WHITE), "b");
        verifyRepresentation(Bishop.from(BLACK), "B");

        verifyRepresentation(Queen.from(WHITE), "q");
        verifyRepresentation(Queen.from(BLACK), "Q");

        verifyRepresentation(King.from(WHITE), "k");
        verifyRepresentation(King.from(BLACK), "K");
    }

    @Test
    @DisplayName("Piece의 색깔을 검사한다")
    public void verifyColor() {
        Piece white = Pawn.from(WHITE);
        Piece black = Pawn.from(BLACK);

        assertThat(white.isWhite()).isTrue();
        assertThat(black.isBlack()).isTrue();
    }

    private void verifyRepresentation(final Piece piece, final String representation) {
        assertEquals(representation, piece.getRepresentation());
    }

    @Test
    @DisplayName("특정 기물의 타입이 맞는지 확인한다")
    void checkType(){
        // given
        Piece pawn = Pawn.from(BLACK);
        Piece queen = Queen.from(BLACK);

        // when
        boolean pawnType = pawn.isTypeOf(Pawn.class);
        boolean queenType = queen.isTypeOf(Queen.class);
        boolean wrongType = queen.isTypeOf(Pawn.class);

        // then
        assertTrue(pawnType);
        assertTrue(queenType);
        assertFalse(wrongType);
    }
}