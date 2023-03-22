package greedyalorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최대수입스케쥴 {

    static int N;
    static ArrayList<Lecture> arrayList = new ArrayList<>();
    static int answer;
    static int[] visited = new int[100001];

    static class Lecture implements Comparable<Lecture> {

        int money;
        int day;

        public Lecture(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.day == o.day) {
                return o.money - this.money;
            } else {
                return this.day - o.day;
            }
        }
    }

    public static void solution() {

//        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arrayList.size(); i++) {

            if (visited[arrayList.get(i).day] == 0) {
                visited[arrayList.get(i).day] = 1;
                answer += arrayList.get(i).money;
//                max = Math.max(arrayList.get(i).money, max);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            arrayList.add(new Lecture(money, day));
        }

        Collections.sort(arrayList, Lecture::compareTo);
        solution();
        System.out.println(answer);


    }

}
