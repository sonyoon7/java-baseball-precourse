package baseball.game;

import baseball.computer.Robot;
import baseball.judge.Referee;
import baseball.user.User;
import baseball.utils.Message;
import java.util.Arrays;

public class BaseballGame implements Game{

    static final String[] NEW_GAME_ANSWERS = new String[]{"1", "2"};
    private Robot robot;
    private User user;
    private Referee referee;

    @Override
    public void setInit() {
        this.robot = new Robot();
        this.user = new User();
        this.referee = new Referee(robot.generatorRandomNumber());
    }

    @Override
    public void play() {
        setInit();
        while (true) {
            if (keepGoing()) {
                robot.announceMessage(Message.COMPLETE);
                break;
            }
        }
    }

    private boolean keepGoing() {
            robot.announceMessage(Message.INPUT);
            String input = user.readInput();
            Integer[] userIntegerArray = user.inputTo3differentNumbersArray(input);
            referee.init(userIntegerArray);
            String r = referee.hasDetermine();
            System.out.println(r);
            return referee.getIsOut();
    }

    @Override
    public boolean isNewGame() {
        String decisionForReplay;
        while (true) {
            robot.announceMessage(Message.END);
            decisionForReplay = user.readInput();
            if (validAskNewGameInput(decisionForReplay)) break;
            robot.announceMessage(Message.END_ERROR);
        }
        return "1".equals(decisionForReplay);
    }

    private boolean validAskNewGameInput(String input) {

        if (input.length() > 1) return false;

        return Arrays.asList(NEW_GAME_ANSWERS).contains(input);
    }

}
