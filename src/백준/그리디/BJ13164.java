package 백준.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ13164 {

    static int N, K;
    static int[] arr;
    static int answer;
    static ArrayList<Integer> minusArr = new ArrayList<>();

    public static void solution() {

        for (int i = 1; i < N; i++) {
            minusArr.add(arr[i] - arr[i - 1]);
        }

        Collections.sort(minusArr);

        for (int i = 0; i < N - K; i++) {

            answer += minusArr.get(i);

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

        }

        solution();

        System.out.println(answer);

    }
}
