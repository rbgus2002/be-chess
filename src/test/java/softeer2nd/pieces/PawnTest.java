package softeer2nd.pieces;

import org.junit.jupiter.api.*;
import softeer2nd.pieces.Pawn;

import static org.assertj.core.api.Assertions.assertThat;


class PawnTest {
    @Nested
    class create{
        @Test
        @DisplayName("흰색 폰이 생성되어야 한다")
        public void create() {
            verifyPawn(Pawn.WHITE_COLOR);
            verifyPawn(Pawn.BLACK_COLOR);
        }

        private void verifyPawn(final String color){
            Pawn pawn = new Pawn(color);
            assertThat(pawn.getColor()).isEqualTo(color);
        }

        @Test
        public void create_기본생성자(){
            Pawn pawn = new Pawn();
            assertThat(pawn.getColor()).isEqualTo(Pawn.WHITE_COLOR);
        }
    }
}