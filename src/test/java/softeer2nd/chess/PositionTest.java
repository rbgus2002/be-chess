package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    @DisplayName("두 좌표가 같은 파일에 있으면 수직이다")
    void isVertical(){
        // given, when
        Position verticalP1 = Position.of("c1");
        Position verticalP2 = Position.of("c2");

        Position wrongP1 = Position.of("b1");
        Position wrongP2 = Position.of("c1");

        // then
        assertTrue(verticalP1.isVertical(verticalP2));
        assertFalse(wrongP1.isVertical(wrongP2));
    }

    @Test
    @DisplayName("두 좌표가 같은 랭크에 있으면 수평이다")
    void isHorizontal(){
        // given, when
        Position horizontalP1 = Position.of("c1");
        Position horizontalP2 = Position.of("d1");

        Position wrongP1 = Position.of("b1");
        Position wrongP2 = Position.of("b2");

        // then
        assertTrue(horizontalP1.isHorizontal(horizontalP2));
        assertFalse(wrongP1.isHorizontal(wrongP2));
    }

    @Test
    @DisplayName("두 좌표가 대각선인지 검사한다")
    void isDiagonal(){
        // given, when
        Position p1 = Position.of("c1");
        Position p2 = Position.of("e3");

        Position p3 = Position.of("c1");
        Position p4 = Position.of("e2");

        // then
        assertTrue(p1.isDiagonal(p2));
        assertFalse(p3.isDiagonal(p4));
    }

    @Test
    @DisplayName("두 좌표 사이의 파일 차이를 계산한다")
    void getFileDistance(){
        // given
        Position p1 = Position.of("c1");
        Position p2 = Position.of("c5");

        // when
        int fileDistance1 = p1.getFileDistance(p2);

        // then
        assertEquals(fileDistance1, 4);
    }

    @Test
    @DisplayName("두 좌표 사이의 랭크 차이를 계산한다")
    void getRankDistance(){
        // given
        Position p1 = Position.of("c1");
        Position p2 = Position.of("e1");

        // when
        int fileDistance = p1.getRankDistance(p2);

        // then
        assertEquals(fileDistance, 2);
    }

    @Test
    @DisplayName("toString 메소드를 오버라이딩 해서 객체로써 좌표를 출력한다")
    void printInstance(){
        // given, when
        Position position = Position.of("a5");

        // then
        assertEquals("a5", position.toString());
    }
}