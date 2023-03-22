package stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 응급실 {

    static class Person {

        int num;
        int risk;

        public Person(int num, int risk) {
            this.num = num;
            this.risk = risk;
        }
    }

    public static int solution(int[] arr, int M) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Person poll = queue.poll();
            for (Person x : queue) {
                if (x.risk > poll.risk) {
                    queue.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                if (poll.num == M) {
                    answer++;
                    return answer;
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        System.out.println(응급실.solution(arr, M));
    }
}
