package baseball.judge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class JudgeTest {

    private Referee referee;

    @DisplayName("3스트라이크")
    @Test
    void  THREE_스트라이크(){
        Integer[] botRandom =  {1 ,2, 3};
        Integer[] userInput =  {1 ,2, 3};
        referee = new Referee(botRandom);
        referee.init(userInput);
        String r = referee.hasDetermine();;
        Assertions.assertEquals(r, "3스트라이크");
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    void  TWO_BALL_ONE_스트라이크(){
        Integer[] botRandom =  {1 ,3, 2};
        Integer[] userInput =  {1 ,2, 3};
        referee = new Referee(botRandom);
        referee.init(userInput);
        String r = referee.hasDetermine();;
        Assertions.assertEquals(r, "2볼 1스트라이크");
    }

    @DisplayName("낫싱")
    @Test
    void  낫싱(){
        Integer[] botRandom =  {7 ,8, 9};
        Integer[] userInput =  {1 ,2, 3};
        referee = new Referee(botRandom);
        referee.init(userInput);
        String r = referee.hasDetermine();;
        Assertions.assertEquals(r, "낫싱");
    }


}
