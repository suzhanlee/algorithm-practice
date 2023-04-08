package 프로그래머스.프로그래머스_힙;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크_컨트롤러 {

    public int solution(int[][] jobs) {

        int answer = 0;
        int end = 0;
        int cnt = 0;

        Arrays.sort(jobs, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int idx = 0;

        while (cnt != jobs.length) {

            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx]);
                idx++;
            }

            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {

                int[] tmp = pq.poll();
                answer += (tmp[1] + end - tmp[0]);
                end += tmp[1];
                cnt++;
            }
        }

        return (int) Math.floor(answer / jobs.length);
    }
}