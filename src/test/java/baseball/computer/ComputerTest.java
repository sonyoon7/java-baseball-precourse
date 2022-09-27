package baseball.computer;

import baseball.utils.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ComputerTest {

    Robot robot = new Robot();

    @DisplayName("게임안내 메세지 문구 테스트")
    @Test
    void  야구봇_게임안내(){
        Assertions.assertEquals(Message.INPUT.getMessage(), "숫자를 입력해 주세요 : ");
    }

    @DisplayName("랜덤숫자 3개 받기")
    @Test
    void  랜덤숫자_받기(){
        Assertions.assertEquals(robot.generatorRandomNumber().length, 3);
        Assertions.assertNotEquals(robot.generatorRandomNumber()[0], robot.generatorRandomNumber()[1]);
        Assertions.assertNotEquals(robot.generatorRandomNumber()[1], robot.generatorRandomNumber()[2]);
    }


}
