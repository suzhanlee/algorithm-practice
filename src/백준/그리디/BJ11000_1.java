package 백준.그리디;

import static java.util.Collections.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11000_1 {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<Room> rooms = new ArrayList<>();

    static class Room implements Comparable<Room> {

        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

    public static void solution() {

        pq.offer(rooms.get(0).end);

        for (int i = 1; i < rooms.size(); i++) {

            if (pq.peek() <= rooms.get(i).start) {

                pq.poll();
            }
            pq.offer(rooms.get(i).end);

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            rooms.add(new Room(s, t));

        }

        sort(rooms);

        solution();
        System.out.println(pq.size());


    }
}
