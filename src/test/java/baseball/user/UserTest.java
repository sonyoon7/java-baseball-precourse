package baseball.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserTest {

    User user = new User();

    @DisplayName("입력받은 문자 세자리 숫자로 변환")
    @Test
    void  입력문자_숫자변환(){
        Integer[] convertedArr = user.inputTo3differentNumbersArray("123");
        Assertions.assertEquals(convertedArr.length, 3);
        Assertions.assertEquals(convertedArr[0], 1);
        Assertions.assertEquals(convertedArr[1], 2);
        Assertions.assertEquals(convertedArr[2], 3);

    }


}
