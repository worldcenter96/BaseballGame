# 숫자 야구 게임 프로젝트

## 프로젝트 소개
- 사용자가 숫자를 입력하면, 컴퓨터가 생성한 랜덤한 숫자와 비교하여 결과를 출력하는 게임입니다.
- 사용자는 1부터 9까지 서로 다른 숫자로 이루어진 3자리의 숫자를 입력해야 합니다.
- 사용자가 입력한 숫자와 컴퓨터가 생성한 숫자를 비교하여, 숫자가 동일하고 위치도 동일하면 스트라이크, 숫자는 동일하지만 위치가 다르면 볼, 둘 다 동일하지 않으면 아웃이 됩니다.
- Level 설정을 통해 게임의 난이도를 조절할 수 있습니다.

## 요구사항 정의서
| 요구사항 No | 요구사항 명            | 상세 요구사항 정의                                               | 비고       |
|-------------|------------------------|------------------------------------------------------------------|------------|
| **RF 1.0**  | RF 1.0                 | 3자리 숫자 생성. 1~9 사이의 숫자를 중복 없이 뽑아내야 합니다.  | ArrayList  |
|             | RF 1.1                 | 플레이어의 숫자를 입력 받아 리스트에 넣어야 합니다.            | ArrayList  |
|             | RF 1.2                 | Strike, Ball, Out 힌트 보여주기, 3 스트라이크 판단            |            |
|             | RF 1.3                 | 베이스볼 게임 시작                                             |            |
|             | RF 1.4                 | 게임 기록 보기                                                 | ArrayList  |
|             | RF 1.5                 | 자릿 수(레벨) 설정하기                                         |            |
|             | RF 1.6                 | 게임 종료 하기                                                 |            |


## 애플리케이션 아키텍처
| 클래스명                | 속성                                       | 메서드                                             |
|---------------------|----------------------------------------|--------------------------------------------------|
| **Main**            | + baseball: PlayGame                  |                                                  |
|                     | + choice: int                         |                                                  |
|                     | + level: int                          |                                                  |
| **PlayGame**        | + answerList: AnswerList              | + play(int level): void                          |
|                     | + inputList: InputList                | + playChallenge(): void                          |
|                     | + baseballGameDisplay: BaseballGameDisplay |                                                  |
|                     | + gamePlay: ArrayList<Integer>        |                                                  |
|                     | + level: int                          |                                                  |
|                     | + challenge: int                      |                                                  |
|                     | + strike: int                         |                                                  |
|                     | + ball: int                           |                                                  |
|                     | + out: int                            |                                                  |
| **AnswerList**      | + numList: List<Integer>              | + createList(int level): void                    |
|                     | + element: int                        | + getAnswerNumList(int index): int               |
|                     |                                        | + containAnswerNumList(int list): boolean        |
|                     |                                        | + printNumList(): void                           |
| **InputList**       | + numList: List<Integer>              | + getInputNumList(int index): int                |
|                     | + num: int                            | + size(): int                                    |
| **BaseballGameDisplay** | + gameContinue: boolean              | + displayHint(int strike, int ball, int out, int level): boolean |


## 애플리케이션 기능 구현
- **자리수 설정(레벨 선택)**<br>
  ![level.png](img%2Flevel.png)

- **숫자 야구 게임**<br>
  ![game.png](img%2Fgame.png)

- **게임 기록 보기**<br>
  ![history.png](img%2Fhistory.png)