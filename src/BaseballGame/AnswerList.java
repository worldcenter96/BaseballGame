package BaseballGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerList {

    private List<Integer> numList = new ArrayList<>();

    protected void createList(int level) {
        numList.clear(); // List 초기화
        for (int i = 1; i < 10; i++) {
            numList.add(i);
        }

        Collections.shuffle(numList);
        // 필요없는 인덱스 삭제
        for (int i = 8; i >= level; i--) {
            numList.remove(i);
        }
    }

    protected int getAnswerNumList(int index) {
        return numList.get(index);
    }

    protected boolean containAnswerNumList(int list) {
        return numList.contains(list);
    }

    protected void printNumList() {
        for (int i = 0; i < numList.size(); i++) {
            int element = numList.get(i);
            System.out.println(element);

        }
    }
}
