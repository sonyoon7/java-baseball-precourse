package baseball.game;

import baseball.computer.Robot;
import baseball.judge.Referee;
import baseball.user.User;
import baseball.utils.Message;

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

    @Override
    public boolean isNewGame() {
        return false;
    }

    private boolean keepGoing() {
        try {
            robot.announceMessage(Message.INPUT);
            String input = user.readInput();
            Integer[] userIntegerArray = user.inputTo3differentNumbersArray(input);
            referee.init(userIntegerArray);
            String r = referee.hasDetermine();
            System.out.println(r);
            return referee.getIsOut();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return keepGoing();
        }
    }
}
