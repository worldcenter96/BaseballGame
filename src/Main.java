import BaseballGame.PlayGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayGame baseball = new PlayGame();

        BaseballGame:
        while (true) {
            System.out.println();
            System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
            System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
            System.out.print("선택: ");
            Scanner sc =  new Scanner(System.in);
            int choice = sc.nextInt();
            int level = 3;

            switch (choice) {
                case 0:
                    System.out.println();
                    System.out.print("설정하고자 하는 자리수를 입력하세요: ");
                    level = sc.nextInt();
                    System.out.println(level + "자리수 난이도로 설정되었습니다.");
                    if (level < 3 || level > 5) {
                        System.out.println("지원하지 않는 난이도 입니다.");
                        continue BaseballGame;
                    }

                case 1:
                    System.out.println();
                    System.out.println("< 게임을 시작합니다. >");
                    baseball.play(level);
                    break;

                case 2:
                    System.out.println();
                    System.out.println("< 게임 기록 보기 >");
                    baseball.playChallenge();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    break BaseballGame;

                default:
                    System.out.println("올바른 숫자를 입력해주세요!");
                    break;

            }
        }

    }
}