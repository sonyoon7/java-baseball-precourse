package baseball.user;

import baseball.utils.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Player {

    @Override
    public String readInput() {
        return Console.readLine();
    }

    @Override
    public Integer[] inputTo3differentNumbersArray(String input) throws IllegalArgumentException {
        return getInputNumbersToArray(input);
    }

    private Integer[] getInputNumbersToArray(String input) throws IllegalArgumentException {
        Set<Integer> uniqueNumbers = new HashSet<>();

        if (!isValidate(input)) {
            throw new IllegalArgumentException(Message.INPUT_ERROR.getMessage());
        }

        Integer[] splittedInputNumbers = splitToNumberArr(input);

        if (hasDuplicatedNumber(uniqueNumbers, splittedInputNumbers)) {
            throw new IllegalArgumentException(Message.INPUT_ERROR.getMessage());
        }

        return splittedInputNumbers;
    }

    private boolean isValidate(String input) {
        return findMatches(Pattern.compile("^\\d{3}$"), input);
    }

    private boolean findMatches(Pattern pattern, CharSequence input) {
        Matcher m = pattern.matcher(input);
        return m.find();
    }

    private Integer[] splitToNumberArr(String input) {
        Integer[] orderedNumbersArr = new Integer[3];
        String[] s = input.split("");
        for (int i = 0; i < input.length(); i++) {
            orderedNumbersArr[i] = Integer.parseInt(s[i]);
        }
        return orderedNumbersArr;
    }

    private boolean hasDuplicatedNumber(Set<Integer> uniqueNumbers, Integer[] inputNumbers) {
        Collections.addAll(uniqueNumbers, inputNumbers);
        return !(uniqueNumbers.size() == 3);
    }

}
