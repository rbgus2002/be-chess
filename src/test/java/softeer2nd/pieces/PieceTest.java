package softeer2nd.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PieceTest {
    @Nested
    class create{
        @Test
        @DisplayName("pawn을 생성한다")
        public void createPawn(){
            verifyPiece(Piece.createWhitePawn(), Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
            verifyPiece(Piece.createBlackPawn(), Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
        }

        private void verifyPiece(final Piece piece, final String color, final Character representation){
            assertEquals(color, piece.getColor());
            assertEquals(representation, piece.getRepresentation());
        }
    }
}