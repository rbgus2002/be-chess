package softeer2nd.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.pieces.Piece.*;


class PieceTest {
    @Test
    @DisplayName("Piece를 생성한다")
    public void createPawn() {
        verifyPiece(createWhitePawn(), createBlackPawn(), Type.PAWN);
        verifyPiece(createWhiteKnight(), createBlackKnight(), Type.KNIGHT);
        verifyPiece(createWhiteRook(), createBlackRook(), Type.ROOK);
        verifyPiece(createWhiteBishop(), createBlackBishop(), Type.BISHOP);
        verifyPiece(createWhiteQueen(), createBlackQueen(), Type.QUEEN);
        verifyPiece(createWhiteKing(), createBlackKing(), Type.KING);

        // check blank
        Piece blank = Piece.createBlank();
        assertFalse(blank.isBlack());
        assertFalse(blank.isWhite());
        assertEquals(Type.NO_PIECE, blank.getType());
    }

    @Test
    @DisplayName("Piece가 가지는 말의 representation을 출력한다")
    public void getRepresentation() {
        verifyRepresentation(createWhitePawn(), 'p');
        verifyRepresentation(createBlackPawn(), 'P');

        verifyRepresentation(createWhiteKnight(), 'n');
        verifyRepresentation(createBlackKnight(), 'N');

        verifyRepresentation(createWhiteRook(), 'r');
        verifyRepresentation(createBlackRook(), 'R');

        verifyRepresentation(createWhiteBishop(), 'b');
        verifyRepresentation(createBlackBishop(), 'B');

        verifyRepresentation(createWhiteQueen(), 'q');
        verifyRepresentation(createBlackQueen(), 'Q');

        verifyRepresentation(createWhiteKing(), 'k');
        verifyRepresentation(createBlackKing(), 'K');
    }

    @Test
    @DisplayName("Piece의 색깔을 검사한다")
    public void verifyColor() {
        Piece white = createWhitePawn();
        Piece black = createBlackPawn();

        assertThat(white.isWhite()).isTrue();
        assertThat(black.isBlack()).isTrue();
    }


    private void verifyPiece(final Piece white, final Piece black, Type type) {
        assertTrue(white.isWhite());
        assertEquals(type, white.getType());

        assertTrue(black.isBlack());
        assertEquals(type, black.getType());
    }

    private void verifyRepresentation(final Piece piece, final Character representation) {
        assertEquals(representation, piece.getRepresentation());
    }
}