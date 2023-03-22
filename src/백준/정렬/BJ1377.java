package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1377 {

    static int N;
    static ArrayList<Component> components = new ArrayList<>();
    static int answer;

    static class Component implements Comparable<Component> {

        int num;
        int index;

        public Component(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(Component o) {
            if (this.num - o.num > 0) {
                return 1;
            } else if (this.num == o.num) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            components.add(new Component(Integer.parseInt(br.readLine()), i));
        }

        Collections.sort(components);

        int max = 0;

        for (int i = 0; i < components.size(); i++) {

            if (max < components.get(i).index - i) {
                max = components.get(i).index - i;
            }
        }

        System.out.println(max + 1);


    }

}
