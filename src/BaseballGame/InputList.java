package BaseballGame;

import java.util.ArrayList;
import java.util.List;

public class InputList {
    private List<Integer> numList = new ArrayList<>();

    protected void setInputNumList(String inputNum) {
        numList.clear(); // List 초기화
        for (int i = 0; i < inputNum.length(); i++) {
            int num = (int) inputNum.charAt(i) - 48;
            numList.add(num);
        }
    }

    protected int getInputNumList(int index) {
        return numList.get(index);
    }

    protected int size() {
        return numList.size();
    }
}
