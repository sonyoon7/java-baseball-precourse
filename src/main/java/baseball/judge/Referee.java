package baseball.judge;

import baseball.utils.Status;
import java.util.Arrays;

public class Referee implements Judge {

    private final Integer[] randomNum;
    private Integer[] userNum;
    private int strike;
    private int ball;
    private boolean isOut;

    public Referee(Integer[] randomNum) {
        this.randomNum = randomNum;
    }

    @Override
    public void init(Integer[] userNum) {
        this.userNum = userNum;
        this.strike = 0;
        this.ball = 0;
        this.isOut = false;
    }

    @Override
    public String hasDetermine() {
        if (isStrikeOut()) {
            return 3 + "" + Status.STRIKE.getStatus();
        }
        for (int i = 0; i < userNum.length; i++) {
            determine(userNum[i], i);
        }
        if (strike == 0 && ball == 0) {
            return Status.NOTHING.getStatus();
        }
        return getResult();
    }

    private boolean isStrikeOut() {
        if (Arrays.deepEquals(randomNum, userNum)) {
            addStrike(3);
            return true;
        }
        return false;
    }

    private void determine(Integer userNum, int index) {
        if (isStrike(userNum, index)) {
            return;
        }
        if (isBall(userNum)) {
            return;
        }
    }

    private boolean isStrike(Integer number, int index) {
        if (randomNum[index].equals(number)) {
            addStrike(1);
            return true;
        }
        return false;
    }

    private boolean isBall(Integer number) {
        if (Arrays.asList(randomNum).contains(number)) {
            addBall();
            return true;
        }
        return false;
    }

    private void addStrike(int add) {
        this.strike = strike + add;
        if (this.strike == 3) {
            this.isOut = true;
        }
    }

    private void addBall() {
        this.ball = ball + 1;
    }

    private String getResult() {
        String s = toResult(strike, Status.STRIKE.getStatus());
        String b = toResult(ball, Status.BALL.getStatus());
        if ("".equals(s)) {
            return b;
        }
        if ("".equals(b)) {
            return s;
        }
        return s + " " + b;
    }

    private String toResult(int n, String text) {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            return "";
        }
        sb.append(n);
        sb.append(text);
        return sb.toString();
    }
}
