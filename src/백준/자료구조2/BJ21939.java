package 백준.자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BJ21939 {

    static int N, M;

    static class Problem implements Comparable<Problem> {

        int number;
        int difficulty;

        public Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty == o.difficulty) {
                return this.number - o.number;
            } else {
                return this.difficulty - o.difficulty;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        TreeSet<Problem> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(name, difficulty));
            map.put(name, difficulty);
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if (str.equals("add")) {
                int name = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                treeSet.add(new Problem(name, difficulty));
                map.put(name, difficulty);

            } else if (str.equals("solved")) {
                int name = Integer.parseInt(st.nextToken());
                treeSet.remove(new Problem(name, map.get(name)));
                map.remove(name);

            } else if (str.equals("recommend")) {
                int number = Integer.parseInt(st.nextToken());
                if (number == 1) {
                    int number1 = treeSet.last().number;
                    System.out.println(number1);

                } else {
                    int number1 = treeSet.first().number;
                    System.out.println(number1);

                }
            }
        }
    }
}
