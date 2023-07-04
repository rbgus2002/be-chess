package softeer2nd.pieces;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


class PieceTest {
    @Nested
    class create{
        @Test
        @DisplayName("흰색 / 검은색 Pawn을 생성한다")
        public void create() {
            verifyPawn(Piece.WHITE_COLOR);
            verifyPawn(Piece.BLACK_COLOR);
        }

        private void verifyPawn(final String color){
            Piece piece = Piece.init("pawn", color);
            assertThat(piece.getColor()).isEqualTo(color);
        }
    }
}