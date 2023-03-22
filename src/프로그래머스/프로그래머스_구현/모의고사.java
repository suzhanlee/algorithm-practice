package 프로그래머스.프로그래머스_구현;

import java.util.ArrayList;

public class 모의고사 {

    static int[] answer = {};
    static int[] first = {1, 2, 3, 4, 5};
    static int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    static int answer1, answer2, answer3;

    public int[] solution(int[] answers) {

        for (int i = 0; i < answers.length; i++) {

            if (answers[i] == first[i % 5]) {
                answer1++;
            }

            if (answers[i] == second[i % 8]) {
                answer2++;
            }

            if (answers[i] == third[i % 10]) {
                answer3++;
            }

        }

        int max = Math.max(Math.max(answer1, answer2), answer3);

        ArrayList<Integer> arrayList = new ArrayList<>();

        if (answer1 == max) {
            arrayList.add(1);
        }

        if (answer2 == max) {
            arrayList.add(2);
        }

        if (answer3 == max) {
            arrayList.add(3);
        }

        answer = new int[arrayList.size()];

        for (int i = 0; i < arrayList.size(); i++) {

            answer[i] = arrayList.get(i);

        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
