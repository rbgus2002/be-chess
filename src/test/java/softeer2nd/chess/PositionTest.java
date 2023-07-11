package softeer2nd.chess;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.utils.PositionFactory.*;

class PositionTest {
    @Test
    @DisplayName("두 좌표가 같은 파일에 있으면 수직이다")
    void isVertical(){
        assertTrue(C1.isVertical(C2));

        assertFalse(B1.isVertical(C1));
    }

    @Test
    @DisplayName("두 좌표가 같은 랭크에 있으면 수평이다")
    void isHorizontal(){
        assertTrue(C1.isHorizontal(D1));

        assertFalse(B1.isHorizontal(B2));
    }

    @Test
    @DisplayName("두 좌표가 대각선인지 검사한다")
    void isDiagonal(){
        assertTrue(C1.isDiagonal(E3));

        assertFalse(C1.isDiagonal(E2));
    }

    @Test
    @DisplayName("두 좌표 사이의 파일 차이를 계산한다")
    void getFileDistance(){
        // given, when
        int fileDistance1 = Math.abs(C1.getFileDistance(C5));

        // then
        assertEquals(fileDistance1, 4);
    }

    @Test
    @DisplayName("두 좌표 사이의 랭크 차이를 계산한다")
    void getRankDistance(){
        // given, when
        int fileDistance = Math.abs(C1.getRankDistance(E1));

        // then
        assertEquals(fileDistance, 2);
    }

    @Test
    @DisplayName("toString 메소드를 오버라이딩 해서 객체로써 좌표를 출력한다")
    void printInstance(){
        assertEquals("a5", A5.toString());
    }

    @Test
    @DisplayName("가로 혹은 세로 중 큰 변의 값을 가져온다")
    void getMaxSide(){
        // given, when
        int maxSide = A1.getMaxSide(C2);

        // then
        assertEquals(2, maxSide);
    }

    @Nested
    class GetNextIndexToDiagonal{
        @Test
        @DisplayName("source가 나아가야 할 방향을 target으로 정한다 (A1 to C3 : 2시 방향 대각선)")
        void getNextIndexToDiagonal_2시방향(){
            // given, when
            int nextRank = A1.getNextRank(C3);
            int nextFile = A1.getNextFile(C3);

            // then
            assertEquals(1, nextRank);
            assertEquals(1, nextFile);
        }

        @Test
        @DisplayName("source가 나아가야 할 방향을 target으로 정한다 (C3 to A1 : 7시 방향 대각선)")
        void getNextIndexToDiagonal_7시방향(){
            // given, when
            int nextRank = C3.getNextRank(A1);
            int nextFile = C3.getNextFile(A1);

            // then
            assertEquals(-1, nextRank);
            assertEquals(-1, nextFile);
        }
    }
}