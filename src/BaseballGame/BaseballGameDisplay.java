package BaseballGame;

public class BaseballGameDisplay {
    protected boolean displayHint(int strike, int ball, int out, int level) {

        boolean gameContinue = true;
        if (strike == level) {
            System.out.println("3 스트라이크~~~!");
            gameContinue = false;
            return gameContinue;
        } else {
            System.out.println("Strike: " + strike);
            System.out.println("Ball: " + ball);
            System.out.println("Out: " + out);
            return gameContinue;
        }


    }
}
