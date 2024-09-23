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
            boolean valid = isValid(input);
            if (!valid) {
                System.out.println("유효하지 않은 값을 입력하였습니다.");
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
    private boolean isValid(String input) {
        // 중복 체크
        for (int i = 0; i < inputList.size(); i++) {
            for (int j = i + 1; j < inputList.size(); j++) {
                if (inputList.getInputNumList(i) == inputList.getInputNumList(j)) {
                    return false;
                }

            }

        }

        // 입력 숫자의 유효성 체크
        for (char ch : input.toCharArray()) {
            if (ch < '1' || ch > '9') {
                return false;
            }

        }

        // 자리 수 체크
        if (input.length() != level) {
            return false;
        }
        return true;
    }

}
