package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BJ1744 {

    static int N;
    static PriorityQueue<Integer> pqPlus = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> pqMinus = new PriorityQueue<>();
    static int answer;
    static int zeroCnt;
    static int oneCnt;
    // 기본적으로 음수는 묶지 않지만, 0이 있으면 음수를 찾고 음수가 있다면 묶는다.
    // 1과 1이 있다면 묶지 않고 더한다

    public static void solution() {

        while (pqPlus.size() > 1) { // N == 2 이상

            Integer poll = pqPlus.poll();
            Integer poll1 = pqPlus.poll();

            answer += (poll1 * poll);

        }

        if (!pqPlus.isEmpty()) {
            answer += pqPlus.poll();
        }

        while (pqMinus.size() > 1) { // N == 2 이상

            Integer poll = pqMinus.poll();
            Integer poll1 = pqMinus.poll();

            answer += (poll1 * poll);
        }

        if (!pqMinus.isEmpty()) {
            if (zeroCnt >= 1) {
                answer += 0;
            } else {
                answer += pqMinus.poll();
            }
        }

        if (oneCnt >= 1) {
            answer += oneCnt;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                zeroCnt++;
            } else if (x == 1) {
                oneCnt++;
            } else if (x < 0) {
                pqMinus.offer(x);
            } else {
                pqPlus.offer(x);
            }

        }

        solution();
        System.out.println(answer);


    }

}
