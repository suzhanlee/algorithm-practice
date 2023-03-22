package greedyalorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class 회의실배정 {

    static int N;
    static int answer;
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

            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }

    public static void solution() {

        int end = 0;
        for (Room room : rooms) {
            if (room.start >= end) {
                answer++;
                end = room.end;
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

            rooms.add(new Room(start, end));
        }

        Collections.sort(rooms, Room::compareTo);

        solution();

        System.out.println(answer);

    }
}
