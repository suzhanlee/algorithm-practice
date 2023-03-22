package 백준.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ21921 {

    static int[] arr;
    static int N, X;

    static int window;
    static int answer = Integer.MIN_VALUE;
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void solution() {

        for (int i = 0; i < X; i++) {
            window = window + arr[i];
            answer = Math.max(answer, window);
        }
        map.put(window, map.getOrDefault(window, 0) + 1);

        for (int i = X; i < N; i++) {
            window = window + arr[i] - arr[i - X];
            map.put(window, map.getOrDefault(window, 0) + 1);
            answer = Math.max(answer, window);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }
        solution();

        if (answer == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(answer);
            System.out.print(map.get(answer));
        }
    }
}
