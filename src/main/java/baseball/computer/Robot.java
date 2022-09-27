package baseball.computer;

import baseball.utils.Message;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Robot implements Computor {
    @Override
    public Integer[] generatorRandomNumber() {
        return generate3RandomNumbers();
    }

    @Override
    public void announceMessage(Message text) {
        System.out.println(text.getMessage());
    }

    private Integer[] generate3RandomNumbers() {
        Integer[] orderedNumbersArr = new Integer[3];
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (true) {
            int random = Randoms.pickNumberInRange(1, 9);
            int beforeSize = uniqueNumbers.size();
            uniqueNumbers.add(random);
            if (!(beforeSize == uniqueNumbers.size())) {
                orderedNumbersArr[beforeSize] = random;
            }
            if ((uniqueNumbers.size() == 3)) {
                return orderedNumbersArr;
            }
        }
    }
}
