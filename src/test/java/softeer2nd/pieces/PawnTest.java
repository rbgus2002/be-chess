package softeer2nd.pieces;

import org.junit.jupiter.api.*;
import softeer2nd.pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;


class PawnTest {
    @Nested
    class create{
        @Test
        @DisplayName("흰색 / 검은색 Pawn을 생성한다")
        public void create() {
            verifyPawn(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
            verifyPawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        }

        private void verifyPawn(final String color, final Character representation){
            Pawn pawn = new Pawn(color, representation);
            assertThat(pawn.getColor()).isEqualTo(color);
            assertThat(pawn.getRepresentation()).isEqualTo(representation);
        }

        @Test
        public void create_기본생성자(){
            Pawn pawn = new Pawn();

            assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
            assertThat(pawn.getRepresentation()).isEqualTo(Pawn.WHITE_REPRESENTATION);
        }
    }
}