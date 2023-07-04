package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    @DisplayName("start를 입력하면 체스 게임을 시작하고 현재 상태를 콘솔 화면에 출력한다. end를 입력하면 종료한다.")
    public void run(){
        Game game = new Game();

        game.run();
    }
}