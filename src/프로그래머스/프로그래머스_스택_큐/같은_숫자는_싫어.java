package 프로그래머스.프로그래머스_스택_큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 같은_숫자는_싫어 {

    static int[] answer = {};
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> answers = new ArrayList<>();


    public static int[] solution(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int value = -1;

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();

            if (value != poll) {
                answers.add(poll);
                value = poll;
            }

        }

        answer = new int[answers.size()];

        for (int i = 0; i < answers.size(); i++) {

            answer[i] = answers.get(i);

        }

        return answer;


    }

    public static void main(String[] args) {

    }
}
