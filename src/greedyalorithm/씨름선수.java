package greedyalorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 씨름선수 {

    static ArrayList<Person> ps;
    static int N;
    static int answer;

    static class Person implements Comparable<Person> {

        int height;
        int weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            if (this.height == o.height) {
                return -(this.weight - o.weight);
            } else {
                return -(this.height - o.height);
            }
        }
    }

    public static void solution() {

        int max = Integer.MIN_VALUE;

        for (Person p : ps) {

            if (max < p.weight) {
                max = p.weight;
                answer++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ps = new ArrayList<Person>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            ps.add(new Person(height, weight));

        }

        Collections.sort(ps, Person::compareTo);

        solution();

        System.out.println(answer);
    }
}



