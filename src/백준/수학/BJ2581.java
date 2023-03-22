package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2581 {

    static int N, M;
    static int answer;
    static ArrayList<Integer> array = new ArrayList<>();

    public static void solution() {
        int cnt = 0;

        for (int i = N; i <= M; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                cnt++;
            }

            if (cnt == i - 2) {
                answer += i;
                array.add(i);
            }
            cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        solution();

        if (answer == 0) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
            System.out.println(array.get(0));
        }
    }
}

