package softeer2nd.pieces;

import org.junit.jupiter.api.*;
import softeer2nd.domain.chess.Board;
import softeer2nd.domain.pieces.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.domain.chess.Color.BLACK;
import static softeer2nd.domain.chess.Color.WHITE;
import static softeer2nd.utils.PositionFactory.*;


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
    
    @Test
    @DisplayName("나이트인지 검사한다")
    void isKnight(){
        // given, when
        Piece knight = Knight.from(WHITE);
        Piece king = King.from(WHITE);

        // then
        assertTrue(knight.isKnight());
        assertFalse(king.isKnight());
    }

    @Test
    @DisplayName("킹인지 검사한다")
    void isKing(){
        // given, when
        Piece king = King.from(WHITE);

        // then
        assertTrue(king.isKing());
    }

    @Test
    @DisplayName("빈칸인지 확인한다")
    void isBlank(){
        // given
        Board board = new Board();
        board.initialize();

        // when
        Piece a1 = board.findPieceByPosition(A1);
        Piece c3 = board.findPieceByPosition(C3);

        // then
        assertFalse(a1.isBlank());
        assertTrue(c3.isBlank());
    }

    @Test
    @DisplayName("같은 색인지 검사한다.")
    void isSameColor(){
        // given, when
        Piece whitePawn = Pawn.from(WHITE);
        Piece whiteQueen = Queen.from(WHITE);

        // then
        assertTrue(whitePawn.isSameColor(whiteQueen));
    }
}