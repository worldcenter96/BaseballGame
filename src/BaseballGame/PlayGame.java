package BaseballGame;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {

    private AnswerList answerList = new AnswerList();
    private InputList inputList = new InputList();
    private BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();
    private ArrayList<Integer> gamePlay = new ArrayList();
    private int level;

    public void play(int level) {
        this.level = level;
        answerList.createList(level);
        answerList.printNumList(); // 답지 출력
        int challenge = 0; // 게임 시도 횟수 초기화
        Game:
        while (true) {
            System.out.print(level + "자리 숫자를 입력해주세요(1~9): ");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            inputList.setInputNumList(input);

            // 입력 값 예외 처리
            boolean duplicate = hasDuplicate();
            boolean valid = isValid(input);
            boolean numDigit = validNum(input);
            if (duplicate || valid || numDigit) {
                continue Game;
            }


            // 게임 진행횟수 증가
            challenge++;

            // 스트라이크, 볼, 아웃 개수 계산
            int strike = 0;
            int ball = 0;
            int out = 0;

            for (int i = 0; i < inputList.size(); i++) {
                if (answerList.getAnswerNumList(i) == inputList.getInputNumList(i)) {
                    strike++;
                } else if (answerList.containAnswerNumList(inputList.getInputNumList(i))) {
                    ball++;
                } else {
                    out++;
                }
            }

            // 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            boolean gameContinue = baseballGameDisplay.displayHint(strike, ball, out, level);
            if (!gameContinue) {
                gamePlay.add(challenge);
                break Game;
            }
        }

    }

    public void playChallenge() {
        for (int i = 1; i <= gamePlay.size(); i++) {
            System.out.println(i + "번째 게임 : 시도 횟수 - " + gamePlay.get(i-1));
        }
    }

    // 예외처리
    private boolean hasDuplicate() {
        boolean duplicate = false;
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i + 1; j < inputList.size(); j++) {
                if (inputList.getInputNumList(i) == inputList.getInputNumList(j)) {
                    duplicate = true;
                    break;
                }

            }
            if (duplicate) {
                break;
            }
        }

        if (duplicate) {
            System.out.println("중복되는 값이 있습니다.");
        }

        return duplicate;
    }

    private boolean isValid(String input) {
        boolean valid = false;
        for (char ch : input.toCharArray()) {
            if (ch >= '1' && ch <= '9') {
                valid = true;
            } else {
                valid = false;
                break;
            }
        }
        if (!valid) {
            System.out.println("유효하지 않은 입력 값이 있습니다.");

        }
        return !valid;

    }

    private boolean validNum(String input) {
        boolean numDigit = true;
        if (input.length() != level) {
            System.out.println(level + "자리 숫자를 입력해주세요");
            numDigit = false;
        }
        return !numDigit;
    }
}
