package softeer2nd.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PieceTest {
    @Nested
    class create{
        @Test
        @DisplayName("Piece를 생성한다")
        public void createPawn(){
            verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.PAWN);
            verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.PAWN);

            verifyPiece(Piece.createWhiteKnight(), Piece.WHITE_COLOR, Piece.KNIGHT);
            verifyPiece(Piece.createBlackKnight(), Piece.BLACK_COLOR, Piece.KNIGHT);

            verifyPiece(Piece.createWhiteRook(), Piece.WHITE_COLOR, Piece.ROOK);
            verifyPiece(Piece.createBlackRook(), Piece.BLACK_COLOR, Piece.ROOK);

            verifyPiece(Piece.createWhiteBishop(), Piece.WHITE_COLOR, Piece.BISHOP);
            verifyPiece(Piece.createBlackBishop(), Piece.BLACK_COLOR, Piece.BISHOP);

            verifyPiece(Piece.createWhiteQueen(), Piece.WHITE_COLOR, Piece.QUEEN);
            verifyPiece(Piece.createBlackQueen(), Piece.BLACK_COLOR, Piece.QUEEN);

            verifyPiece(Piece.createWhiteKing(), Piece.WHITE_COLOR, Piece.KING);
            verifyPiece(Piece.createBlackKing(), Piece.BLACK_COLOR, Piece.KING);
        }
    }

    @Test
    @DisplayName("Piece가 가지는 말의 representation을 출력한다")
    public void getRepresentation(){
        verifyRepresentation(Piece.createWhitePawn(), 'p');
        verifyRepresentation(Piece.createBlackPawn(), 'P');

        verifyRepresentation(Piece.createWhiteKnight(), 'n');
        verifyRepresentation(Piece.createBlackKnight(), 'N');

        verifyRepresentation(Piece.createWhiteRook(), 'r');
        verifyRepresentation(Piece.createBlackRook(), 'R');

        verifyRepresentation(Piece.createWhiteBishop(), 'b');
        verifyRepresentation(Piece.createBlackBishop(), 'B');

        verifyRepresentation(Piece.createWhiteQueen(), 'q');
        verifyRepresentation(Piece.createBlackQueen(), 'Q');

        verifyRepresentation(Piece.createWhiteKing(), 'k');
        verifyRepresentation(Piece.createBlackKing(), 'K');
    }

    @Test
    @DisplayName("Piece의 색깔을 검사한다")
    public void verifyColor(){
        Piece white = Piece.createWhitePawn();
        Piece black = Piece.createBlackPawn();

        assertThat(white.isWhite()).isTrue();
        assertThat(black.isBlack()).isTrue();
    }


    private void verifyPiece(final Piece piece, final String color, final String name){
        assertEquals(color, piece.getColor());
        assertEquals(name, piece.getName());
    }

    private void verifyRepresentation(final Piece piece, final Character representation){
        assertEquals(representation, piece.getRepresentation());
    }
}