package greedyalorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 결혼식 {

    static int N;
    static ArrayList<Time> arrayList = new ArrayList<>();
    static int answer;

    static class Time implements Comparable<Time> {

        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return this.state - o.state;
            } else {
                return this.time - o.time;
            }
        }
    }

    public static void solution() {

        int cnt = 0;

        for (Time time : arrayList) {
            if (time.state == 's') {
                cnt++;
            } else {
                cnt--;
            }

            answer = Math.max(answer, cnt);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList.add(new Time(start, 's'));
            arrayList.add(new Time(end, 'e'));
        }

        Collections.sort(arrayList, Time::compareTo);

        solution();

        System.out.println(answer);


    }

}
