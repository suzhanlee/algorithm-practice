package 프로그래머스.프로그래머스_구현;

import java.util.ArrayList;

public class 카펫 {

    static int outer;
    static int inner;
    static int x, y;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<Integer> answers = new ArrayList<>();
    static int[] answer;

    public static int[] solution(int brown, int yellow) {

        outer = brown + yellow;
        inner = yellow;

        for (int i = 1; i <= yellow; i++) {

            if (yellow % i == 0) {
                arrayList.add(i);
            }
        }

        for (int i = 0; i < arrayList.size() / 2 + 1; i++) {

            if (((arrayList.get(i) + 2) * (arrayList.get(arrayList.size() - (i + 1)) + 2))
                == outer) {
                answers.add(arrayList.get(i) + 2);
                answers.add(arrayList.get(arrayList.size() - (i + 1)) + 2);
                break;
            }

        }

        answer = new int[2];

        int max = Math.max(answers.get(0), answers.get(1));
        int min = Math.min(answers.get(0), answers.get(1));
        answer[0] = max;
        answer[1] = min;

        return answer;
    }

    public static void main(String[] args) {

        int[] answer = solution(24, 24);
        for (int i : answer) {
            System.out.println("i = " + i);

        }

    }

}
