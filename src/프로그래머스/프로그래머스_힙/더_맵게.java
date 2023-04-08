package 프로그래머스.프로그래머스_힙;

import java.util.PriorityQueue;

public class 더_맵게 {

    //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
    // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

    public static int solution(int[] scoville, int K) {

        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int aScoville : scoville) {
            queue.offer(aScoville);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            int a = queue.poll();
            int b = queue.poll();

            int result = a + (b * 2);

            queue.offer(result);
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {

        int[] ints = {1, 2, 3, 9, 10, 12};
        int solution = solution(ints, 7);
        System.out.println(solution);

    }

}
