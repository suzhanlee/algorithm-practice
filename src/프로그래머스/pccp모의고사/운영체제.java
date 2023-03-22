package 프로그래머스.pccp모의고사;


import java.util.Arrays;
import java.util.PriorityQueue;

public class 운영체제 {

    static long[] answer = new long[11];

    public long[] solution(int[][] program) {
        // 우선순위
        PriorityQueue<int[]> pq1 = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 순서대로
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });

        pq2.addAll(Arrays.asList(program));

        run(pq1, pq2);

        return answer;
    }

    public static void run(PriorityQueue<int[]> pq1, PriorityQueue<int[]> pq2) {
        long time = -1;
        int run = 0;
        while (true) {

            if (pq1.isEmpty() && pq2.isEmpty() && run == 0) {
                break;
            }
            time++;
            if (run > 0) {
                run--;
            }

            answer[0] = time;
        }


    }
}


