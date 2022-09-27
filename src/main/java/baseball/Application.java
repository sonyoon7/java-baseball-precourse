package baseball;

import baseball.game.BaseballGame;
import baseball.utils.Message;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballGame baseballGame = new BaseballGame();
        while (true) {
            baseballGame.play();
            if (!baseballGame.isNewGame()) {
                System.out.println(Message.STOP.getMessage());
                break;
            }
        }
    }
}
