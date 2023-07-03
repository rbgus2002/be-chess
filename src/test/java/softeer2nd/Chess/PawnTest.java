package softeer2nd.Chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


class PawnTest {
    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        // given, when
        final String WHITE = "white";
        final String BLACK = "black";

        // then
        verifyPawn(WHITE);
        verifyPawn(BLACK);
    }

    private void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }
}