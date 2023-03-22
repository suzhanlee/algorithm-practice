package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ20053 {

    static int T;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void solution(ArrayList<Integer> arrayList) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int x : arrayList) {
            max = Math.max(max, x);
            min = Math.min(min, x);
        }
        sb.append(min).append(" ").append(max).append('\n');
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arrayList.add(Integer.parseInt(st.nextToken()));
            }
            solution(arrayList);
        }

        System.out.println(sb);

    }

}
