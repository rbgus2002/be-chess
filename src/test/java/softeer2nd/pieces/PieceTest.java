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
        }

        private void verifyPiece(final Piece piece, final String color, final String name){
            assertEquals(color, piece.getColor());
            assertEquals(name, piece.getName());
        }
    }
}