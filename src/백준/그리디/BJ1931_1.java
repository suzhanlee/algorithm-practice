package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1931_1 {

    static int N;
    static PriorityQueue<Room> pq = new PriorityQueue<>();
    static int answer;

    static class Room implements Comparable<Room> {

        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

    public static void solution() {

        int tmp = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {

            Room poll = pq.poll();

            if (tmp <= poll.start) {
                tmp = poll.end;

                answer++;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Room(start, end));
        }

        solution();

        System.out.println(answer);


    }
}
