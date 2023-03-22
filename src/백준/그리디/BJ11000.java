package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11000 {

    static int N;
    static ArrayList<Room> rooms = new ArrayList<>();
    static PriorityQueue<Integer> pQ = new PriorityQueue();

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
        pQ.offer(rooms.get(0).end);

        for (int i = 1; i < rooms.size(); i++) {

            if (pQ.peek() <= rooms.get(i).start) {
                pQ.poll();
            }
            pQ.offer(rooms.get(i).end);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            rooms.add(new Room(start, end));

        }

        rooms.sort(Room::compareTo);

        solution();

        System.out.println(pQ.size());


    }
}
