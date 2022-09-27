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

        while (!(uniqueNumbers.size() == 3)) {

            int random = Randoms.pickNumberInRange(1, 9);
            int beforeSize = uniqueNumbers.size();

            uniqueNumbers.add(random);

            int afterSize = uniqueNumbers.size();

            boolean isDuplicated = beforeSize == afterSize;

            if (!isDuplicated) orderedNumbersArr[beforeSize] = random;
            if ((uniqueNumbers.size() == 3)) break;

        }
        return orderedNumbersArr;
    }
}
